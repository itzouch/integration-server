package com.zouch.filter;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.core.annotation.OrderUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Zouch
 * @date 2021/6/16 20:45
 * @description
 */
@Component
@Order(Integer.MIN_VALUE)
@WebFilter(filterName = "testFilter",urlPatterns = "/*")
public class TestFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("过滤器执行");

        Map<String, String[]> parameterMap = httpServletRequest.getParameterMap();
        if (Objects.nonNull(parameterMap)){
            parameterMap.forEach((k,v)->{
                LOGGER.info("request: param{},value{}",k,v);

            });
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }



}