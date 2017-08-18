package com.rsessions;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.CacheManager;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.GenericToStringSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.CookieHttpSessionStrategy;


//import com.rsessions.services.RedisService;

//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 450)
//@PropertySource("classpath:configuration/redis.properties")
@SpringBootApplication
public class RsessionsApplication  extends SpringBootServletInitializer{

//	/// ** The redis host. */
//	// @Value("${spring.redis.host}")
//	private String redisHost = "127.0.0.1";
//
//	/// ** The redis port. */
//	// @Value("${spring.redis.port}")
//	private int redisPort = 6379;

	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RsessionsApplication.class);
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(RsessionsApplication.class, args);
		if (null != ctx) {
//			RedisService redisService = ctx.getBean(RedisService.class);
//			redisService.setValue("key", "hello world!");
//
//			System.out.println("message: " + redisService.getValue("key"));
//			
//			try {
//				Thread.sleep(1000 * 6);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("message: " + redisService.getValue("key"));
		}

	}


//	@Bean
//	public CookieHttpSessionStrategy sessionStrategy() {
//		return new CookieHttpSessionStrategy();
//	}
//	
//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		factory.setHostName(redisHost);
//		factory.setPort(redisPort);
//		factory.setUsePool(true);
//		return factory;
//	}
//
//	
//	@Bean
//	RedisTemplate<String, Object> redisTemplate() {
//		final RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//		
//		if (null == jedisConnectionFactory()) {
//	        System.out.println("- -------------Jedis Template Service is not available");
//	        return null;
//	    }
//		redisTemplate.setConnectionFactory(jedisConnectionFactory());
//
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//		redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
//
//		//redisTemplate.setEnableTransactionSupport(true);
//
//		//redisTemplate.afterPropertiesSet();
//		return redisTemplate;
//	}
//	
//	@Bean
//	public RedissonClient redisson() throws IOException {
//		ClassLoader classLoader = getClass().getClassLoader();
//		File file = new File(classLoader.getResource("configuration/redisson.yaml").getFile());
//		Config config = Config.fromYAML(file);
//		return Redisson.create(config);
//	}
//
//	
//	@Bean
//	CacheManager cacheManager() {
//		return new RedisCacheManager(redisTemplate());
//	}

}
