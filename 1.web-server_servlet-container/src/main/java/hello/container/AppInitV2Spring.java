package hello.container;

import hello.spring.HelloController;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitV2Spring implements AppInit {
    @Override
    public void onStartup(ServletContext servletContext) {
        System.out.println("AppInitV2Spring.onStartup");

        // 스프링 컨테이너 생성
        // AnnotationConfigWebApplicationContext: 애노테이션 기반 설정과 웹 기능을 지원하는 스프링 컨테이너
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext(); // -> ApplicationContext
        appContext.register(HelloController.class);

        // 스프링 MVC 디스패처 서블릿 생성, 스프링 컨테이너와 연결
        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // 고객요청(HTTP) -> WAS -> 필터체인 -> 서블릿(디스패쳐 서블릿)
        // 해당서블릿에서 애플리케이션 컨텍스트를 내부에 알고 있기때문에, 빈을 찾을 수 있음

        // 디스패쳐 서블릿을 서블릿 컨테이너에 등록 (이름등록시 중복 주의: dispatcherV2)
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherV2", dispatcherServlet);

        // "/spring/*" -> "/spring" 과 그 하위 요청이 디스패처 서블릿을 통하도록 설정
        servlet.addMapping("/spring/*");
    }
}
