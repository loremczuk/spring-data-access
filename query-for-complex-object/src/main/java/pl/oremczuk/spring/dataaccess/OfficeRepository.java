package pl.oremczuk.spring.dataaccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class OfficeRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Office getOfficeByOfficeCode (String officeCode) {

        String sql = "SELECT * FROM offices WHERE officeCode = ?";

        RowMapper<Office> rowMapper = new RowMapper<>() {
            @Override
            public Office mapRow(ResultSet rs, int index) throws SQLException {

                Office office = new Office();
                office.setOfficeCode(rs.getString("officeCode"));
                office.setPhone(rs.getString("phone"));
                office.setAddressLine1(rs.getString("AddressLine1"));
                office.setAddressLine2(rs.getString("AddressLine2"));
                office.setCity(rs.getString("city"));
                office.setCountry(rs.getString("country"));
                office.setPostalCode(rs.getString("postalCode"));
                office.setState(rs.getString("state"));
                office.setTerritory(rs.getString("territory"));
                return office;

            }
        };
        return jdbcTemplate.queryForObject(sql, rowMapper, officeCode);

    }
}
