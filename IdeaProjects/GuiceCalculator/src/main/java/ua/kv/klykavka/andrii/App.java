package ua.kv.klykavka.andrii;

import com.google.inject.Guice;
import com.google.inject.Injector;

import javax.inject.Inject;

public class App {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MainModule());

        Calculator calculator =injector.getInstance(Calculator.class);

        System.out.println(calculator.calculate(10, 10, '+'));
        System.out.println(calculator.calculate(15, 7, '-'));
        System.out.println(calculator.calculate(5, 6, '*'));
        System.out.println(calculator.calculate(27, 9, '/'));
    }
}
