package fa.training.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fa.training.utils.Log4J;

/**
 * authentication filter.
 * 
 * @author FA
 *
 */
//@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    private List<String> excludedRequests;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        excludedRequests = new ArrayList<>();
        excludedRequests.add(new String("JWEB.M.L201/"));
        excludedRequests.add(new String("/login"));
        excludedRequests.add(new String("/register"));
        excludedRequests.add(new String(".js"));
        excludedRequests.add(new String(".css"));
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        HttpSession session = request.getSession();
        boolean loggedIn = session != null && session.getAttribute("userLogin") != null;
        String userRequest = request.getRequestURI();
        if (loggedIn || isValidRequest(userRequest)) {
            chain.doFilter(request, response);
        } else {
            Log4J.getLogger().info("Invalid Request");
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    private boolean isValidRequest(String request) {
        for (String excludedRequest : excludedRequests) {
            if (request.endsWith(excludedRequest)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void destroy() {

    }

}
