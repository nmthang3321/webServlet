package com.nmthang.API;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmthang.DAO.impl.NewsDAO;
import com.nmthang.constant.SystemConstant;
import com.nmthang.model.NewsModel;
import com.nmthang.model.UserModel;
import com.nmthang.util.HttpUtil;
import com.nmthang.util.SessionUtil;

@WebServlet(urlPatterns = {"/api"})
public class NewsAPI extends HttpServlet{

	/**
	 * 
	 */
	@Inject
	private NewsDAO newsDAO;
	
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel = (NewsModel) HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, SystemConstant.USERMODEL);
		newsDAO.insert (newsModel, user.getUserName());
		response.getWriter().print(new ObjectMapper().writeValueAsString(newsModel));
		
	}

	@SuppressWarnings("unchecked")
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel = (NewsModel) HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		UserModel user = (UserModel) SessionUtil.getInstance().getValue(request, SystemConstant.USERMODEL);
		newsDAO.update (newsModel, user.getUserName());
		response.getWriter().print(new ObjectMapper().writeValueAsString(newsModel));
		
	}
	
	@SuppressWarnings("unchecked")
	protected void doDelete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewsModel newsModel = (NewsModel) HttpUtil.of(request.getReader()).toModel(NewsModel.class);
		newsDAO.delete(newsModel.getIds());
		response.getWriter().print(new ObjectMapper().writeValueAsString(newsModel));
	}
}
