package club.maddm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 */
@Configuration
@EnableSwagger2//开启swagger
public class SwaggerConfiguration {
 
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("club.maddm.common.controller"))//这里配置swagger扫描的规则，可以是包/类注解/方法注解
                .paths(PathSelectors.any())//筛选路径，可是any/正则表达式/antPattern
                .build();
    }
 
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("通用后台管理系统 api")
                .description("by king...")
                .termsOfServiceUrl("")
                .contact(new Contact("king","","kingbb0630@icloud.com"))
                .version("1.0")
                .build();
    }

}