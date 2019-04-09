//package com.whh.filter;
//
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//
///**
// * @Date: 2018/12/12 17:17
// * @Description:
// */
//public class ShiroUrlFilter extends FormAuthenticationFilter {
//    private final String SUCCESSURL = "/test";
//    @Override
//    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
//        System.out.println("重写了 *************************************************************************");
//        WebUtils.issueRedirect(request,response,SUCCESSURL);
//        return true;
//
//    }
//}
