package pl.sda.urbaniec.servlet;

import pl.sda.urbaniec.model.Address;
import pl.sda.urbaniec.model.Cart;
import pl.sda.urbaniec.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/buy-data")
public class BuyDataServlet extends HttpServlet {
    private static final long serialVersionUID = 8874229295023177928L;
    Cart cart;

    @Override
    protected void doPost(final HttpServletRequest httpServletRequest,
                          final HttpServletResponse httpServletResponse) throws ServletException, IOException {
        final Cart cart = (Cart) httpServletRequest.getSession().getAttribute("cart");
        final String name = httpServletRequest.getParameter("name");
        final String surname = httpServletRequest.getParameter("surname");
        final String street = httpServletRequest.getParameter("street");
        final String streetNumber = httpServletRequest.getParameter("streetNumber");
        final String city = httpServletRequest.getParameter("city");
        final String code = httpServletRequest.getParameter("code");
        final Order order = new Order(name, surname, new Address(street, city, code, streetNumber), cart);
        httpServletRequest.getSession().setAttribute("order", order);
        httpServletRequest.getRequestDispatcher("/buy.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse) throws ServletException, IOException {
        httpServletRequest.setAttribute("name", "Kasia Urbaniec");
        httpServletRequest.getRequestDispatcher("/buy-data.jsp")
                .forward(httpServletRequest, httpServletResponse);
    }


    @Override
    public void init() throws ServletException {
        super.init();
    }
}
