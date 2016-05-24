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
 * �Զ��������
 */
public class FilterDemo implements Filter {

    private Logger logger = Logger.getLogger(FilterDemo.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("==========������ ��ʼ��==========");

        // �õ�������������
        String filterName = filterConfig.getFilterName();
        logger.info("filterName is ========== " + filterName);

        // �õ���web.xml�ļ������õĳ�ʼ������
        String name = filterConfig.getInitParameter("name");
        logger.info("name is ========== " + name);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // ��request��response����һЩԤ����
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        logger.info("===========FilterDemo ִ��ǰ...");
        // ���У���Ŀ����Դִ��
        chain.doFilter(request, response);
        logger.info("===========FilterDemo ִ�н���...");
    }

    @Override
    public void destroy() {
        logger.info("==========������ ����==========");
    }
}
