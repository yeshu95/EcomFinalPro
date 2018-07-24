package com.niit.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.CartModel;
import com.niit.model.CategoryModel;
import com.niit.model.OrdersModel;
import com.niit.model.ProductsModel;
import com.niit.model.SupplierModel;
import com.niit.model.UserModel;

@Configuration
@ComponentScan("com.niit.mobilestorebackend")
@EnableTransactionManagement
public class Application_Context {

    @Autowired
    @Bean(name = "dataSource")
    public DataSource getH2DataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
            
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test3");

        dataSource.setDriverClassName("org.h2.Driver");

        dataSource.setUsername("sa");
        dataSource.setPassword("");
        
        
        return dataSource;
    }
    
   private Properties getHibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }
   @Autowired
    @Bean(name = "sessionFactory")
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
        sessionBuilder.addProperties(getHibernateProperties());
        sessionBuilder.addAnnotatedClass(ProductsModel.class);
        sessionBuilder.addAnnotatedClass(CartModel.class);
        sessionBuilder.addAnnotatedClass(SupplierModel.class);
        sessionBuilder.addAnnotatedClass(CategoryModel.class);
        sessionBuilder.addAnnotatedClass(UserModel.class);
        sessionBuilder.addAnnotatedClass(OrdersModel.class);
        //sessionBuilder.scanPackages("com.niit.model");
        return sessionBuilder.buildSessionFactory();
    }

    @Autowired
    @Bean(name = "transactionManager")
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }
}
   