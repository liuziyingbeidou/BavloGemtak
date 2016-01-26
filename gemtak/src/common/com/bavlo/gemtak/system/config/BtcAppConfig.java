package com.bavlo.gemtak.system.config;

import java.sql.SQLException;
import java.util.Properties;
import java.util.concurrent.Executor;

import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.scheduling.SchedulingTaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.commonj.TimerManagerTaskScheduler;
import org.springframework.scheduling.commonj.WorkManagerTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.transaction.jta.WebSphereUowTransactionManager;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.web.context.ServletContextAware;

import com.bavlo.gemtak.config.Constant;
import com.bavlo.gemtak.config.LocalNamingStrategy;
import com.bavlo.gemtak.dao.HibernateDAO;
import com.bavlo.gemtak.dao.IHibernateDAO;
import com.bavlo.gemtak.service.ICommonService;
import com.bavlo.gemtak.service.impl.CommonService;

/**
 * @Title: 宝珑Counter
 * @ClassName: BtcAppConfig 
 * @Description: 
 * @author liuzy
 * @date 2015-9-20 上午11:56:09
 */
@EnableAsync
@EnableScheduling
@Configuration
public class BtcAppConfig implements ServletContextAware,AsyncConfigurer,SchedulingConfigurer,ApplicationContextAware{
	
    @Autowired
    private DataSource dataSource;
	
	private static final Log logger = LogFactory.getLog(BtcAppConfig.class);
	
	private @Value("${hibernate.show_sql}") String show_sql;
	private @Value("${hibernate.connection.datasource}") String connection_datasource;
	private @Value("${system.hibernate.scanPackages}") String scanPackages;
	private @Value("${system.spring.messageSource}") String messageSource;
	private @Value("${hibernate.hbm2ddl.auto}") String hbm2ddl_auto;
	private @Value("${hibernate.default_schema}") String default_schema;
	
	@Bean(name="hibernateProperties")
	@DependsOn("dataSource")
	public Properties getHibernateProperties() throws IllegalArgumentException, SQLException, NamingException{
		
		Properties properties = new Properties();
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		properties.put("hibernate.show_sql", show_sql);
		if(StringUtils.isNotEmpty(hbm2ddl_auto) && hbm2ddl_auto.indexOf("create") != -1) {
			properties.put("hibernate.hbm2ddl.auto", "none");
		}
		else {
			properties.put("hibernate.hbm2ddl.auto",hbm2ddl_auto);
		}
		
		String defaultSchema = dataSource.getConnection().getMetaData().getUserName();
		properties.put("hibernate.default_schema", default_schema);
		
		if(!isSimpleServer){
			properties.put("hibernate.transaction.factory_class", "org.hibernate.engine.transaction.internal.jta.CMTTransactionFactory");
			properties.put("hibernate.transaction.jta.platform", "org.hibernate.service.jta.platform.internal.WebSphereExtendedJtaPlatform");
			properties.put("hibernate.transaction.auto_close_session", "true");
			properties.put("hibernate.transaction.flush_before_completion", "true");
		}
		
		
		for(Object key : properties.keySet()){
			logger.info("************************" + key + " = " + properties.getProperty((String)key));
		}
		
		return properties;
	}
	

	
	@Bean(name="transactionManager")
	public AbstractPlatformTransactionManager getTransactionManager() throws IllegalArgumentException, NamingException, SQLException {
		if(isSimpleServer){
			HibernateTransactionManager tx = new HibernateTransactionManager();
			tx.setSessionFactory(this.getSessionFactory());
			return tx;
		}
		else{
			WebSphereUowTransactionManager tx = new WebSphereUowTransactionManager();
			return tx;
		}
	}
	
	
	@Bean(name="sessionFactory")
	@DependsOn("dataSource")
	public SessionFactory getSessionFactory() throws IllegalArgumentException, NamingException, SQLException {
		Properties properties = getHibernateProperties();
		LocalSessionFactoryBuilder b = new LocalSessionFactoryBuilder(dataSource);
		b.scanPackages(scanPackages.split(","));
		b.addProperties(properties);
		b.setNamingStrategy(new LocalNamingStrategy());
		return b.buildSessionFactory();  
	}
	
