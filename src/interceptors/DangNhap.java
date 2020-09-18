package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class DangNhap implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute("nguoidung")==null) {
			String url = request.getRequestURI();
			url = url.substring(url.lastIndexOf("/")+1);
			session.setAttribute("url", url);
			response.sendRedirect("login");
			return false;
		}
		return true;
	}
	

}
