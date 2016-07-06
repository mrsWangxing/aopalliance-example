package xxxxx.yyyyy.zzzzz.aopalliance_example.aop;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;

public class ReflectiveMethodInvoker implements MethodInvoker {

    private final MethodInterceptor[] interceptors;

    public ReflectiveMethodInvoker(MethodInterceptor[] interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(Object target, Method method, Object... arguments) throws Throwable {
        return new ReflectiveMethodInvocation(target, method, arguments, this.interceptors).proceed();
    }
}
