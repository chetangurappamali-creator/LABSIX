//6a. Build a servlet program to find the factorial of a number using HTML with step by step procedure.
package servlet;



import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/factorial")
public class Factorial extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            int number = Integer.parseInt(request.getParameter("number"));

            if (number < 0) {
                throw new IllegalArgumentException("Number cannot be negative");
            }

            long factorial = 1;
            String steps = number + "! = ";

            for (int i = number; i >= 1; i--) {
                factorial *= i;
                steps += i;
                if (i != 1) {
                    steps += " × ";
                }
            }

            if (number == 0) {
                factorial = 1;
                steps = "0! = 1";
            } else {
                steps += " = " + factorial;
            }

            out.println("<html><body>");
            out.println("<h2>Factorial Result</h2>");
            out.println("<p>Number: " + number + "</p>");
            out.println("<p>Factorial: " + factorial + "</p>");
            out.println("<p>" + steps + "</p>");
            out.println("<br><a href='index.html'>Back</a>");
            out.println("</body></html>");

        } catch (Exception e) {
            out.println("<html><body>");
            out.println("<h3>Error: " + e.getMessage() + "</h3>");
            out.println("<a href='index.html'>Try Again</a>");
            out.println("</body></html>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("index1.html");
    }
}

