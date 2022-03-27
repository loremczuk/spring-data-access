package pl.oremczuk.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);

        List<String> motorcycles = Collections.singletonList("Motorcycles");
        List<Map<String, Object>> products = productsRepository.getProductsWithProductLine(motorcycles);
        for (Map<String, Object> product : products) {
            System.out.println(product);
        }


    }
}
