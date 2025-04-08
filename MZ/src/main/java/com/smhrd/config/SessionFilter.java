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

        // ���� ���� ���� (������ ������ ���� ����)
        req.getSession(true);

        // JSESSIONID ��Ű ���� (Path �� HttpOnly ����)
        res.setHeader("Set-Cookie", "JSESSIONID=" + req.getSession().getId() + "; Path=/; HttpOnly");

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}
}
