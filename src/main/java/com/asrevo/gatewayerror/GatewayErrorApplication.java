package com.asrevo.gatewayerror;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableCaching
public class GatewayErrorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayErrorApplication.class, args);
	}

	@Bean
	@Primary
	public CacheManager cacheManager() {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager("users");
		cacheManager.setCaffeine(caffeineCacheBuilder());
		return cacheManager;
	}

	Caffeine< Object, Object > caffeineCacheBuilder() {
		return Caffeine.newBuilder()
				.initialCapacity(100)
				.maximumSize(500)
				.expireAfterAccess(10, TimeUnit.MINUTES)
				.weakKeys()
				.recordStats();
	}
}
