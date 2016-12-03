package demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Session
 */
@WebServlet("/Session")
public class Session extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Session() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//Creating new Cart object and fetching attribute cart and placing into the session.
		Cart cart = (Cart)session.getAttribute("cart");
		
		if(cart == null){
			
		//Declaring new shopping Cart 
			cart = new Cart();
		}
		
		cart.setTotalItem(7);
		
		//Setting cart for the session
		session.setAttribute("cart", cart);
		
		//Setting the cart into the session and then forwarding the session to the showcart page
		//When using the forward command (on the server side) the page will be available on the server even after clearing cookies
		getServletContext().getRequestDispatcher("/showcart.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
