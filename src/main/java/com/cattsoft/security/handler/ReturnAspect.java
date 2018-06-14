package com.cattsoft.security.handler;

import com.cattsoft.security.entity.Result;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Description: 返回结果 <br>
 * Copyright:DATANG SOFTWARE CO.LTD<br>
 *
 * @author fuxiangming
 * @date 2018/4/16 上午11:04
 */

@Aspect
@Component
public class ReturnAspect {
    private static final Log log = LogFactory.getLog(ReturnAspect.class);


    @Pointcut("execution(public * com.cattsoft.security.controller.*.*(..))")
    public void webLog() {
    }

//    @Before("webLog()")
//    public void deBefore(JoinPoint joinPoint) throws Throwable {
    // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
    // 记录下请求内容
//        System.out.println("URL : " + request.getRequestURL().toString());
//        System.out.println("HTTP_METHOD : " + request.getMethod());
//        System.out.println("IP : " + request.getRemoteAddr());
//        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
//    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
//        System.out.println("方法的返回值 : " + ret);
        if (Result.class.isInstance(ret)) {

            log.info("返回结果：\n" + JSONObject.valueToString(ret));
        }
    }

    //后置异常通知
//    @AfterThrowing("webLog()")
//    public void throwss(JoinPoint jp){
//        System.out.println("方法异常时执行.....");
//    }

    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("webLog()")
//    public void after(JoinPoint jp){
//        System.out.println("方法最后执行.....");
//    }

    //环绕通知,环绕增强，相当于MethodInterceptor
//    @Around("webLog()")
//    public Object arround(ProceedingJoinPoint pjp) {
//        System.out.println("方法环绕start.....");
//        try {
//            Object o =  pjp.proceed();
//            System.out.println("方法环绕proceed，结果是 :" + o);
//            return o;
//        } catch (Throwable e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
