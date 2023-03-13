package spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.jdbc.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
public class InsertCustomerTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void methodTest() {

        // Arrange
        Customer customer = Customer.builder()
                .id(10)
                .name("customerC")
                .email("customerC@gmail.com")
                .build();

        BeanPropertySqlParameterSource customerMap = new BeanPropertySqlParameterSource(customer);

        // Act
        boolean resultado = jdbcTemplate.update(
                "insert into customer (name, email) values (?, ?)",
                customer.getName(),
                customer.getEmail()
        ) == 1;

        // Assert
        Assert.assertTrue(resultado);

    }

}