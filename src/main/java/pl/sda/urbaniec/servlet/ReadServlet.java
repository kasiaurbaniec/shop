package pl.sda.urbaniec.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/read")
public class ReadServlet extends HttpServlet {


    private static final long serialVersionUID = -7459021674255330428L;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");
        httpServletRequest.getRequestDispatcher("/read.jsp")
                .forward(httpServletRequest, httpServletResponse);

    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
