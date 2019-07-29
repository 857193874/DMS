package com.moyu.nicespring.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.moyu.nicespring.util.Msg;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;


@Controller
public class ErrorController extends AbstractErrorController{

    Log log= LogFactory.getLog(ErrorController.class);

    @Autowired
    ObjectMapper objectMapper;

    private static final String ERROR_PATH = "/error";

    public ErrorController() {
        super(new DefaultErrorAttributes());
    }

    @RequestMapping(ERROR_PATH)
    @ResponseBody
    public Msg getErrorPath(HttpServletRequest request, HttpServletResponse response){
        Map<String ,Object> model= Collections.unmodifiableMap(getErrorAttributes(request,false));

        Throwable cause=getCause(request);
        int status= (Integer) model.get("status");
        String message= (String) model.get("message");

        String errorMessage=getErrorMessage(cause);

        log.info("logError:"+status+","+message,cause);
        return Msg.fail().add("建议","联系后台管理");
    }

    private String getErrorMessage(Throwable cause) {
        return "系统出错，请联系管理员";
    }

    protected Throwable getCause(HttpServletRequest request) {
        Throwable error= (Throwable) request.getAttribute("javax.servlet.error.exception");
        if (error!=null){
            while (error instanceof ServletException && error.getCause()!=null){
                error=((ServletException)error).getCause();
            }
        }
        return error;
    }

    @Override

    public String getErrorPath() {
        return "系统出错，请联系管理员";
    }
}
