package pl.oremczuk.spring.dataaccess;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OfficeRepository officeRepository = context.getBean("officeRepository", OfficeRepository.class);

        List<Office> offices = officeRepository.getAllOffices();
        for (Office office : offices) {
            System.out.println(office);
        }

    }
}
