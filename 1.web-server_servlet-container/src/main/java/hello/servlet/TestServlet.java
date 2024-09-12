package hello.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

// @WebServlet 애노테이션 방식으로 서블릿 컨테이너에 등록
@WebServlet(urlPatterns = "/test") // 톰캣에 배포를 해야 요청가능
public class TestServlet extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("TestServlet.service");
        res.getWriter().write("test");
    }
}
