package com.morkath.multilang.config;

import javax.sql.DataSource;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:db.properties")
public class DatabaseConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
    public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
		config.setDriverClassName(env.getProperty("db.driver"));
		config.setJdbcUrl(env.getProperty("db.url"));
        config.setUsername(env.getProperty("db.user"));
        config.setPassword(env.getProperty("db.password"));
        
        config.setMaximumPoolSize(Integer.parseInt(env.getProperty("hikari.maximumPoolSize", "10")));
        config.setMinimumIdle(Integer.parseInt(env.getProperty("hikari.minimumIdle", "2")));
        config.setIdleTimeout(Long.parseLong(env.getProperty("hikari.idleTimeout", "30000")));
        config.setConnectionTimeout(Long.parseLong(env.getProperty("hikari.connectionTimeout", "30000")));
        config.setPoolName(env.getProperty("hikari.poolName", "HikariCP"));
        
        return new HikariDataSource(config);
    }
	
	@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.morkath.multilang.entity");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties props = new Properties();
        props.put("hibernate.dialect", env.getProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"));
        props.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto", "update"));
        props.put("hibernate.show_sql", env.getProperty("hibernate.show_sql", "true"));
        props.put("hibernate.format_sql", env.getProperty("hibernate.format_sql", "true"));
        em.setJpaProperties(props);

        return em;
    }
	
	@Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf) {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(emf.getObject());
        return txManager;
    }
}
