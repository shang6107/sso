package filter;

import org.jasig.cas.client.util.AssertionHolder;
import org.jasig.cas.client.validation.Assertion;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CasForInvokeContextFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
        //如果session中没有用户信息，则填充用户信息
        if (session.getAttribute("j_userId") == null) {
            //从Cas服务器获取登录账户的用户名
            Assertion assertion = AssertionHolder.getAssertion();
            String userName = assertion.getPrincipal().getName();

            System.out.println("userName = " + userName);
            try {
                //根据单点登录的账户的用户名，从数据库用户表查找用户信息， 填充到session中
//                User user = UserDao.getUserByName(userName);
                session.setAttribute("username", userName);
//                session.setAttribute("userId", user.getId());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        chain.doFilter(request, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
