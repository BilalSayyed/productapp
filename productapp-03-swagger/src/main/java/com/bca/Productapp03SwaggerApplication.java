package com.bca;

import com.bca.config.DbConfig;
import com.bca.dao.ProductDao;
import com.bca.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import javax.sql.DataSource;
import java.math.BigDecimal;

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

	@Override
	public void run(String... args) throws Exception {
		if(dataSource!=null)
		{
			System.out.println("DataSource Config");
		}
		else {
			System.out.println("DataSource Not Config");
		}

//		productDao.save(new Product("Laptop",BigDecimal.valueOf(120000)));
//		productDao.save(new Product("Coolpad",BigDecimal.valueOf(60000)));
//		productDao.delete(new Product(4,"Coolpad",BigDecimal.valueOf(60000)));
	}
}
