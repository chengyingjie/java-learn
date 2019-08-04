package dubbo;

import com.jesse.learn.dubbo.javaspi.Robot;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ServiceLoader;

public class JavaSPITest {

    @Test
    public void sayHello() throws NoSuchMethodException {
        /**
         * 实现原理：在ServiceLoader.load的时候，根据传入的接口类，遍历META-INF/services目录下的以该类命名的文件中的所有类，并实例化返回。
         */
        ServiceLoader<Robot> serviceLoader = ServiceLoader.load(Robot.class);
        System.out.println("Java SPI");

        for (Robot robot : serviceLoader) {
            robot.sayHello();
        }
        serviceLoader.forEach(Robot::sayHello);

        Class<JavaSPITest> c = (Class<JavaSPITest>) this.getClass();

        // 获取需要处理的方法Method实例
        Method method = c.getMethod("sayHello");

        Test test = method.getAnnotation(Test.class);
    }
}
