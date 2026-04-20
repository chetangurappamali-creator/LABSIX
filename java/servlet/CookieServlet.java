
//6b. Build a servlet program to create a cookie to get your name through text box and press submit button(
//through HTML) to display the message by greeting Welcome back your name ! , you have visited this page
//n times ( n = number of your visit ) and demonstrate the expiry of cookie also.
package servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    int count = 0;

    // GET method
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("userName");

        // Create cookie if user enters name
        if (userName != null && !userName.isEmpty()) {
            Cookie userCookie = new Cookie("user", userName);
            userCookie.setMaxAge(60); // 1 minute
            response.addCookie(userCookie);
        }

        // Read cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("user")) {
                    existingUser = c.getValue();
                    break;
                }
            }
        }

        // Output
        out.println("<html><body>");

        if (existingUser != null) {
            count++;
            out.println("<h2 style='color:blue'>Welcome back, " + existingUser + "</h2>");
            out.println("<h3 style='color:magenta'>You have visited this page " + count + " times</h3>");

            out.println("<form action='CookieServlet' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");

        } else {
            out.println("<h2 style='color:red'>Welcome Guest!</h2>");
            out.println("<form action='CookieServlet' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Login'>");
            out.println("</form>");
        }

        out.println("</body></html>");
    }

    // POST method (Logout)
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cookie cookie = new Cookie("user", "");
        cookie.setMaxAge(0); // delete cookie
        response.addCookie(cookie);

        response.sendRedirect("CookieServlet");
    }
}



