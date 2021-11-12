package com.dqdwd.listener;

import com.dqdwd.pojo.ProductType;
import com.dqdwd.service.ProductTypeService;
import com.dqdwd.service.impl.ProductInfoServiceImpl;
import com.dqdwd.service.impl.ProductTypeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
@WebListener
public class ProductTypeListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext_*.xml");
        //动态代理必须是接口
        ProductTypeService productTypeServiceImpl =(ProductTypeService) context.getBean("ProductTypeServiceImpl");
        List<ProductType> typeList = productTypeServiceImpl.getTypeAll();
        sce.getServletContext().setAttribute("typeList",typeList);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }

}

