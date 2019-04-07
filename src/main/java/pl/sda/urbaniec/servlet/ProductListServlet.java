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
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/database")
public class ProductListServlet extends HttpServlet {
    private static final long serialVersionUID = 4421739000026183232L;
    private ProductDB list;

    @Override
    protected void doGet(final HttpServletRequest httpServletRequest,
                         final HttpServletResponse httpServletResponse)
            throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");

        final String category = httpServletRequest.getParameter("category"); //to ma się nazywać tak samo jak w jsp
        List<Product> products = this.list.getProductList();
        if (category != null) {
            products = products.stream()
                    .filter(x -> x.getCategories().contains(category))
                    .collect(Collectors.toList());
        }
        for (final Cookie cookie : httpServletRequest.getCookies()) {
            if (cookie.getName().equals("lastView")) {
                final Long id = Long.parseLong(cookie.getValue());
                final Optional<Product> advert = this.list.getProductById(id);
                httpServletRequest.setAttribute("advert", advert);
            }
        }

        httpServletRequest.setAttribute("products", products);//tylko wyfiltrowana lista
        httpServletRequest.getRequestDispatcher("/database.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    public void init() throws ServletException {
        this.list = ProductDB.getInstance();
        super.init();
    }
}
