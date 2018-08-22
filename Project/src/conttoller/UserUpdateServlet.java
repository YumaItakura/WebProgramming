package conttoller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class UserUpdateServlet
 */
@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");

		String id = request.getParameter("id");
		UserDao userDao = new UserDao();
		User user = userDao.findById(id);
		request.setAttribute("user", user);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf8");

		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("passwordConfirm");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String updateDate = request.getParameter("updateDate");

		if (name.equals("") || birthDate.equals("")) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			User user = new User(loginId, name, birthDate);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
		}
		if (!password.equals(passwordConfirm)) {
			request.setAttribute("errMsg", "入力された内容は正しくありません");
			User user = new User(loginId, name, birthDate);
			request.setAttribute("user", user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UserUpdate.jsp");
			dispatcher.forward(request, response);
		}

		if (password.equals("") && passwordConfirm.equals("")) {
			UserDao userDao = new UserDao();
			userDao.Update(loginId, name, birthDate);
			response.sendRedirect("UserListServlet");
		} else {
			UserDao userDao = new UserDao();
		userDao.Update(loginId, password, name, birthDate);
		response.sendRedirect("UserListServlet");
		}

	}
}
