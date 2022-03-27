package pl.oremczuk.spring.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ProductsRepository {

//    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    public ProductsRepository(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Autowired
    public void setDataSource (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    public int getNumberOfProducts() {

        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products", Integer.class);

    }
    public int getNumerOfProductsWherePriceGreaterThan (double limitPrice) {
        String sql = "SELECT COUNT(*) FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, limitPrice);

    }


//    public int getNumerOfProductsWhereProductLine (List<String> productLines) {
//        String sql = "SELECT COUNT(*) FROM products WHERE productLine IN (?)";
//        return jdbcTemplate.queryForObject(sql, Integer.class, productLines);
//
//    }
}
