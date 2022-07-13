package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", // 스캔 장소 지정 // default -> ComponentScan 이 있는 package 부터 시작
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // @Configuration에는 component가 붙어있어 자동으로 스캔되므로 AppConfig.java 제외시킨것
)
public class AutoAppConfig {
}
