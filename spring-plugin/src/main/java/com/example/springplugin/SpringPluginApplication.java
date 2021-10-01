package com.example.springplugin;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.nativex.hint.AccessBits;
import org.springframework.nativex.hint.JdkProxyHint;
import org.springframework.nativex.hint.TypeHint;
import org.springframework.plugin.core.Plugin;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.plugin.core.config.EnablePluginRegistries;
import org.springframework.plugin.core.support.PluginRegistryFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Locale;

@JdkProxyHint (types = {
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
@EnablePluginRegistries(WriterPlugin.class)
@SpringBootApplication
public class SpringPluginApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPluginApplication.class, args);
	}

	@Bean
	ApplicationRunner runner(PluginRegistry<WriterPlugin, String> plugins) {
		return args -> {
			for (var format : "csv,txt".split(","))
				plugins.getPluginFor(format).get().write("hello");
		};
	}
}

interface WriterPlugin extends Plugin<String> {
	void write(String message);
}

@Component
class CsvWriter implements WriterPlugin {

	@Override
	public void write(String message) {
		System.out.println("writing " + message + " as csv");
	}

	@Override
	public boolean supports(String delimiter) {
		return (delimiter + "").toLowerCase(Locale.ROOT).contains("csv");
	}
}

@Component
class TxtWriter implements WriterPlugin {

	@Override
	public void write(String message) {
		System.out.println("writing " + message + " as txt");
	}

	@Override
	public boolean supports(String delimiter) {
		return (delimiter + "").toLowerCase(Locale.ROOT).contains("txt");
	}
}
