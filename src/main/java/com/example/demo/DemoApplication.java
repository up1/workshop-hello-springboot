package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(DemoApplication.class, args);

		// Display all classes
		String[] beans = context.getBeanDefinitionNames();
		for (String bean: beans) {
			System.out.println(bean);
		}

		// Display total number of classes
		System.out.println("# of classes= " + beans.length);
		System.out.println("# of classes= " + context.getBeanDefinitionCount());

	}

}
