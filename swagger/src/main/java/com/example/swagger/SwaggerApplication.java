package com.example.swagger;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.plugin.core.support.PluginRegistryFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@JdkProxyHint(
	types = {
		java.util.List.class,
		org.springframework.aop.SpringProxy.class,
		org.springframework.aop.framework.Advised.class,
		org.springframework.core.DecoratingProxy.class
	})
@TypeHint(
	types = {
		PluginRegistryFactoryBean.class
	},
	access = AccessBits.ALL
)
@SpringBootApplication
public class SwaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}

}

@Controller
@ResponseBody
class GreetingRestController {

	@GetMapping("/hello/{name}")
	Greeting greet(@PathVariable String name) {
		return new Greeting("Hello, " + name + "!");
	}
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Greeting {
	private String greeting;
}
