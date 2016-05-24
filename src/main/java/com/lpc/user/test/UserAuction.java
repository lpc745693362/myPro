package com.lpc.user.test;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;

/**
 * Created by liupengcheng1 on 2016/5/14.
 */
public class UserAuction extends ActionSupport{

    private Logger logger = Logger.getLogger(UserAuction.class);

    public String execute(){
        logger.info("==========test=========");
        return SUCCESS;
    }

}
