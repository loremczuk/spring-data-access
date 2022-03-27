package pl.oremczuk.spring.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class ProductsRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    public ProductsRepository(DataSource dataSource) {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//    }

    @Autowired
    public void setDataSource (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }


    public int getNumberOfProducts() {

        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM products", Integer.class);

    }
    public int getNumerOfProductsWherePriceGreaterThan (double limitPrice) {
        String sql = "SELECT COUNT(*) FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForObject(sql, Integer.class, limitPrice);

    }

    public Map<String,Object> getProductByProductCode (String productCode) {

        String sql = "SELECT productName AS nazwaProduktu, buyPrice AS cena FROM products where productCode = ?";
        return jdbcTemplate.queryForMap(sql, productCode);


    }

    public List<Map<String, Object>> getProductsWherePriceGreaterThan (double priceLimit) {
        String sql="SELECT * FROM products WHERE buyPrice > ?";
        return jdbcTemplate.queryForList(sql,priceLimit);

    }

    public List<Double> getPrices () {
        String sql = "SELECT buyPrice FROM products";
        return jdbcTemplate.queryForList(sql, Double.class);
    }

    public List<Map<String, Object>> getProductsWithPriceRange (double minPrice, double maxPrice) {
        String sql = "SELECT * FROM products WHERE buyPrice >= :minPrice AND buyPrice <= :maxPrice";

        SqlParameterSource parameters = new MapSqlParameterSource("minPrice", minPrice).addValue("maxPrice", maxPrice);
        return namedParameterJdbcTemplate.queryForList(sql,parameters);
    }

    public List<Map<String, Object>> getProductsWithPriceRange2 (double minPrice, double maxPrice) {
        String sql = "SELECT * FROM products WHERE buyPrice >= :minPrice AND buyPrice <= :maxPrice";

        Map<String,Object> productMap = new HashMap<>();
        productMap.put("minPrice", minPrice);
        productMap.put("maxPrice", maxPrice);
        SqlParameterSource parameters = new MapSqlParameterSource(productMap);

        return namedParameterJdbcTemplate.queryForList(sql,parameters);
    }

    public List<Map<String, Object>> getProductsWithPriceRange3 (double minPrice, double maxPrice) {
        String sql = "SELECT * FROM products WHERE buyPrice >= :minPrice AND buyPrice <= :maxPrice";

        Map<String,Object> productMap = new HashMap<>();
        productMap.put("minPrice", minPrice);
        productMap.put("maxPrice", maxPrice);

        return namedParameterJdbcTemplate.queryForList(sql,productMap);
    }


    public Map<String, Object> getProductsWithPriceRange4 (double minPrice) {
        String sql = "SELECT * FROM products WHERE buyPrice = :minPrice";

        Map<String,Object> productMap = Collections.singletonMap("minPrice", minPrice);

        return namedParameterJdbcTemplate.queryForMap(sql,productMap);
    }

    public List<Map<String, Object>> getProductsWithProductLine (List<String> productLines) {
        String sql = "SELECT * FROM products WHERE productLine IN (:productLines)";

        Map<String, List<String>> productLineMap = Collections.singletonMap("productLines", productLines);
        return namedParameterJdbcTemplate.queryForList(sql, productLineMap);

    }



}
