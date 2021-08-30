package com.uhg.api.demo_particle;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class DemoParticleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoParticleApplication.class, args);
	}

}
