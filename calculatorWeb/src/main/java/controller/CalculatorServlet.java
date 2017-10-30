package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CalculateService;

@WebServlet("/form/calculate")
public class CalculatorServlet extends HttpServlet {
//	Controller : 사용자 요청을 받아서 응답할 때 까지의 전체 흐름을 처리.(Servlet)
	private static final long serialVersionUID = 1L;
	String resultMessage;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 요청파라미터 조회(숫자두개, 연산자)
		request.setCharacterEncoding("UTF-8"); // 요청 파라미터 한글 처리.
		try {
			int num1 = Integer.parseInt(request.getParameter("num1"));
			int num2 = Integer.parseInt(request.getParameter("num2"));
			String operator = request.getParameter("operator");
		
//		2. 비즈니스 로직 - 계산 처리
			
			CalculateService service = CalculateService.getInstance();
			resultMessage = service.calculate(num1, operator, num2);
			
//			3. 처리결과 응답 -> calc_result.jsp 호출
//			1. 처리결과를 HttpServletRequest 공유저장소에 Attribute로 저장
//				resultMessage란 이름으로 처리결과를 request저장소에 담겠다.
			request.setAttribute("resultMessage", resultMessage);
//			2. 요청 디스패치 방식으로 calc_result.jsp로 이동.
			RequestDispatcher rdp = request.getRequestDispatcher("/WEB-INF/view/calc_result.jsp");
			rdp.forward(request, response);
		}catch (NumberFormatException e) {
			resultMessage = "피연산자는 정수만 가능합니다.";
//			calculate_form.jsp로 이동.
			request.setAttribute("error_message", resultMessage);
			request.getRequestDispatcher("/calculator_form.jsp").forward(request, response);
		}

		/*
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head><title>계산결과</title></head>");
		out.println("<body>");
		out.println(resultMessage+"<br>");
		out.println("<a href='calculator_form.html'>계산폼</a>");
		out.println("</body></html>");
		*/
	}

}
