package com.nmthang.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nmthang.model.CategoryModel;
import com.nmthang.util.FormUtil;

@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		CategoryModel categoryModel = FormUtil.toModel(CategoryModel.class, request);
		RequestDispatcher rd = null;
		if (categoryModel.getAction() != null && categoryModel.getAction().equals("list")) {
			rd = request.getRequestDispatcher("/view/admin/category/list.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/view/admin/home.jsp");
		}
		rd.forward(request, response);
	}

}
