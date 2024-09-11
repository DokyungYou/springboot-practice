package hello.container;

import jakarta.servlet.ServletContainerInitializer;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.HandlesTypes;

import java.util.Set;

@HandlesTypes(AppInit.class) // 해당 클래스를 핸들
public class MyContainerInitV2 implements ServletContainerInitializer {
    @Override // 핸들대상인 클래스의 구현체를 모두 찾아서 Class 정보로 전달
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
        System.out.println("MyContainerInitV2.onStartup");

        for (Class<?> appInitClass : c) {
            // 객체가 아닌 클래스 정보로 넘어오기때문에 리플렉션을 써서 객체를 만들어줘야한다
            try{
                AppInit appInit = (AppInit) appInitClass.getDeclaredConstructor().newInstance();// new AppInitV1Servlet() 와 같음
                appInit.onStartup(ctx); // 서블릿 등록
            }catch (Exception e){

            }
        }
        System.out.println("ServletContext = " + ctx);
    }
}
