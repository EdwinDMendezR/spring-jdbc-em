package spring.jdbc;

//import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CustomerMapper
//        implements RowMapper<Customer>
{

  //      @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
