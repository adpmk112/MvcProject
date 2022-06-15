package ace.project.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.dao.StudentDao;
import ace.project.model.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet("/StudentCreateController")
public class StudentCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDao dao = new StudentDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentCreateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Student daoStudent = dao.newStudent(dao.getStudent(request),request);
		dao.saveStudent(request, daoStudent);
		//request.getRequestDispatcher("studentInfo.jsp").include(request, response);
		response.sendRedirect("http://localhost:8080/MvcProject/studentInfo.jsp");  
	}

}
