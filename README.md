# gateway-error
error with spring cloud issue https://github.com/spring-cloud/spring-cloud-commons/issues/1193
## steps to produce the error 
1. `mvn clean native:compile -Pnative`
2. `./target/gateway-error`

```
Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'cacheManager': Instantiation of supplied bean failed
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainInstanceFromSupplier(AbstractAutowireCapableBeanFactory.java:1236) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainFromSupplier(AbstractAutowireCapableBeanFactory.java:1210) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBeanInstance(AbstractAutowireCapableBeanFactory.java:1157) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:561) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:521) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.support.DefaultListableBeanFactory.preInstantiateSingletons(DefaultListableBeanFactory.java:961) ~[gateway-error:6.0.4]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:915) ~[gateway-error:6.0.4]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:584) ~[gateway-error:6.0.4]
	at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.refresh(ReactiveWebServerApplicationContext.java:66) ~[gateway-error:3.0.2-SNAPSHOT]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:730) ~[gateway-error:3.0.2-SNAPSHOT]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:432) ~[gateway-error:3.0.2-SNAPSHOT]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:308) ~[gateway-error:3.0.2-SNAPSHOT]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1302) ~[gateway-error:3.0.2-SNAPSHOT]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1291) ~[gateway-error:3.0.2-SNAPSHOT]
	at com.asrevo.gatewayerror.GatewayErrorApplication.main(GatewayErrorApplication.java:20) ~[gateway-error:na]
Caused by: java.lang.IllegalStateException: com.github.benmanes.caffeine.cache.WSSMSA
	at com.github.benmanes.caffeine.cache.LocalCacheFactory.loadFactory(LocalCacheFactory.java:90) ~[na:na]
	at com.github.benmanes.caffeine.cache.LocalCacheFactory.newBoundedLocalCache(LocalCacheFactory.java:40) ~[na:na]
	at com.github.benmanes.caffeine.cache.BoundedLocalCache$BoundedLocalManualCache.<init>(BoundedLocalCache.java:3891) ~[gateway-error:na]
	at com.github.benmanes.caffeine.cache.BoundedLocalCache$BoundedLocalManualCache.<init>(BoundedLocalCache.java:3887) ~[gateway-error:na]
	at com.github.benmanes.caffeine.cache.Caffeine.build(Caffeine.java:1053) ~[na:na]
	at org.springframework.cache.caffeine.CaffeineCacheManager.createNativeCaffeineCache(CaffeineCacheManager.java:254) ~[na:na]
	at org.springframework.cache.caffeine.CaffeineCacheManager.createCaffeineCache(CaffeineCacheManager.java:243) ~[na:na]
	at org.springframework.cache.caffeine.CaffeineCacheManager.refreshCommonCaches(CaffeineCacheManager.java:263) ~[na:na]
	at org.springframework.cache.caffeine.CaffeineCacheManager.doSetCaffeine(CaffeineCacheManager.java:143) ~[na:na]
	at org.springframework.cache.caffeine.CaffeineCacheManager.setCaffeine(CaffeineCacheManager.java:116) ~[na:na]
	at com.asrevo.gatewayerror.GatewayErrorApplication.cacheManager(GatewayErrorApplication.java:27) ~[gateway-error:na]
	at com.asrevo.gatewayerror.GatewayErrorApplication$$SpringCGLIB$$0.CGLIB$cacheManager$1(<generated>) ~[gateway-error:na]
	at com.asrevo.gatewayerror.GatewayErrorApplication$$SpringCGLIB$$2.invoke(<generated>) ~[gateway-error:na]
	at org.springframework.cglib.proxy.MethodProxy.invokeSuper(MethodProxy.java:258) ~[gateway-error:6.0.4]
	at org.springframework.context.annotation.ConfigurationClassEnhancer$BeanMethodInterceptor.intercept(ConfigurationClassEnhancer.java:331) ~[na:na]
	at com.asrevo.gatewayerror.GatewayErrorApplication$$SpringCGLIB$$0.cacheManager(<generated>) ~[gateway-error:na]
	at com.asrevo.gatewayerror.GatewayErrorApplication__BeanDefinitions.lambda$getCacheManagerInstanceSupplier$0(GatewayErrorApplication__BeanDefinitions.java:30) ~[na:na]
	at org.springframework.util.function.ThrowingFunction.apply(ThrowingFunction.java:63) ~[gateway-error:6.0.4]
	at org.springframework.util.function.ThrowingFunction.apply(ThrowingFunction.java:51) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.lambda$withGenerator$0(BeanInstanceSupplier.java:173) ~[na:na]
	at org.springframework.util.function.ThrowingBiFunction.apply(ThrowingBiFunction.java:68) ~[gateway-error:6.0.4]
	at org.springframework.util.function.ThrowingBiFunction.apply(ThrowingBiFunction.java:54) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.lambda$get$2(BeanInstanceSupplier.java:208) ~[na:na]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:59) ~[gateway-error:6.0.4]
	at org.springframework.util.function.ThrowingSupplier.get(ThrowingSupplier.java:47) ~[gateway-error:6.0.4]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.invokeBeanSupplier(BeanInstanceSupplier.java:220) ~[na:na]
	at org.springframework.beans.factory.aot.BeanInstanceSupplier.get(BeanInstanceSupplier.java:208) ~[na:na]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.obtainInstanceFromSupplier(AbstractAutowireCapableBeanFactory.java:1225) ~[gateway-error:6.0.4]
	... 18 common frames omitted
Caused by: java.lang.ClassNotFoundException: com.github.benmanes.caffeine.cache.WSSMSA
	at java.base@17.0.5/java.lang.Class.forName(DynamicHub.java:1132) ~[gateway-error:na]
	at java.base@17.0.5/java.lang.Class.forName(DynamicHub.java:1105) ~[gateway-error:na]
	at com.github.benmanes.caffeine.cache.LocalCacheFactory.loadFactory(LocalCacheFactory.java:84) ~[na:na]
	... 45 common frames omitted
```
