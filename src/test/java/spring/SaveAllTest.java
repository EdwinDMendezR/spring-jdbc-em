package spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.jdbc.Customer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
public class SaveAllTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Test
    public void methodTest() {

        // Arrange
        Customer customer1 = Customer.builder()
                .name("nA")
                .email("eA")
                .build();

        Customer customer2 = Customer.builder()
                .name("nB")
                .email("eB")
                .build();

        Customer customer3 = Customer.builder()
                .name("nC")
                .email("eC")
                .build();

        List<Customer> list = Arrays.asList(customer1, customer2, customer3);
        SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(list.toArray());

        // Act
        jdbcTemplate.batchUpdate("insert into customer (name, email) values (:name, :email)", Collections.singletonList(batchArgs));

        // Assert

    }


}
