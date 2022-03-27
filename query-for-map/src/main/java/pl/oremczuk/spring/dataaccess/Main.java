package pl.oremczuk.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        int numberOfProducts = productsRepository.getNumberOfProducts();
        System.out.println("Liczba wszystkich produktów wynosi: " + numberOfProducts);

        int numberOfProductsWherePriceGreaterThan = productsRepository.getNumerOfProductsWherePriceGreaterThan(50.0);
        System.out.println("Liczba produktów, których cena jest wyższa od 50: " + numberOfProductsWherePriceGreaterThan);

        Map<String, Object> productByProductCode = productsRepository.getProductByProductCode("S10_1949");
        System.out.println(productByProductCode);

    }
}
