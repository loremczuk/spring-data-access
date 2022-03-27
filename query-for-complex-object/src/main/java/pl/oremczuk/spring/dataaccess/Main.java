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

        OfficeRepository officeRepository = context.getBean("officeRepository", OfficeRepository.class);
        Office officeByOfficeCode = officeRepository.getOfficeByOfficeCode("6");
        System.out.println(officeByOfficeCode);

    }
}
