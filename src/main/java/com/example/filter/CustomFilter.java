package com.example.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter called init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter called init "+servletRequest);
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        System.out.println("Result: " + req.getHeader("x-auth-token"));
//         chain.doFilter(request, response);
        Enumeration<String> enumeration = req.getHeaderNames(); // fetch header names
		while (enumeration.hasMoreElements()) { // print all headers
			String headerName = enumeration.nextElement();
			System.out.println("Header Name:" + headerName + ", Header Value:" + req.getHeader(headerName));
		}
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("destory called init");
    }
}
