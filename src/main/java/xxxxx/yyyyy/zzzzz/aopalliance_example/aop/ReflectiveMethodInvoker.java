package xxxxx.yyyyy.zzzzz.aopalliance_example.aop;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;

public class ReflectiveMethodInvoker implements MethodInvoker {

    private final MethodInterceptor[] interceptors;

    public ReflectiveMethodInvoker(final MethodInterceptor[] interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public Object invoke(final Object target, final Method method, final Object... arguments) throws Throwable {
        return new ReflectiveMethodInvocation(target, method, arguments, interceptors).proceed();
    }
}
