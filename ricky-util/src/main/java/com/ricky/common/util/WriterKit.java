package com.ricky.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 后台向前端返回结果
 * Created by zhl on 16/9/22.
 */
public class WriterKit {
    private final static Logger logger = LoggerFactory.getLogger(WriterKit.class);

    /**
     * 返回JSON结果,contentType为application/json;charset=utf-8
     * @param response
     * @param jsonStr
     */
    public static void renderJson(HttpServletResponse response, String jsonStr){
       render(response,jsonStr,"application/json;charset=utf-8");
    }

    /**
     * 返回普通文本,contentType为text/html;charset=utf-8
     * @param response
     * @param renderStr
     */
    public static void renderPlain(HttpServletResponse response,String renderStr){
        render(response,renderStr,"text/html;charset=utf-8");
    }

    /**
     * 返回JSON结果,同时打印日志
     * @param response
     * @param result
     * @param ex
     */
    public static void renderForException(HttpServletResponse response,String result,Exception ex){
        if(ex.getMessage().equalsIgnoreCase("java.io.IOException")){
            logger.warn("response Io异常，可忽略");
        }else {
            logger.error("系统抛出未知异常。请攻城狮们速度解决",ex);
        }
        renderJson(response,result);
    }

    private static void render(HttpServletResponse response,String result,String contentType){
        response.setContentType(contentType);
        response.setCharacterEncoding("utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out;
        try {
            out = response.getWriter();
            out.print(result);
            out.flush();
            out.close();
        } catch (IllegalStateException e){
            logger.warn("可能是调用了两次response",e);
        }catch (IOException e) {
            logger.warn("在OUTJSON中获时异常",e);
        }
    }

}
