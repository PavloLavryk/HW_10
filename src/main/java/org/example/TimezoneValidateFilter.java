package org.example;

import java.io.IOException;
import java.time.ZoneId;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimezoneValidateFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String timezone = req.getParameter("timezone");
        if (timezone != null) {
            try {
                ZoneId.of(timezone);
            } catch (Exception e) {
                res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid timezone");
                return;
            }
        }

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) {}
    public void destroy() {}
}
