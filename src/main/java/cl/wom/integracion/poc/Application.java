package cl.wom.integracion.poc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource("file:${APP_ENV}")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Bean
//	public RestTemplate restTemplate() {
//
//		Integer timeout = Integer.parseInt(env.getProperty("http.timeout"));
//
//		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
//		requestFactory.setConnectTimeout(timeout);
//		requestFactory.setReadTimeout(timeout);
//
//		RestTemplate restTemplate = new RestTemplate();
//		restTemplate.setRequestFactory(requestFactory);
//
//		return restTemplate;
//	}
}
