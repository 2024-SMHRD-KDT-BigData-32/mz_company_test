package com.smhrd.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SessionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // 기존 세션 유지 (세션이 없으면 새로 생성)
        req.getSession(true);

        // JSESSIONID 쿠키 설정 (Path 및 HttpOnly 설정)
        res.setHeader("Set-Cookie", "JSESSIONID=" + req.getSession().getId() + "; Path=/; HttpOnly");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
