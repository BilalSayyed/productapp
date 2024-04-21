package com.bca;

import com.bca.config.DbConfig;
import com.bca.dao.ProductDao;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({DbConfig.class})
public class Productapp03SwaggerApplication implements CommandLineRunner {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private ProductDao productDao;

    public static void main(String[] args) {
        SpringApplication.run(Productapp03SwaggerApplication.class, args);
    }

    public void run(String... args) throws Exception {
        if (this.dataSource != null) {
            System.out.println("DataSource Config");
        } else {
            System.out.println("DataSource Not Config");
        }

    }
}