	@Bean(name="JdbcTemplate")
	JdbcTemplate JdbcTemplate_() throws IllegalArgumentException, NamingException, SQLException{
		JdbcTemplate JdbcTemplate = new JdbcTemplate();
		JdbcTemplate.setDataSource(dataSource);
		return JdbcTemplate;
	}
	@Bean(name="SimpleJdbcCall")
	SimpleJdbcCall SimpleJdbcCall_() throws IllegalArgumentException, NamingException, SQLException{
		SimpleJdbcCall SimpleJdbcCall = new SimpleJdbcCall(this.JdbcTemplate_());
		
		return SimpleJdbcCall;
	}
	
	
	/**
	 * Description: @Bean(name="dataSource")改成配置文件配置<br>
	 * @return
	 * @throws IllegalArgumentException
	 * @throws NamingException
	 * @throws SQLException 
	 * @see
	 */
	public DataSource getDataSource() throws IllegalArgumentException, NamingException, SQLException   {
		
		JndiObjectFactoryBean jndi = new JndiObjectFactoryBean();
		jndi.setJndiName(isSimpleServer ?  ("java:/comp/env/" + connection_datasource) : connection_datasource);
		jndi.setResourceRef(true);
		jndi.setCache(true);
		jndi.setLookupOnStartup(false);
		jndi.setProxyInterface(javax.sql.DataSource.class);
		jndi.afterPropertiesSet();
		String x = ((DataSource)jndi.getObject()).getConnection().getMetaData().getURL();
		if(x.indexOf("zbdb")!=-1){
			DB_ENV = "product";
		}
		else{
			DB_ENV = "development";
		}
		USER_NAME = ((DataSource)jndi.getObject()).getConnection().getMetaData().getUserName();
		
		return (DataSource)jndi.getObject();
	}
	
	public static String DB_ENV = "";
	@Bean(name="messageSource")
	public ResourceBundleMessageSource getResourceBundleMessageSource(){
		ResourceBundleMessageSource m = new ResourceBundleMessageSource();
		m.setBasenames(messageSource.split(","));
		m.setUseCodeAsDefaultMessage(true);
		return m;
	}
	

	public void setServletConfig(ServletConfig arg0) {
	}



	
	public static boolean isSimpleServer = true;
	public static String USER_NAME = "";
	public void setServletContext(ServletContext arg0) {
		Constant.CONFIG_PATH = arg0.getRealPath("/");
		String ServerInfo = arg0.getServerInfo();
		isSimpleServer = (ServerInfo.indexOf("Tomcat") >=0  || ServerInfo.indexOf("jetty")>=0)? true : false;
		
		if(ServerInfo.indexOf("Tomcat") >= 0){
			serverInfo = "tomcat";
		}
		else if(ServerInfo.indexOf("jetty")>=0){
		    serverInfo = "jetty";
		}
		else if(ServerInfo.indexOf("WebSphere") >= 0){
			serverInfo = "was";
		}
		else if(ServerInfo.indexOf("Weblogic") >= 0){
			serverInfo = "wls";
		}
		else if(ServerInfo.indexOf("JBoss") >= 0){
			serverInfo = "jboss";
		}
		else{
			
		}
	
		Constant.TEMP_PATH = System.getenv("TMP");
		Constant.ServerInfo =  arg0.getServerInfo();
		
	}
	
	@Bean(name="commonService")
	public ICommonService getCommonService() throws IllegalArgumentException, NamingException, SQLException{
		CommonService  c = new CommonService();
		c.setDao(getHibernateDAO());
		return c;
	}
	
	@Bean(name="hibernateDAO")
	public IHibernateDAO getHibernateDAO() throws IllegalArgumentException, NamingException, SQLException{
		HibernateDAO dao = new HibernateDAO();
		dao.setTm(this.getTransactionManager());
		dao.setSessionFactory(this.getSessionFactory());
		return dao;
	}
static String  serverInfo = "";
	
	private @Value("#{appProperties['system.executor.wm_name']?:'wm/default'}") String WorkManagerName;
	private @Value("#{appProperties['system.scheduler.tm_name']?:'tm/default'}") String TimerManagerName;

	public Executor getAsyncExecutor() {
		
		
		return x.getBean("executor",Executor.class) == null ? getTaskExecutor() : x.getBean("executor",Executor.class);
	}
	
	public void configureTasks(ScheduledTaskRegistrar arg0) {
		arg0.setScheduler((x.getBean("scheduler",TaskScheduler.class) == null ? getTaskScheduler() : x.getBean("scheduler",TaskScheduler.class)));
	}

	@Bean(name="executor")
	public SchedulingTaskExecutor getTaskExecutor(){
		
		if(serverInfo.equals("tomcat")){
			ThreadPoolTaskExecutor e = new ThreadPoolTaskExecutor();
			e.setCorePoolSize(300);
			e.setMaxPoolSize(500);
			e.setQueueCapacity(1000);
			return e;
		}
		if(serverInfo.equals("was") || serverInfo.equals("wls")){
			WorkManagerTaskExecutor e = new WorkManagerTaskExecutor();
			e.setResourceRef(true);
			e.setWorkManagerName(WorkManagerName);
			return e;
		}
		
		return null;
	}
	
	@Bean(name="scheduler")
	public TaskScheduler getTaskScheduler(){
		
		if(serverInfo.equals("was") || serverInfo.equals("wls")){
			TimerManagerTaskScheduler s = new TimerManagerTaskScheduler(); 
			s.setResourceRef(true);
			s.setTimerManagerName(TimerManagerName);
			s.setShared(false);
			
			return s;
		}
		else{
			ThreadPoolTaskScheduler  s = new ThreadPoolTaskScheduler();
			s.setPoolSize(300);
			return s;
		}
	}


	private static ApplicationContext x;

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		x = arg0;
		
	}

}
