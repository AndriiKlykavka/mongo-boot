package ua.kv.klykavka.andrii;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(App.class.getPackageName());

        Calculator calculator = applicationContext.getBean(Calculator.class);

        System.out.println(calculator.calculate(10, 10, '+'));
        System.out.println(calculator.calculate(15, 7, '-'));
        System.out.println(calculator.calculate(27, 9, '/'));
        System.out.println(calculator.calculate(5, 6, '*'));
    }
}