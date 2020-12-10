package mc.mpress.app.config;

import lombok.extern.slf4j.Slf4j;
import mc.mpress.app.interceptor.AdminSessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private AdminSessionInterceptor adminSessionInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        //注册自己的拦截器,并设置拦截路径，拦截多个可以全一个list集合
        List<String> excludeRequests = new ArrayList<>();
        excludeRequests.add("/");
        excludeRequests.add("/admin");
        excludeRequests.add("/down/**");
        excludeRequests.add("/adminlte/**");
        excludeRequests.add("/plugins/**");
        excludeRequests.add("/service/user/userLogin");
        excludeRequests.add("/**/error");

        List<String> pathPatterns = new ArrayList<>();
        pathPatterns.add("/admin/**");
        pathPatterns.add("/menu/**");
        registry.addInterceptor(adminSessionInterceptor).addPathPatterns(pathPatterns).excludePathPatterns(excludeRequests);
    }


}
