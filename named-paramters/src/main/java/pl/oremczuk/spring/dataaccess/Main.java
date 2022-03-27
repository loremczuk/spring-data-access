package pl.oremczuk.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductsRepository productsRepository = context.getBean("productsRepository", ProductsRepository.class);
        List<Map<String, Object>> productsWithPriceRange = productsRepository.getProductsWithPriceRange(30.0, 80.00);
        List<Map<String, Object>> productsWithPriceRange2 = productsRepository.getProductsWithPriceRange2(30.0, 80.00);
        List<Map<String, Object>> productsWithPriceRange3 = productsRepository.getProductsWithPriceRange3(30.0, 80.00);


//        for (Map<String, Object> products : productsWithPriceRange3) {
//            System.out.println(products);
//        }

        Map<String, Object> productsWithPriceRange4 = productsRepository.getProductsWithPriceRange4(48.81);
//        System.out.println(productsWithPriceRange4);

        List<Map<String, Object>> productsWithPriceRange5 = productsRepository.getProductsWithPriceRange5(50.00);
        for (Map<String, Object> products : productsWithPriceRange5) {
            System.out.println(products);
        }

    }
}
