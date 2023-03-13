package spring;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.jdbc.Customer;
import spring.jdbc.CustomerDao;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { })
public class FindAllTest {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void methodTest() {
        List<Customer> resultado = customerDao.findAll();
        Assert.assertEquals(2, resultado.size());
    }

}
