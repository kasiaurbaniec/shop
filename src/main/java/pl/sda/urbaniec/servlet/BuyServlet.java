package pl.sda.urbaniec.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/buy")
public class BuyServlet extends HttpServlet {
    private static final long serialVersionUID = 8628375877592136419L;

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest, final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        super.doPost(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        super.init();
    }
}
