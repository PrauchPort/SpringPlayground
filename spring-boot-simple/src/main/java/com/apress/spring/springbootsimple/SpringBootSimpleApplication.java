package com.apress.spring.springbootsimple;

import java.io.PrintStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootSimpleApplication {

	public static void main(String[] args) {
		
		Logger log = LoggerFactory.getLogger(SpringBootSimpleApplication.class);
		
		new SpringApplicationBuilder(SpringBootSimpleApplication.class)
				.bannerMode(Banner.Mode.CONSOLE)
				.listeners(new ApplicationListener<ApplicationEvent>() {
					@Override
					public void onApplicationEvent(ApplicationEvent event)
					{
						log.info("##### > " + event.getClass().getCanonicalName());
					}
				})
				.run(args);
		
	}

}



@Component
class MyComponent
{
	
	private static final Logger log = LoggerFactory.getLogger(MyComponent.class);
	
	@Autowired
	public MyComponent(ApplicationArguments args)
	{
		
		
		boolean enable = args.containsOption("enable");
		if(enable)
			log.info("#### > Enable present");
		
	}
	
}





