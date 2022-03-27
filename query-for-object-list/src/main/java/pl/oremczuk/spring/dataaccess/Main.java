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

        List<Map<String, Object>> productsWherePriceGreaterThan = productsRepository.getProductsWherePriceGreaterThan(50.0);
        for (Map<String, Object> productsMap : productsWherePriceGreaterThan) {
            System.out.println(productsMap);
        }

        double average = productsRepository.getPrices().stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println(average);

        // albo mniej skomplikowanie niż powyżej (lista cen bez średniej)
        List<Double> prices = productsRepository.getPrices();
        for (Double price : prices) {
            System.out.println(price);
        }

    }
}
