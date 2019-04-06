package pl.sda.urbaniec.servlet;

import pl.sda.urbaniec.DAO.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addProduct")
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = -6649589278013879040L;
    private ProductDB list;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/addProduct.jsp")
                .forward(httpServletRequest, httpServletResponse);

    }

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest,
                          final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final String name = httpServletRequest.getParameter("name");
        final String description = httpServletRequest.getParameter("description");
        final Long price = Long.valueOf(httpServletRequest.getParameter("price"));
        final String category = httpServletRequest.getParameter("newCategory");
        final String href = httpServletRequest.getParameter("photoUrl");
        final Long newProduct = this.list.createProduct(name, description, price, category, href);

        httpServletResponse.sendRedirect("/viewProduct?id=" + newProduct);
    }

    @Override
    public void init() throws ServletException {
        this.list = ProductDB.getInstance();
        super.init();
    }
}
