package com.nmthang.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nmthang.constant.SystemConstant;
import com.nmthang.model.UserModel;
import com.nmthang.util.SessionUtil;

public class AuthorizationFilter implements Filter{
	
	private ServletContext context;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String url = req.getRequestURI();
		if (url.contains("/admin")) {
			UserModel userModel = (UserModel) SessionUtil.getInstance().getValue(req, SystemConstant.USERMODEL);
			if (userModel!=null && userModel.getRole().getCode().equals(SystemConstant.ADMIN)) {
				filterChain.doFilter(req, resp);
			} else if (userModel!=null && userModel.getRole().getCode().equals(SystemConstant.USER)) {
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=not_permission&alert=danger");
			}else {
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&message=not_login&alert=danger");
            }
        } else {
            filterChain.doFilter(req, resp);
        }
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
