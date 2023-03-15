package spring;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.jdbc.Customer;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
public class LikeTest {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void methodTest() {

        // Arrange
        String customerName = "omerA";

        // Act
        Customer resultado = jdbcTemplate.queryForObject("select * from customer where name like ?",
                new Object[]{ "%" + customerName + "%"},
                new FindByIdTest.CustomerRowMapper()
        );

        // Assert
        Assert.assertEquals(1, resultado.getId());
        Assert.assertEquals("customerA", resultado.getName());
        Assert.assertEquals("customerA@gmail.com", resultado.getEmail());

    }

}
