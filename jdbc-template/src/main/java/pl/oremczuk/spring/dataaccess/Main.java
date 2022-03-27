package pl.oremczuk.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("app-config.xml");
        ProductsRepository productsRpository = context.getBean("productsRepository", ProductsRepository.class);
        int numberOfProducts = productsRpository.getNumberOfProducts();
        System.out.println("Liczba wszystkich produktów wynosi: " + numberOfProducts);
    }
}
