package xxxxx.yyyyy.zzzzz.aopalliance_example;

import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Before;
import org.junit.Test;
import xxxxx.yyyyy.zzzzz.aopalliance_example.aop.ReflectiveMethodInvoker;

public class HelloServiceTest {

    private final MethodInterceptor[] interceptors = {
        new HelloInterceptor("A"),
        new HelloInterceptor("B"),
        new HelloInterceptor("C")
    };
    private Method method;

    @Before
    public void before() {
        try {
            method = HelloService.class.getDeclaredMethod("hello");
        } catch (ReflectiveOperationException cause) {
            throw new RuntimeException(cause);
        }
    }

    @Test
    public void UnitOfWork_StateUnderTest_ExpectedBehavior() throws Throwable { // TODO should change method name
        new ReflectiveMethodInvoker(interceptors).invoke(new HelloService(), method);
    }
}
