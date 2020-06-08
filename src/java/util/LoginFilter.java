package util;

import dao.UserDAO;
import entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class LoginFilter implements Filter {

    private UserDAO userDao;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String url = req.getRequestURI();

        User u = (User) req.getSession().getAttribute("valid_user");

        if (u == null) {
            //Login yapılmamış session kontrolü
            if (url.contains("back_end") || url.contains("logout") || url.contains("front-end-customer")) {
                if (url.contains("back_end")) {
                    res.sendRedirect(req.getContextPath() + "/front-end-ortak/adminlogin.xhtml");
                } else {
                    res.sendRedirect(req.getContextPath() + "/front-end-ortak/customerlogin.xhtml");
                }

            } else {
                chain.doFilter(request, response);
            }

        } else {
            //Login yapılmış session kontrolü
            if (this.getUserDao().isStaff(u)) {
                //Giriş yapan nesne admin ise
                if (url.contains("adminlogin")) {
                    res.sendRedirect(req.getContextPath() + "/back_end/admin.xhtml");
                } else if (url.contains("logout")) {
                    req.getSession().invalidate();
                    res.sendRedirect(req.getContextPath() + "/front-end-ortak/index.xhtml");
                } else if (url.contains("customerlogin")) {
                     res.sendRedirect(req.getContextPath() + "/back_end/admin.xhtml");
                } else {
                    chain.doFilter(request, response);
                }

            } else {
                //Giriş yapan nesne Müşteri ise
                if (url.contains("customerlogin")) {
                    res.sendRedirect(req.getContextPath() + "/front-end-customer/customer.xhtml");
                } else if (url.contains("logout")) {
                    req.getSession().invalidate();
                    res.sendRedirect(req.getContextPath() + "/front-end-ortak/index.xhtml");
                } else if (url.contains("adminlogin")) {
                    res.sendRedirect(req.getContextPath() + "/front-end-customer/customer.xhtml");
                } else {
                    chain.doFilter(request, response);
                }
            }
        }

    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public UserDAO getUserDao() {
        if (this.userDao == null) {
            this.userDao = new UserDAO();
        }
        return userDao;
    }

}
