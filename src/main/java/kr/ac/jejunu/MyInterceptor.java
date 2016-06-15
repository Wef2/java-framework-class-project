package kr.ac.jejunu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Kim on 2016-06-13.
 */

public class MyInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request URI : " + request.getRequestURI());
        logger.info("Referer : " + request.getHeader("referer"));

        if (request.getSession().getAttribute("userId") == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}