package com.nju.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 拦截登录得两种实现方案
 * 1.除了登录以外所涉及的页面、控制器全部过滤
 * 2.优化访问路径 页面路径
 */
@WebFilter(value={"/show.jsp"})
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

	public void destroy() {
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse resp=(HttpServletResponse)response;
		Object userName=req.getSession().getAttribute("uName");
		if(userName!=null) {
			chain.doFilter(request, response);
		}else {
			resp.sendRedirect("/TKM/login.jsp");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
