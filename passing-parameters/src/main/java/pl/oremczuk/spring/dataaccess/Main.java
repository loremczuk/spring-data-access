package pl.oremczuk.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        int numberOfProducts = productsRepository.getNumberOfProducts();
        System.out.println("Liczba wszystkich produktów wynosi: " + numberOfProducts);

        int numberOfProductsWherePriceGreaterThan = productsRepository.getNumerOfProductsWherePriceGreaterThan(50.0);
        System.out.println("Liczba produktów, których cena jest wyższa od 50: " + numberOfProductsWherePriceGreaterThan);

//        List<String> productLines = new ArrayList<>();
//        productLines.add("Motorcycles");
//        productLines.add("Classic Cars");
//
//
//        int numberOfProductsWithLine = productsRepository.getNumerOfProductsWhereProductLine(productLines);
//        System.out.println("ble: " + numberOfProductsWithLine);

    }
}
