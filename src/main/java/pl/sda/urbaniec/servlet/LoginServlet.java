package pl.sda.urbaniec.servlet;

import pl.sda.urbaniec.DAO.UserDB;
import pl.sda.urbaniec.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = -4424558722641913551L;
    private UserDB db;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");
        httpServletRequest.getRequestDispatcher("/login.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest,
                          final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String login = httpServletRequest.getParameter("login");
        final String password = httpServletRequest.getParameter("password");
        final String result;
        if ((!password.isEmpty()) && (!login.isEmpty())) {
            final Optional<User> optUser = this.db.getUserList().stream()
                    .filter(user -> user.getLogin().equals(login))
                    .filter(user -> user.getPassword().equals(password))
                    .findFirst();
            if (optUser.isPresent()) {
                httpServletRequest.getSession().setAttribute("loggedUser", optUser.get());
                httpServletResponse.sendRedirect("/database");

            } else {
                result = "wrong login or password";
                httpServletRequest.setAttribute("result", result);
                httpServletRequest.getRequestDispatcher("/login.jsp")
                        .forward(httpServletRequest, httpServletResponse);
            }
        } else {
            result = "you left some input empty";
            httpServletRequest.setAttribute("result", result);
            httpServletRequest.getRequestDispatcher("/login.jsp")
                    .forward(httpServletRequest, httpServletResponse);
        }
    }

    @Override
    public void init() throws ServletException {
        this.db = UserDB.getInstance();
        super.init();
    }
}
//wylogowanie
/*
do login servlet i register servlet dodaj logout servlet
 */
//httpServletRequest.getSession().invaliduate