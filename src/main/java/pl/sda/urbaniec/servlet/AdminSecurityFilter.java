package pl.sda.urbaniec.servlet;


import pl.sda.urbaniec.model.Role;
import pl.sda.urbaniec.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminSecurityFilter", servletNames = {"addProductServlet"})
public class AdminSecurityFilter implements Filter {

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest servletRequest,
                         final ServletResponse servletResponse,
                         final FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest servletReq = (HttpServletRequest) servletRequest;
        final HttpServletResponse servletRes = (HttpServletResponse) servletResponse;
        final User userLogged = (User) servletReq.getSession().getAttribute("loggedUser");
        if (userLogged != null && userLogged.getRole().contains(Role.ADMIN)) {
            filterChain.doFilter(servletReq, servletRes);
        } else {
            servletRes.sendRedirect("/database");
        }

    }

    @Override
    public void destroy() {

    }
}
