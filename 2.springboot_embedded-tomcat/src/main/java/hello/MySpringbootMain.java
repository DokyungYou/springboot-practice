package hello;

import hello.boot.MySpringApplication;
import hello.boot.MySpringbootApplication;

@MySpringbootApplication
public class MySpringbootMain {
    public static void main(String[] args) {
        System.out.println("MySpringbootMain.main");
        MySpringApplication.run(MySpringbootMain.class, args);
    }
}
