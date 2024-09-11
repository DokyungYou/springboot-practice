package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import java.util.Set;

public class MyContainerInitV1 implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV1.onStartup");
        System.out.println("MyContainerInitV1 Set<Class<?>> = " + c);
        System.out.println("MyContainerInitV1 ServletContext = " + ctx); // org.apache.catalina.core.ApplicationContextFacade@7cc5d5ac
    }
}
