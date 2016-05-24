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
        logger.info("========== À¹½ØÆ÷ ³õÊ¼»¯ ==========");
        logger.info("name is =========== " + name);
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {

        logger.info("=========== À¹½Ø¿ªÊ¼ ===========");
        String result = invocation.invoke();
        logger.info("=========== À¹½Ø½áÊø ============");
        return result;
    }

    @Override
    public void destroy() {
        logger.info("========== À¹½ØÆ÷ Ïú»Ù ==========");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
