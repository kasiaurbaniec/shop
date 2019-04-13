package pl.sda.urbaniec.servlet;

import pl.sda.urbaniec.DAO.ProductDB;
import pl.sda.urbaniec.model.Cart;
import pl.sda.urbaniec.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(urlPatterns = "/addToCart")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 6001952752644176606L;
    private ProductDB list;

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest,
                          final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");
        final Long id = Long.parseLong(httpServletRequest.getParameter("id"));
        final Integer quantity = Integer.parseInt(httpServletRequest.getParameter("quantity"));
        final Optional<Product> product = this.list.getProductById(id);
        Cart cart = (Cart) httpServletRequest.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        if (product.isPresent()) {
            cart.updateQuantity(product.get(), quantity);
            httpServletRequest.getSession().setAttribute("cart", cart);
        }
        httpServletRequest.getRequestDispatcher("/cart.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");
        httpServletRequest.getRequestDispatcher("/cart.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        this.list = ProductDB.getInstance();
        super.init();
    }
}
