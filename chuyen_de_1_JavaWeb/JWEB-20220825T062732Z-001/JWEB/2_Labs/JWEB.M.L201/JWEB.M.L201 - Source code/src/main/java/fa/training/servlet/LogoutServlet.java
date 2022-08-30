package fa.training.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.utils.Log4J;

/**
 * class handle request log out
 * 
 * @author FA
 *
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log4J.getLogger().info("Logging out");
        // remove session userLogin
        request.getSession().removeAttribute("userLogin");
        // redirect to /login
        response.sendRedirect(request.getContextPath() + "/login");
    }
}
