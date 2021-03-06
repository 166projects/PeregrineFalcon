package com.mphasis.flight.conf;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages="com.mphasis.flight")
@EnableAspectJAutoProxy
public class AppConfig {
 
	@Bean
	public DriverManagerDataSource getDataSource()
	{
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@10.96.177.30:1521:xe");
		ds.setUsername("bhavya");
		ds.setPassword("1234");
		return ds;
		
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sessionFactory=new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		Properties props=new Properties();
		props.put("hibernate.dialect","org.hibernate.dialect.OracleDialect");
		props.put("hibernate.hbm2ddl.auto","update");
		props.put("hibernate.show_sql","true");
		props.put("hibernate.format_sql","true");
		//props.put("hibernate.default_schema","bhavya");
		sessionFactory.setHibernateProperties(props);
		sessionFactory.setPackagesToScan("com.mphasis.flight.entities");
		return sessionFactory;
		
	}
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		return hibernateTransactionManager;
	}
    @Bean
    public WebMvcConfigurer corsConfigurer() {
         return new WebMvcConfigurerAdapter() {
             public void addCorsMappings(CorsRegistry registry) {
                  registry.addMapping("/**")
                  .allowedOrigins("*")
                  .allowedMethods("HEAD", "GET", "POST", "PUT", "DELETE")
                  .allowedHeaders( "Origin",
                            "X-Requested-With", "Content-Type", "Accept","Authorization","Access-Control-Allow-Origin");
             }
         };
    }

}
