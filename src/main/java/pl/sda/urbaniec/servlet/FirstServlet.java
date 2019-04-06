package pl.sda.urbaniec.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/home")
public class FirstServlet extends HttpServlet {


    private static final long serialVersionUID = 2031282884852831945L;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
//        PrintWriter writer = httpServletResponse.getWriter(); wypisywanie
//        writer.print("Hello World");
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");//w ten object możemy wrzucić cokolwiek

        httpServletRequest.getRequestDispatcher("/index.jsp")
                .forward(httpServletRequest, httpServletResponse);

    }
}
