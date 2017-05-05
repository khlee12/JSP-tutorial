package beansSample;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BeansControllerServlet
 */
@WebServlet("/BeansControllerServlet")
public class BeansControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeansControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		//get inputted id from request
		String id = request.getParameter("id");
		
		//do id processing and get returned bean
		BeansIdProcessing bip = new BeansIdProcessing();
		UserBean2 bean = bip.getUserData(id);
//		System.out.println(bean.getName());
		
		//if bean is not empty, forward to response
		//else forward to error page
		
		ServletContext con = request.getServletContext();
		RequestDispatcher rd;
		if(bean!=null){
			request.setAttribute("user", bean);
			//"user"はuserResponse.jspで使われているuseBeanのidと一緒
			rd = con.getRequestDispatcher("/BeansSample/userResponse.jsp");
		}else{
			rd = con.getRequestDispatcher("/BeansSample/userError.jsp");
		}
		rd.forward(request, response);
		
	}

}
