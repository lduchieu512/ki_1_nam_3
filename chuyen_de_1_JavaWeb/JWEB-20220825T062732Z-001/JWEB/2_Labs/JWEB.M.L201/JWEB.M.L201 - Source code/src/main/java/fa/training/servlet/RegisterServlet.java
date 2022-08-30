package fa.training.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.UserDao;
import fa.training.entities.User;
import fa.training.utils.Constants;
import fa.training.utils.Log4J;

@WebServlet(urlPatterns = "/register", description = "This is RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static UserDao userDao = new UserDao();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get data from input with request.getParameter()
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		// set data for user
		User user = new User(firstName, lastName, email, userName, password);
		try {
			// call method registerUser to insert user into DB
			if (userDao.registerUser(user)) {
				// send a attribute name as "userRegister" to register-user-process.jsp page
				request.setAttribute("userRegister", user);
				//forward to register-user-process.jsp page
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			} else {
				// send a attribute name as "message" to register-user.jsp page
				request.setAttribute("message", Constants.REGISTER_FAIL_MESSAGE);
				//forward to register-user.jsp page
				request.getRequestDispatcher("/views/register-user.jsp").forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// log error if exception occurs
			Log4J.getLogger().error("An exception occurs while register user");
		}
	}
	
	@Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Log4J.getLogger().info("Running on method doGet of Register Servlet");
    request.getRequestDispatcher("views/register-user.jsp").forward(request, response);
  }
	
}
