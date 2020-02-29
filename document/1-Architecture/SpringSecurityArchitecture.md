# Spring Security Architecture

Spring Security自定义Servlet Filter --- **FilterChainProxy**作为整个Spring Security的入口, 
通过DelegatingFilterProxy将以***springSecurityFilterChain***命名的FilterChainProxy注入, 
同Spring Boot进行集成.

![](./security-filters.png)

## Spring Security Filter

FilterChainProxy作为Spring Security入口, 
在其内部又维护了多个过滤链(SecurityFilterChain),
每个过滤链通过对请求进行规则匹配(RequestMatcher), 
然后按顺序执行多个配置的过滤器.

![](./security-filters-dispatch.png)

SecurityFilterChain中默认的11个过滤器有以下这些:

![](./chain-default-filters.png)

## SecurityContextPersistenceFilter

## 认证(Authentication)



## 鉴权(Authorization)

TODO

## Reference

- [Architecture Document](https://spring.io/guides/topicals/spring-security-architecture/)