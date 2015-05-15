package xxxxx.yyyyy.zzzzz.aopalliance_example.aop;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ReflectiveMethodInvocation implements MethodInvocation {

    private final Object target;
    private final Method method;
    private final Object[] arguments;
    private final MethodInterceptor[] interceptors;
    private int i = -1;

    public ReflectiveMethodInvocation(final Object target, final Method method, final Object[] arguments, final MethodInterceptor[] interceptors) {
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptors = interceptors;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return this.arguments;
    }

    @Override
    public Object proceed() throws Throwable {
//        if (this.i == this.interceptors.length - 1) {
//            return invokeJoinpoint();
//        }
//        return interceptors[++i].invoke(this);
        return (this.i == this.interceptors.length - 1)
                ? invokeJoinpoint()
                : interceptors[++i].invoke(this);
    }

    @Override
    public Object getThis() {
        return this.target;
    }

    @Override
    public AccessibleObject getStaticPart() {
        return this.method;
    }

    private Object invokeJoinpoint() {
        try {
            return method.invoke(target, arguments);
        } catch (ReflectiveOperationException cause) {
            throw new RuntimeException(cause);
        }
    }
}
