package com.nmthang.API;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nmthang.DAO.impl.CommentDAO;
import com.nmthang.model.CommentModel;
import com.nmthang.util.HttpUtil;

public class CommentAPI extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CommentDAO commentDAO;
	
	@SuppressWarnings("unchecked")
	protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CommentModel CommentModel = (CommentModel) HttpUtil.of(request.getReader()).toModel(CommentModel.class);
		commentDAO.insert(CommentModel);
		response.getWriter().print(new ObjectMapper().writeValueAsString(CommentModel));
		
	}

	@SuppressWarnings("unchecked")
	protected void doPut (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CommentModel commentModel = (CommentModel) HttpUtil.of(request.getReader()).toModel(CommentModel.class);
		commentDAO.update (commentModel);
		response.getWriter().print(new ObjectMapper().writeValueAsString(commentModel));
		
	}
	
	@SuppressWarnings("unchecked")
	protected void doDelete (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		CommentModel commentModel = (CommentModel) HttpUtil.of(request.getReader()).toModel(CommentModel.class);
		commentDAO.delete(commentModel);
		response.getWriter().print(new ObjectMapper().writeValueAsString(commentModel));
	}

}
