package ru.geekbrains.java.ee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet (name = "Orders", urlPatterns = "/Orders")
public class Orders extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(ru.geekbrains.java.ee.Orders.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("---doGet---");

//        resp.getWriter().println("ContextPath: " + req.getContextPath());
//        resp.getWriter().println("User agent: " + req.getHeader("User-agent"));
//        logger.info("User agent: {}", req.getHeader("User-agent"));
//        resp.sendRedirect("https://ya.ru");
//        getServletContext().getRequestDispatcher("/index.html").forward(req, resp);
        
//        resp.getWriter().println("<p>Response body from servlet</p>");
//        getServletContext().getRequestDispatcher("/header.html").include(req, resp);
//        getServletContext().getRequestDispatcher("/index.html").include(req, resp);
//        getServletContext().getRequestDispatcher("/footer.html").include(req, resp);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "first", 1L));
        products.add(new Product(2, "second", 2L));
        products.add(new Product(3, "third", 3L));

        resp.getWriter().println("id title price");
        for (Product product : products) {
            resp.getWriter().println(product.getId() + "   " + product.getTitle() + "   " + product.getPrice());
        }
    }

    @Override
    public void destroy() {
        logger.info("Servlet destroyed");
        super.destroy();
    }
}
