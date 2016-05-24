package com.lpc.filter;

import org.apache.log4j.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 自定义过滤器
 */
public class FilterDemo implements Filter {

    private Logger logger = Logger.getLogger(FilterDemo.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("==========过滤器 初始化==========");

        // 得到过滤器的名称
        String filterName = filterConfig.getFilterName();
        logger.info("filterName is ========== " + filterName);

        // 得到在web.xml文件中配置的初始化参数
        String name = filterConfig.getInitParameter("name");
        logger.info("name is ========== " + name);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 对request和response进行一些预处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        logger.info("===========FilterDemo 执行前...");
        // 放行，让目标资源执行
        chain.doFilter(request, response);
        logger.info("===========FilterDemo 执行结束...");
    }

    @Override
    public void destroy() {
        logger.info("==========过滤器 销毁==========");
    }
}
