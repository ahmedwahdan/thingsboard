package org.thingsboard.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.thingsboard.server.dao.LocaleConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Autowired
    LocaleConfig localeConfig;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        localeConfig.setLocale(request.getLocale());
        return true;
    }
}
