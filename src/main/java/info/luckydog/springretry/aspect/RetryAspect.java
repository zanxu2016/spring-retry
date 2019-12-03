package info.luckydog.springretry.aspect;

import info.luckydog.springretry.annotation.Retry;
import info.luckydog.springretry.model.BaseRes;
import info.luckydog.springretry.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * RetryAspect
 *
 * @author eric
 * @since 2019/12/2
 */
@Aspect
@Component
@Slf4j
public class RetryAspect {

    @Autowired
    private RetryService retryService;

    @Pointcut(value = "@annotation(info.luckydog.springretry.annotation.Retry)")
    public void pointcut() {
    }

//    @Before("pointcut()")
//    public void before(JoinPoint joinPoint) {
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//        Retry retry = method.getAnnotation(Retry.class);
//        log.info("before：" + retry.name());
//    }

    @Around(value = "pointcut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Object[] args = joinPoint.getArgs();
        Retry retry = method.getAnnotation(Retry.class);
        try {
            log.info("around start: {}", retry.name());
            // 首次调用方法
            Object result = joinPoint.proceed();

            int times = Math.min(retry.times(), retry.maxTimes());
            if (times < 0) {// 不合法情况，不重试，直接返回
                return result;
            }

            if (result instanceof BaseRes) {
                for (; times >= 0; times--) {
                    boolean retryFlag = ((BaseRes) result).isRetry();
                    log.info("aop retryFlag: {}", retryFlag);
                    // 重试的条件 code==1
                    if (retryFlag) {
                        String token = retryService.getToken(String.valueOf(args[0]));
                        args[1] = token;
                        result = joinPoint.proceed(args);
                        continue;
                    }
                    return result;
                }
            } else {
                log.warn("方法返回对象，未继承 BaseRes 对象，不支持重试");
            }
            return result;
        } catch (Throwable throwable) {
            log.error("error: {}", throwable.getMessage());
            throw throwable;
        } finally {
            log.info("around end");
        }
    }
}
