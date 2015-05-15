package xxxxx.yyyyy.zzzzz.aopalliance_example;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@lombok.extern.slf4j.Slf4j
public class HelloInterceptor implements MethodInterceptor {

    private final String name;

    public HelloInterceptor(String name) {
        this.name = name;
    }

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        long s = System.currentTimeMillis();
        log.info("[Start] ({}) {}#{}", name, invocation.getThis().getClass().getName(), invocation.getMethod().getName());
        try {
            return invocation.proceed();
        } finally {
            long e = System.currentTimeMillis();
            log.info("[End] ({}) {}#{} {} ms", name, invocation.getThis().getClass().getName(), invocation.getMethod().getName(), e - s);
        }
    }
}
