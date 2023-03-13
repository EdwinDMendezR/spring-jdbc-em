package spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class BeanConfig {

    @Bean
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Bean
    CommandLineRunner loadDatabase() {
        return new CommandLineRunner() {

            @Override
            public void run(String... args) throws Exception {

                jdbcTemplate.execute("create table customer (id int primary key "
                        + "auto_increment, name varchar(30), email varchar(30))");

                jdbcTemplate.execute("insert into customer (name, email) "
                        + "values ('customerA', 'customerA@gmail.com')");

                jdbcTemplate.execute("insert into customer (name, email) "
                        + "values ('customerB', 'customerB@gmail.com')");

            }
        };
    }


}
