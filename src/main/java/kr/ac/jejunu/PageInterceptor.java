package kr.ac.jejunu;

import com.fasterxml.jackson.core.PrettyPrinter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by Kim on 2016-06-13.
 */

public class PageInterceptor extends HandlerInterceptorAdapter {

    private final static Logger logger = LoggerFactory.getLogger(PageInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Request URI : " + request.getRequestURI());
        logger.info("Referer : " + request.getHeader("Referer"));
        logger.info("Method : " + request.getMethod());

        if (request.getSession().getAttribute("userId") == null) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

}