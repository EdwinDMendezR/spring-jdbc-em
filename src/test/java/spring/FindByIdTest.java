package spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.jdbc.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
public class FindByIdTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    class CustomerRowMapper implements RowMapper<Customer> {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Customer.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .email(rs.getString("email"))
                    .build();
        }
    }


    @Test
    public void methodTest() {

        // Arrange
        int customerId = 1;

        // Act
        Customer resultado = jdbcTemplate.queryForObject("select * from customer where id=?",
                new Object[]{customerId},
                new CustomerRowMapper()
        );

        // Assert
        Assert.assertEquals(1, resultado.getId());
        Assert.assertEquals("customerA", resultado.getName());
        Assert.assertEquals("customerA@gmail.com", resultado.getEmail());

    }

}
