package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    private StorageService store;

    @Override
    public void init() throws ServletException {
        store = StorageService.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/del.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = store.findByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                store.deleteUser(user);
                req.getSession().invalidate();
                resp.sendRedirect("/");
                return;
            } else {
                req.setAttribute("message", "Wrong password!");
            }
        } else {
            req.setAttribute("message", "User not found!");
        }
        getServletContext().getRequestDispatcher("/pages/del.jsp").forward(req, resp);
    }
}
