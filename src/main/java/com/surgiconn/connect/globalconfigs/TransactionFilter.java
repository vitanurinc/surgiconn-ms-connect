package com.surgiconn.connect.globalconfigs;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
@Order(1)
public class TransactionFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        chain.doFilter(request, response);

        System.out.println(req);
        System.out.println("REQUESTED: " + req.getRequestURL());
        System.out.println("METHOD: " + req.getMethod());
        System.out.println("HEADER: Content-Type: " + req.getHeader("Content-Type"));
        System.out.println("HEADER: API KEY: " + req.getHeader("API-KEY"));
        System.out.println("HEADER: Accept: " + req.getHeader("Accept"));
        System.out.println("HEADER: QUERY: " + req.getQueryString());
    }

    // other methods
}