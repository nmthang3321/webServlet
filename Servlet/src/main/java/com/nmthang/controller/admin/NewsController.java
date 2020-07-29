package com.nmthang.controller.admin;

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
import com.nmthang.page.PageRequest;
import com.nmthang.service.impl.CategoryService;
import com.nmthang.service.impl.NewsService;
import com.nmthang.sorter.Sorter;
import com.nmthang.util.FormUtil;

@WebServlet(urlPatterns = {"/admin-news"})
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private NewsService newsService;
	@Inject
	private CategoryService categoryServicve;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		NewsModel newsModel = FormUtil.toModel(NewsModel.class, request);
		PageRequest page = new PageRequest(newsModel.getVisiblePage(), newsModel.getCurentPage(),
				new Sorter(newsModel.getSortBy(), newsModel.getSortName()));
		RequestDispatcher rd = null;

		if (newsModel.getAction() != null) {
			if (newsModel.getAction().equals("list")) {
				newsModel.setTotalItem(newsService.totalItem());
				newsModel.setListResult(newsService.findAll(page));
				newsModel.setCurentPage(page.getCurentPage());
				newsModel.setVisiblePage(page.getVisiblePage());
				newsModel.setTotalPage((newsModel.getTotalItem() / newsModel.getVisiblePage()) 
						+ (newsModel.getTotalItem() % newsModel.getVisiblePage()));
				rd = request.getRequestDispatcher("/view/admin/news/list.jsp");
			}else if (newsModel.getAction().equals("edit") || newsModel.getAction().equals("update")) {
				rd = request.getRequestDispatcher("/view/admin/news/edit.jsp");
				System.out.println(newsModel.getId());
				if (newsModel.getId() != 0) {
					newsModel.setResultById(newsService.findOneById(newsModel.getId()));
				}
			}
		} else {
			rd = request.getRequestDispatcher("/view/admin/home.jsp");
		}
		request.setAttribute(SystemConstant.MODEL, newsModel);
		request.setAttribute(SystemConstant.CATEGORY, categoryServicve.findAll());
		rd.forward(request, response);
	}

}
