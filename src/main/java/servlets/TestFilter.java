package servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Random;

/**
 * Created by abalaev on 03.10.2016.
 */
@WebFilter(filterName = "TestFilter", urlPatterns = "/test")
public class TestFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        String s = httpServletRequest.getRequestURL().toString();
        if (s.contains("user")) {
            if (s.contains("admin")) {
                // проверить роль админ
            }
            // проверить роль прользователь
        }

        Random random = new Random();
        int n = random.nextInt(3) + 1;
        String prize = null;
        switch (n) {
            case 1:
                prize = "money";
                break;
            case 2:
                prize = "car";
                break;
            case 3:
                prize = "free bear";
                break;
        }
        String firstResult = "This time you won " + prize + " !";
        String secondResult = "You are not lucky this time. Please try again";
        int m = random.nextInt(10)+1;
        String result = null;
        if (m>5) result = firstResult;
        else result = secondResult;
        req.setAttribute("result",result);
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
