package by.tms.web.servlet;

import by.tms.entity.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {
    private final Calculator calc = new Calculator();
    private final ArrayList<String> list= new ArrayList<String>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double first=Double.parseDouble(req.getParameter("firstNumber"));
        double second= Double.parseDouble(req.getParameter("secondNumber"));
        String sign = req.getParameter("sign");
        calc.setFirst(first);
        calc.setSecond(second);
        calc.setSign(sign);
        req.setAttribute("result",calc.calculation());
        list.add(first+sign+second+" = "+calc.getResult());
        req.setAttribute("history",list);
        req.getRequestDispatcher("/pages/calc.jsp").forward(req,resp);
    }
}
