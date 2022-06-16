package ace.project.dao;


import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ace.project.function.AutoId;
import ace.project.model.Student;
import ace.project.model.StudentInfo;

/**
 * Servlet implementation class StudentDao
 */
@WebServlet("/StudentDao")
public class StudentDao extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentInfo info = new StudentInfo();
	AutoId auto = new AutoId();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDao() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public Student getStudent(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return new Student();
	}
    
    public Student newStudent(Student student,HttpServletRequest request) {
    	student.setId(auto.increment()); 
		student.setName(request.getParameter("name")); 
		student.setBirth(request.getParameter("birth")); 
		student.setGender(request.getParameter("gender")); 
		student.setPhone(request.getParameter("phone"));
		student.setEducation(request.getParameter("education")); 
		student.setAttend(request.getParameterValues("attend"));
		return student; 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void saveStudent(HttpServletRequest request,Student student) {
		// TODO Auto-generated method stub
		info.addStudent(student);
		request.getServletContext().setAttribute("studentList", info.getStudentList());
	}
    
    @SuppressWarnings("unchecked")
	public void searchStudentById(HttpServletRequest request) {
    	List<Student>updateList = new ArrayList<>();
    	updateList = (List<Student>) request.getServletContext().getAttribute("studentList");
    	int studentId = Integer.parseInt(request.getParameter("studentId"));

    	Iterator<Student>it = updateList.iterator();
    	while(it.hasNext()) {
    		Student student = it.next();
    		if(student.getId() == studentId ) {
    			request.getServletContext().setAttribute("iterator", student);
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
	public void searchStudentByName(HttpServletRequest request) {
    	List<Student>updateList = new ArrayList<>();
    	updateList = (List<Student>) request.getServletContext().getAttribute("studentList");
    	String name = request.getParameter("studentName");

    	Iterator<Student>it = updateList.iterator();
    	while(it.hasNext()) {
    		Student student = it.next();
    		if(student.getName().equals(name)) {
    			request.getServletContext().setAttribute("iterator", student);
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
	public void fetchStudentBack(HttpServletRequest request) {
    	List<Student>fetchList = (List<Student>) request.getServletContext().getAttribute("studentList");
    	int fetchId = Integer.parseInt(request.getParameter("fetchId"));
   
    	Iterator<Student>it = fetchList.iterator();
    	while(it.hasNext()) {
    		Student student = it.next();
    		if(student.getId() == fetchId) {
    			request.getServletContext().setAttribute("fetch", student);
    		}
    	}
    }
    
    @SuppressWarnings("unchecked")
	public void updateStudent(HttpServletRequest request) {
    	
    	List<Student>studentList = (List<Student>) request.getServletContext().getAttribute("studentList");
    	List<Student>updateList = new ArrayList<>();
    	Student fetchStudent = (Student) request.getServletContext().getAttribute("fetch");
    	
    	Iterator<Student>it = studentList.iterator();
    	while(it.hasNext()) {
    		Student student = it.next();
    		if(student.getId() == fetchStudent.getId()) {
    			student.setName(request.getParameter("updateName")); 
    			student.setBirth(request.getParameter("updateBirth")); 
    			student.setGender(request.getParameter("updateGender")); 
    			student.setPhone(request.getParameter("updatePhone"));
    			student.setEducation(request.getParameter("updateEducation")); 
    			student.setAttend(request.getParameterValues("updateAttend"));
    			}
    		updateList.add(student);
        	}	
    		info.setStudentList(updateList);
    		request.getServletContext().setAttribute("studentList", info.getStudentList());
	    }
    
     
	@SuppressWarnings("unchecked")
	public void deleteStudent(HttpServletRequest request) {
    		List<Student>studentList = (List<Student>) request.getServletContext().getAttribute("studentList");
        	List<Student>updateList = new ArrayList<>();
        	Student fetchStudent = (Student) request.getServletContext().getAttribute("fetch");
        	
        	Iterator<Student>it = studentList.iterator();
        	while(it.hasNext()) {
        		Student student = it.next();
        		if(student.getId() == fetchStudent.getId()) {
        				it.remove();
        		}
        		else {
        		updateList.add(student);
        		}
            	}	
        		info.setStudentList(updateList);
        		request.getServletContext().setAttribute("studentList", info.getStudentList());
      }
    }
   
