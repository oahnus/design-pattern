# Spring中的适配器模式

Advisor相关类用的就是适配器模式

> `AdvisorAdapter`
>
> `HandlerAdapter`



```java
public interface AdvisorAdapter {
	boolean supportsAdvice(Advice advice);
	MethodInterceptor getInterceptor(Advisor advisor);
}
```



```java
public interface HandlerAdapter {
	boolean supports(Object handler);

	Mono<HandlerResult> handle(ServerWebExchange exchange, Object handler);
}
```

