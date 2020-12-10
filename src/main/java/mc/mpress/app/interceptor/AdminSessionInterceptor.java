package mc.mpress.app.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Component
public class AdminSessionInterceptor implements HandlerInterceptor {


    /**
     * 过滤路径
     */

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        String requestURI = request.getRequestURI();

        System.out.println(requestURI);
        /*if ("/admin".equals(requestURI)) {
            //response.sendRedirect("admin/"+ EnumsUtil.getBackendTemplateTheme() +"/login");
            return true;
        }

        User user = (User)request.getSession().getAttribute("user");
        if (user == null){
            response.sendRedirect(request.getContextPath() + "/admin");
            return false;
        }else{
            return true;
        }*/
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
