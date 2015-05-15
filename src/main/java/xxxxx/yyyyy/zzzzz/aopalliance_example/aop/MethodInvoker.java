package xxxxx.yyyyy.zzzzz.aopalliance_example.aop;

import java.lang.reflect.Method;

public interface MethodInvoker {

    Object invoke(Object target, Method method, Object... arguments) throws Throwable;
}
