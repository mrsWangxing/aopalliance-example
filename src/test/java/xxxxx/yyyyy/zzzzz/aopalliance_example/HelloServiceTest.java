package xxxxx.yyyyy.zzzzz.aopalliance_example;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.Test;
import xxxxx.yyyyy.zzzzz.aopalliance_example.aop.ReflectiveMethodInvoker;

public class HelloServiceTest {

    @Test
    public void UnitOfWork_StateUnderTest_ExpectedBehavior() throws Throwable { // TODO should change method name
        MethodInterceptor[] interceptors = {
            new HelloInterceptor("A"),
            new HelloInterceptor("B"),
            new HelloInterceptor("C")
        };
        new ReflectiveMethodInvoker(interceptors).invoke(new HelloService(), HelloService.class.getDeclaredMethod("hello"));
    }
}
