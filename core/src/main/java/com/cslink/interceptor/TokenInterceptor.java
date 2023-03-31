package com.cslink.interceptor;

import com.cslink.constants.RedisPrefix;
import com.cslink.constants.SignInError;
import com.cslink.utils.AjaxResult;
import com.cslink.utils.JSONUtil;
import com.cslink.utils.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TokenInterceptor implements HandlerInterceptor {

    // at controller method before call
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // carry token
        // TODO add token verification
        String token = request.getHeader("token");
        if(token == null){
            response.getWriter().write(JSONUtil.toJsonString(AjaxResult.success(SignInError.LACK_TOKEN)));
            return false;
        }
        String email = JWTUtil.getEmailFromToken(token);
        if(email == null) {
            response.getWriter().write(JSONUtil.toJsonString(AjaxResult.success(SignInError.TOKEN_VERIFY_ERROE)));
        }
        return true;
    }
}
