package com.nmthang.controller.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nmthang.constant.SystemConstant;
import com.nmthang.model.UserModel;
import com.nmthang.service.impl.NewsService;
import com.nmthang.service.impl.UserService;
import com.nmthang.util.FormUtil;
import com.nmthang.util.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu", "/dang-nhap", "/dang-ki"})
public class HomeConttroller extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private UserService userService;
	@Inject
	private NewsService newsService;
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
		RequestDispatcher rd = null;
		if (action != null) {
			String message = request.getParameter("message");
			String alert = request.getParameter("alert");
			if (message != null && alert != null) {
				request.setAttribute("message", resourceBundle.getString(message));
				request.setAttribute("alert", alert);
			}
			if (action.equals("login")) {
				rd = request.getRequestDispatcher("/view/admin/login.jsp");
			}
			else if (action.equals("logout")) {
				SessionUtil.getInstance().removeValue(request, SystemConstant.USERMODEL);
				rd = request.getRequestDispatcher("/view/web/home.jsp");
			} 
			else if (action.equals("register")) {
				rd = request.getRequestDispatcher("/view/admin/register.jsp");
			}
		}
		else {
			rd = request.getRequestDispatcher("/view/web/home.jsp");
		}
		request.setAttribute(SystemConstant.MODEL, newsService.findAll());
		rd.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		UserModel userModel = FormUtil.toModel(UserModel.class, request);
		if (userModel.getVerifyPassword() == null) {
			userModel = userService.findByUserAndPassword(userModel.getUserName(), userModel.getPassword());
			if (userModel != null && userModel.getVerifyPassword() == null) {
				SessionUtil.getInstance().putValue(request, SystemConstant.USERMODEL, userModel);
				if (userModel.getRole().getCode().equals("user")) {
					response.sendRedirect(request.getContextPath()+"/trang-chu");
				} else if (userModel.getRole().getCode().equals("admin")) {
					response.sendRedirect(request.getContextPath()+"/admin-home");
				}
			} 
			else {
				response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=username_password_invalid&alert=danger");
			}
		} else {
			if (userModel.getVerifyPassword().equals(userModel.getPassword())) {
				if (userService.findByUserAndPassword(userModel.getUserName(), userModel.getPassword()) == null) {
					userService.insert(userModel);
					response.sendRedirect(request.getContextPath()+"/dang-nhap?action=login&message=register_successd&alert=success");
				}
				else {
					response.sendRedirect(request.getContextPath()+"/dang-ki?action=register&message=username_exist&alert=danger");
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/dang-ki?action=register&message=password_not_match&alert=danger");
			}
		}
	}

}
