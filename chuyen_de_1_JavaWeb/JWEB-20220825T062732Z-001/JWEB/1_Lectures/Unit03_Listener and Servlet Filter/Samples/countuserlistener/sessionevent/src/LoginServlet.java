import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("username");
        out.print("Welcome " + userName);

        HttpSession session = request.getSession();
        session.setAttribute("uname", userName);

        ServletContext ctx = getServletContext();
        int t = (Integer) ctx.getAttribute("totalusers");
        int c = (Integer) ctx.getAttribute("currentusers");
        out.print("<br>Total users= " + t);
        out.print("<br>Current users= " + c);

        out.print("<br><a href='logout'>logout</a>");

        out.close();
    }

}
