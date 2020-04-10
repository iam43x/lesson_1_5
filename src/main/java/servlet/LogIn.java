package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/")
public class LogIn extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        req.getSession().setAttribute("message", "Введите логин и пароль");
        String login = (String) session.getAttribute("login");
        String password = (String) session.getAttribute("password");
        String role = (String) session.getAttribute("role");
        if (login != null && password != null) {
            try {
                if (role.equals("admin")) {
                    resp.sendRedirect("/admin");
                } else if (role.equals("user")) {
                    resp.sendRedirect("/user");
                } else {
                    req.getSession().setAttribute("message", "Неверный логин или пароль");
                    req.getRequestDispatcher("login.jsp").forward(req, resp);
                }
            } catch (Exception e) {
                e.printStackTrace();
                req.getSession().setAttribute("message", "Неверный логин или пароль");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        try {
            String role = UserService.getInstance().availableUser(login, password);
            if (role != null) {
                session.setAttribute("login", login);
                session.setAttribute("password", password);
                session.setAttribute("role", role);
            }
            if (login != null && password != null && role.equals("admin")) {
                resp.sendRedirect("/admin");
            } else if (role.equals("user")) {
                resp.sendRedirect("/user");
            } else {
                req.getSession().setAttribute("message", "Неверный логин или пароль");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.getSession().setAttribute("message", "Неверный логин или пароль");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}
