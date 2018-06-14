package com.cattsoft.security.Interceptor;

import com.cattsoft.security.entity.Result;
import com.cattsoft.security.utils.ResponseUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * Description: 用户认证拦截器 <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/1/25 下午11:46
 */
@Component
public class AuthenticateInterceptor implements HandlerInterceptor {
    private static final Log log = LogFactory.getLog(AuthenticateInterceptor.class);

//    @Autowired
//    private IdeaUserService ideaUserService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        httpServletResponse.setCharacterEncoding("utf-8");
        httpServletResponse.setContentType("application/json; charset=utf-8");
        try {
            String url = httpServletRequest.getRequestURL().toString();
            log.info("\n\n\n请求URL:" + url);

            Enumeration paramNames = httpServletRequest.getParameterNames();
            while (paramNames.hasMoreElements()) {
                String paramName = (String) paramNames.nextElement();
                String[] paramValues = httpServletRequest.getParameterValues(paramName);
                if (paramValues.length == 1) {
                    String paramValue = paramValues[0];
                    if (paramValue.length() != 0) {
                        log.info("请求参数：" + paramName + "=" + paramValue);
                    }
                }
            }

//            if (
//                    (url.indexOf("/login") > -1)
//                            || (url.indexOf("/domain/") > -1)
//                            || (url.indexOf("/sheQuAll") > -1)
//                            || (url.indexOf("/swagger") > -1)
//                            || (url.indexOf("/webjars") > -1)
//                            || (url.indexOf("/v2") > -1)
//                            || (url.indexOf("/appInfo") > -1)
//                    ) {//登录页面和错误页面不拦截
            return true;
//            }
        } catch (Exception e) {
            log.error("请求参数异常", e);
            ResponseUtil.write(httpServletResponse, JSONObject.valueToString(Result.error("请求参数异常")));
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
