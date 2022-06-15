package ace.project.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.function.AutoId;
import ace.project.model.User;
import ace.project.model.UserInfo;

/**
 * Servlet implementation class UserDao
 */
@WebServlet("/UserDao")
public class UserDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	UserInfo info = new UserInfo();
	AutoId auto = new AutoId();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public User getUser(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new User();
	}
    
    public User newUser(User user,HttpServletRequest request) {
    	user.setId(auto.increment()); 
    	user.setName(request.getParameter("name")); 
		return user; 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void saveUser(HttpServletRequest request,User user) {
		// TODO Auto-generated method stub
		info.addUser(user);
		request.getServletContext().setAttribute("userList", info.getUserList());
	}
    
    @SuppressWarnings("unchecked")
	public void searchUserById(HttpServletRequest request) {
    	List<User>updateList = new ArrayList<>();
    	updateList = (List<User>) request.getServletContext().getAttribute("userList");
    	int userId= Integer.parseInt(request.getParameter("userId"));

    	Iterator<User>it = updateList.iterator();
    	while(it.hasNext()) {
    		User user = it.next();
    		if(user.getId() == userId ) {
    			request.getServletContext().setAttribute("userIterator", user);
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
	public void searchUserByName(HttpServletRequest request) {
    	List<User>updateList = new ArrayList<>();
    	updateList = (List<User>) request.getServletContext().getAttribute("userList");
    	String name = request.getParameter("userName");

    	Iterator<User>it = updateList.iterator();
    	while(it.hasNext()) {
    		User user = it.next();
    		if(user.getName().equals(name)) {
    			request.getServletContext().setAttribute("iterator", user);
    		}
    	}
    }
}
