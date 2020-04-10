package servlet.filter;

import org.hibernate.Session;
import service.UserService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter("/admin/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        HttpSession session = req.getSession();
        String role = (String) session.getAttribute("role");

        if (role != null) {
            if (role.equals("admin")) {
                filterChain.doFilter(req, resp);
            } else{
                resp.sendRedirect("/user");
            }
        } else {
            session.setAttribute("message", "Отказано в доступе");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    public void destroy() {

    }
}
