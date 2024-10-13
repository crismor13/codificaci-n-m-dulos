package com.helloWorld.beautyShop.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Check if user is authenticated (for example, by checking a session attribute)
        Object isUserAuthenticated = request.getSession().getAttribute("isUserAuthenticated");

        if (isUserAuthenticated == null || !(Boolean) isUserAuthenticated) {
            // User is not logged in, redirect to login page
            response.sendRedirect("/login");
            return false; // Prevent the request from reaching the controller
        }

        // User is logged in, proceed with the request
        return true;
    }
}

