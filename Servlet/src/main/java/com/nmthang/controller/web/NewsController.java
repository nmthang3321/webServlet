package com.nmthang.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nmthang.constant.SystemConstant;
import com.nmthang.model.NewsModel;
import com.nmthang.service.impl.NewsService;
import com.nmthang.util.FormUtil;

@WebServlet (urlPatterns = {"/news"})
public class NewsController extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private NewsService newsService;
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		NewsModel newsModel = FormUtil.toModel(NewsModel.class, request);
		RequestDispatcher rd = null;
		if (newsModel.getAction() != null && newsModel.getId() != 0) {
			if (newsModel.getAction().equals("view")) {
				rd = request.getRequestDispatcher("/view/web/news.jsp");
				request.setAttribute(SystemConstant.NEWS, newsService.findOneById(newsModel.getId()));
			}
		} else {
			rd = request.getRequestDispatcher("/view/web/home.jsp");
		}
		rd.forward(request, response);
	}

}
