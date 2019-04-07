package pl.sda.urbaniec.servlet;

import pl.sda.urbaniec.DAO.ProductDB;
import pl.sda.urbaniec.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/viewProduct")
public class ProductViewServlet extends HttpServlet {
    private static final long serialVersionUID = 2093115960367543691L;
    private ProductDB list;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");
        final Long id = Long.parseLong(httpServletRequest.getParameter("id"));
        final Optional<Product> product = this.list.getProductById(id);
        httpServletRequest.setAttribute("newProduct", product);
        final Cookie cookie = new Cookie("lastView", id.toString());
        httpServletResponse.addCookie(cookie);
        httpServletRequest.getRequestDispatcher("/viewProduct.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        this.list = ProductDB.getInstance();
        super.init();
    }
}
