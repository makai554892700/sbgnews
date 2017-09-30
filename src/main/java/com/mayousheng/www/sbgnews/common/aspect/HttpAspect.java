package com.mayousheng.www.sbgnews.common.aspect;

import com.mayousheng.www.sbgnews.pojo.StatisticObject;
import com.mayousheng.www.sbgnews.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

//切面编程
@Aspect
@Component
public class HttpAspect {

    private final static Logger log = LoggerFactory.getLogger(HttpAspect.class);

    //对整个controller做切面，做到请求的请求数据返回数据的统计
    @Pointcut("execution(public * com.mayousheng.www.sbgnews.controller.*.*(..))")
    public void controller() {
    }

    @Around(value = "controller()")
    public Object methodStatistic(ProceedingJoinPoint joinPoint) throws Throwable {
        // 定义返回对象、得到方法需要的参数
        Date date = new Date();
        Object response = null;
        Object[] args = joinPoint.getArgs();
        StatisticObject statisticObject = new StatisticObject();
        statisticObject.setArgs(args);
        statisticObject.setRequestTime(date);
        try {
            response = joinPoint.proceed(args);
        } catch (Throwable e) {
            statisticObject.setHaveError(true);
            throw e;
        } finally {
            MethodSignature signature = (MethodSignature) joinPoint.getSignature();
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            statisticObject.setClassMethod(signature.getDeclaringTypeName() + "." + signature.getName());
            statisticObject.setRequestUrl(request.getRequestURL().toString());
            statisticObject.setRequestType(request.getMethod());
            statisticObject.setIp(IPUtils.getIP(request));
            statisticObject.setResponse(response);
            statisticObject.setRunTime(System.currentTimeMillis() - statisticObject.getRequestTime().getTime());
            log.error(statisticObject.toString());
        }
        return response;
    }

}
//    @Before("controller()")
//    public void before(JoinPoint joinPoint) {
//        commonLog(joinPoint, "before");
//    }
//
//    @After("controller()")
//    public void after(JoinPoint joinPoint) {
//        commonLog(joinPoint, "after");
//    }
//
//    @AfterThrowing(pointcut = "controller()", throwing = "e")
//    public void onError(Exception e) {
//        log.error("error={}", e.getMessage());
//    }
//
//    @AfterReturning(returning = "object", pointcut = "controller()")
//    public void afterReturning(JoinPoint joinPoint, Object object) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        log.info(";url={}", request.getRequestURL());
//        log.info(";method={}", request.getMethod());
//        log.info(";ip={}", request.getRemoteAddr());
//        log.info(";class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.info(";args={}", joinPoint.getArgs());
//        log.info("response={}", object);
//    }
//
//    private void commonLog(JoinPoint joinPoint, String mark) {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        log.info(mark + ";url={}", request.getRequestURL());
//        log.info(mark + ";method={}", request.getMethod());
//        log.info(mark + ";ip={}", request.getRemoteAddr());
//        log.info(mark + ";class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
//        log.info(mark + ";args={}", joinPoint.getArgs());
//    }