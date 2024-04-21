package com.bca;

import com.bca.dao.ProductDao;
import com.bca.entity.Product;
import com.bca.util.DataSourceConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.math.BigDecimal;

@SpringBootApplication
public class Productapp06SpringBootActuatorApplication implements CommandLineRunner {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private DataSourceConfig dataSourceConfig;

	public static void main(String[] args) {
		SpringApplication.run(Productapp06SpringBootActuatorApplication.class, args);
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
		if(jdbcTemplate!=null)
		{
			System.out.println("JdbcTemplate Config");
		}
		else {
			System.out.println("JdbcTemplate Not Config");
		}
		dataSourceConfig.makeConnection();

//		productDao.save(new Product("Laptop",BigDecimal.valueOf(120000)));
//		productDao.save(new Product("Coolpad",BigDecimal.valueOf(60000)));
//		productDao.delete(new Product(4,"Coolpad",BigDecimal.valueOf(60000)));
	}
}
