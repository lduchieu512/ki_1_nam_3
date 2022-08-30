package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.dao.UserDao;
import fa.training.entities.User;
import fa.training.utils.Log4J;

/**
 * class handle request login and display login page.
 * 
 * @author FA
 *
 */
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log4J.getLogger().info("Running on doPost method of LoginServlet");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = new User(userName, password);
        try {
            if (userDao.login(user)) {
                HttpSession session = request.getSession();
                // if login successfully, save session user, who have just logined
                session.setAttribute("userLogin", user);
                response.sendRedirect(request.getContextPath() + "/home");
            } else {
                request.setAttribute("userRegister", user);
                request.setAttribute("loginFail", "User name or password is incorrect");
                request.getRequestDispatcher("/views/login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            Log4J.getLogger().error("Class not found exception in method doPost of LoginServlet");
        } catch (SQLException e) {
            Log4J.getLogger().error("SQL exception in method doPost of LoginServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Log4J.getLogger().info("Running on doGet method of LoginServlet");
        request.getRequestDispatcher("views/login.jsp").forward(request, response);
    }

}
