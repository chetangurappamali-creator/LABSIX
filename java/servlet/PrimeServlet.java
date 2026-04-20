
package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/PrimeServlet")
public class PrimeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int num = Integer.parseInt(request.getParameter("num"));
            boolean isPrime = true;

            if (num <= 1) {
                isPrime = false;
            } else {
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            out.println("<html><body>");
            out.println("<h2>Prime Number Result</h2>");
            out.println("<p>Number: " + num + "</p>");

            if (isPrime) {
                out.println("<h3 style='color:green'>It is a Prime Number</h3>");
            } else {
                out.println("<h3 style='color:red'>It is NOT a Prime Number</h3>");
            }

            out.println("<br><a href='index.html'>Check Again</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<h3>Error: Invalid Input</h3>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("indexx.html");
    }
}

