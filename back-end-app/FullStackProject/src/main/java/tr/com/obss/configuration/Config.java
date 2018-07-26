package tr.com.obss.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import tr.com.obss.interceptor.ExecTimeLoggingInterceptor;
import tr.com.obss.security.config.SecurityConfig;

@EnableWebMvc
@Configuration
@ComponentScan("tr.com.obss")
@Import({SecurityConfig.class})
public class Config implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver jspViewResolver() {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/pages/");
		bean.setSuffix(".jsp");
		bean.setViewClass(JstlView.class);
		return bean;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl(
				"jdbc:mysql://localhost:3306/bookportal?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey");// change
																															// url
		dataSource.setUsername("root");// change userid
		dataSource.setPassword("aef.40267098624");// change pwd
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

//	@Bean
//	public UserDao dao() {
//		UserDaoImpl dao = new UserDaoImpl();
//		dao.setJdbcTemplate(jdbcTemplate());
//		return dao;
//	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new ExecTimeLoggingInterceptor());
	}

}
