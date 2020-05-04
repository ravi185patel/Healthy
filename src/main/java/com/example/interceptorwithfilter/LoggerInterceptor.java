package com.example.interceptorwithfilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//@Component
public class LoggerInterceptor {//extends HandlerInterceptorAdapter {
//
//    private static Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);
//
//    @Override
//    public boolean preHandle(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            Object handler) throws Exception {
//
//        log.info("[preHandle][" + request + "]" + "[" + request.getMethod()
//                + "]" + request.getRequestURI() + getParameters(request));
//
//        return true;
//    }
//
//    private String getParameters(HttpServletRequest request) {
//        StringBuffer posted = new StringBuffer();
//        Enumeration<?> e = request.getParameterNames();
//        Map<String, List<String>> headersMap = Collections
//                .list(request.getHeaderNames())
//                .stream()
//                .collect(Collectors.toMap(
//                        Function.identity(),
//                        h -> Collections.list(request.getHeaders(h))
//                ));
//        headersMap.forEach((key,value)->{
//            System.out.println(key);
//            value.forEach(ss->System.out.print(ss+" "));
//        });
//        if (e != null) {
//            posted.append("?");
//        }
//        while (e.hasMoreElements()) {
//            if (posted.length() > 1) {
//                posted.append("&");
//            }
//            String curr = (String) e.nextElement();
//            posted.append(curr + "=");
//            if (curr.contains("password")
//                    || curr.contains("pass")
//                    || curr.contains("pwd")) {
//                posted.append("*****");
//            } else {
//                posted.append(request.getParameter(curr));
//            }
//        }
//        String ip = request.getHeader("X-FORWARDED-FOR");
//        String ipAddr = (ip == null) ? getRemoteAddr(request) : ip;
//        if (ipAddr!=null && !ipAddr.equals("")) {
//            posted.append("&_psip=" + ipAddr);
//        }
//        return posted.toString();
//    }
//
//    private String getRemoteAddr(HttpServletRequest request) {
//        String ipFromHeader = request.getHeader("X-FORWARDED-FOR");
//        if (ipFromHeader != null && ipFromHeader.length() > 0) {
//            log.debug("ip from proxy - X-FORWARDED-FOR : " + ipFromHeader);
//            return ipFromHeader;
//        }
//        return request.getRemoteAddr();
//    }
}
