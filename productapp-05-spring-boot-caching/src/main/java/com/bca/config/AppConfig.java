package com.bca.config;

import com.bca.util.DataSourceConfig;
import com.bca.util.EnableDevDataSource;
import com.bca.util.EnableProdDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

@Bean
@Primary
    @ConditionalOnProperty(name="prod.datasource.enabled",havingValue = "false")
    public DataSourceConfig enableProdDataSource()
{
return  new EnableProdDataSource();
}
    @Bean
    @ConditionalOnMissingBean(EnableProdDataSource.class)
    public DataSourceConfig enableDevDataSource()
    {

        return  new EnableDevDataSource();
    }
}
