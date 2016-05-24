package com.lpc.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import org.apache.log4j.Logger;

/**
 * Created by liupengcheng1 on 2016/5/19.
 */
public class MyInterceptor implements Interceptor {

    private Logger logger = Logger.getLogger(MyInterceptor.class);

    private String name;


    @Override
    public void init() {
        logger.info("========== ������ ��ʼ�� ==========");
        logger.info("name is =========== " + name);
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        logger.info("=========== ���ؿ�ʼ ===========");
        String result = invocation.invoke();
        logger.info("=========== ���ؽ��� ============");
        return result;
    }

    @Override
    public void destroy() {
        logger.info("========== ������ ���� ==========");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
