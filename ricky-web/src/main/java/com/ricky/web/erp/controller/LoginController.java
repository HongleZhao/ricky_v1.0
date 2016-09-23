package com.ricky.web.erp.controller;

import com.ricky.base.bean.BaseRespVO;
import com.ricky.base.bean.RestRspVO;
import com.ricky.base.emnu.ErrType;
import com.ricky.base.mapper.SysuserMapper;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by zhl on 16/9/22.
 */
@Controller
public class LoginController {
    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysuserMapper sysuserMapper;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String gotoLoginPage(HttpServletRequest request, HttpServletResponse response){
        Subject userLogin = SecurityUtils.getSubject();
        if(userLogin.isAuthenticated()){
            if(logger.isDebugEnabled()){
                logger.debug("===> 已经登录过了");
            }
            return "redirect:index";
        }
        if((request.getHeader("x-requested-with")!=null&&request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest"))
                ||(null!=request.getHeader("requestType")&&request.getHeader("requestType").equalsIgnoreCase("ajax"))){
            return null;
        }else {
            return "login";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestRspVO<Map<String,Object>> doLogin(@RequestParam(value = "username",required = true) String username,
                                                 @RequestParam(value = "password",required = true) String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);//登录验证
            //登录成功后在修改登录时间

            return new RestRspVO<>(ErrType.SUCCESS);
        }catch (UnknownAccountException e){
            token.clear();
            return new RestRspVO(ErrType.ACCOUNT_NOTEXISTED);
        }catch (LockedAccountException e){
            token.clear();
            return new RestRspVO(ErrType.ACCOUNT_LOCKD);
        }catch (ExcessiveAttemptsException e){
            token.clear();
            return new RestRspVO(ErrType.ACCOUNT_LOGIN_LIMIT);
        }catch (AuthenticationException e){
            token.clear();
            if(StringUtils.contains(e.getMessage(),ErrType.ILLEGAL_ACCOUNT_PASSWORD.getErrmsg())){
                return new RestRspVO(ErrType.ILLEGAL_ACCOUNT_PASSWORD);
            }else {
                logger.warn("==>登录异常",e);
                return new RestRspVO(ErrType.SYSTEM_ERROR);
            }
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject logout = SecurityUtils.getSubject();
        logout.logout();
        return "redirect:login";
    }
}
