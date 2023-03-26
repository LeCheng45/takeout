package com.lecheng.takeout.filter;

import com.alibaba.fastjson.JSON;
import com.lecheng.takeout.common.BaseContext;
import com.lecheng.takeout.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 拦截器
 * 检查用户是否已经完成登录
 */

@Slf4j
@WebFilter(filterName = "loginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    //路径匹配器，支持通配符
    private static AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        //1、获取本次请求的URI
        String uri = req.getRequestURI();

        //1、可以放行的URI
        String[] urls = {
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/user/**",
                "/wx/notify"
        };
        //如果不需要处理，则直接放行
        for (String url : urls) {
            boolean match = antPathMatcher.match(url, uri);
            if (match){
                log.info(uri+"路径不需要，直接放行");
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }

        //获取session  用户id
        HttpSession session = req.getSession();
        Long userId = (Long) session.getAttribute("employee");
        //判断登录状态，如果已登录，则直接放行
        if (userId != null){
            log.info("已登录,userId:"+userId);
            log.info("session："+session);
            BaseContext.setCurrentId(userId);
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //获取session中的user用户信息
        Long user1Id = (Long) session.getAttribute("user");
        //用户信息不为空,则放行
        if (user1Id != null){
            BaseContext.setCurrentId(user1Id);
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //登陆失败 拦截请求
        log.info("用户未登陆");
        resp.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

}
