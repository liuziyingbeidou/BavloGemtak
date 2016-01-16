package controller;

import itf.ICustomerService;
import model.CustomerVO;

import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webservice")
public class TestController {

		private static final DefaultListableBeanFactory beanFactory;
		
		static {
			beanFactory = new DefaultListableBeanFactory();
			BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
			Resource resource = new ClassPathResource("spring-mvc.xml");
			beanDefinitionReader.loadBeanDefinitions(resource);
		}
		
		@RequestMapping("/test")
		public void test() {
			//ICustomerService customerService = beanFactory.getBean("customerService", ICustomerService.class);
			ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml");
			ICustomerService service = (ICustomerService) ctx.getBean("customerService");
			
			System.out.println("IDÊÇ:"+service.findCustomerById(30));
		}
	
}
