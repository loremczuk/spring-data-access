package pl.oremczuk.spring.dataaccess;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "pl.oremczuk.spring.dataaccess")
public class AppConfig {

    @Bean
    public DataSource dataSource () {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setDatabaseName("classicmodels");
        dataSource.setServerName("localhost");
        dataSource.setUser("root");
        dataSource.setPassword("lubieplacki");

        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate () {
        return new JdbcTemplate(dataSource());
    }


}
