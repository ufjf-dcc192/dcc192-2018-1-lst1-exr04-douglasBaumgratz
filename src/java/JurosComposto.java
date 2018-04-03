/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author douglas
 */
@WebServlet(urlPatterns = {"/JurosComposto.html"})
public class JurosComposto extends HttpServlet {

    double valorInicial;
    double qtdMeses;
    double taxaJuros;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String parametroValorInicial = request.getParameter("valInicial");
        String parametroQtdMeses = request.getParameter("qtdMeses");
        String parametroTaxaJuros = request.getParameter("taxaJuros");

        if (!"".equals(parametroValorInicial) && parametroValorInicial != null) {
            valorInicial = Double.parseDouble(parametroValorInicial);
        } else {
            valorInicial = 5000.0;
        }
        if (!"".equals(parametroQtdMeses) && parametroQtdMeses != null) {
            qtdMeses = Double.parseDouble(parametroQtdMeses);
        } else {
            qtdMeses = 12;
        }
        if (!"".equals(parametroTaxaJuros) && parametroTaxaJuros != null) {
            taxaJuros = Double.parseDouble(parametroTaxaJuros)/100;
        } else {
            taxaJuros = 0.01;
        }

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosComposto</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form>");
            out.println("<label> Valor inicial: <input name = 'valInicial'/> </label>");
            out.println("<label> Número de meses: <input name = 'qtdMeses'/> </label>");
            out.println("<label> Taxa de Juros: <input name = 'taxaJuros'/> </label>");
            out.println("<input type = 'submit'/>");
            out.println("<input type = 'reset'/>");

            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

}
