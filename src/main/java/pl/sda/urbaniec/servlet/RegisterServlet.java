package pl.sda.urbaniec.servlet;

import pl.sda.urbaniec.DAO.UserDB;
import pl.sda.urbaniec.model.Role;
import pl.sda.urbaniec.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 8124902936551590082L;
    private UserDB db;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.getRequestDispatcher("/register.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest,
                          final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String email = httpServletRequest.getParameter("email");
        final String password = httpServletRequest.getParameter("password");
        final String login = httpServletRequest.getParameter("login");
        String result = "null";
        if (!email.isEmpty() && (!password.isEmpty()) && (!login.isEmpty())) {
            boolean option = true;
            for (final User u : this.db.getUserList()) {
                if ((u.getLogin().equals(login)) || (u.getEmail().equals(email))) {
                    option = false;
                    result = "login or email occupied";
                    httpServletRequest.setAttribute("result", result);
                    httpServletRequest.getRequestDispatcher("/register.jsp")
                            .forward(httpServletRequest, httpServletResponse);
                }
            }
            if (option) {
                this.db.createUser(email, password, login, Arrays.asList(Role.USER));
                result = "new user created";

                httpServletResponse.sendRedirect("/database");

            }

        } else {
            result = "you left some input empty";
            httpServletRequest.setAttribute("result", result);
            httpServletRequest.getRequestDispatcher("/register.jsp")
                    .forward(httpServletRequest, httpServletResponse);

        }


    }

    @Override
    public void init() throws ServletException {
        this.db = UserDB.getInstance();
        super.init();
    }
}
