package com.nile.apiservice.common.doc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfiguration extends WebMvcConfigurationSupport {
    private String docVersion = "V1";
    private String docTitle = "UVM REST API Document " + docVersion;

    @Bean
    public Docket apiDck() { // Docket : Swagger 설정의 핵심이 되는 Bean

        List<ResponseMessage> responseMessages = new ArrayList<>();

        responseMessages.add(new ResponseMessageBuilder().code(200).message("OK !!").build());
        responseMessages.add(new ResponseMessageBuilder().code(404).message("Not Found !!").build());
        responseMessages.add(new ResponseMessageBuilder().code(500).message("Internal Server Error !!").build());


        return new Docket(DocumentationType.SWAGGER_2)
        .useDefaultResponseMessages(false) // false로 설정하면, swagger에서 제공해주는 응답코드 ( 200,401,403,404 )에 대한 기본 메시지를 제거합니다. 불필요한 응답코드와 메시지를 제거하기 위함이며, 컨트롤러에서 명시해줄 것입니다.
        .groupName(docVersion) // Docket Bean이 한 개일 경우 기본 값은 default이므로, 생략가능, 여러 Docket Bean을 생성했을 경우 groupName이 충돌하지 않아야 하므로, 여기서는 각 Docket Bean의 버전을 명시
        .select() // ApiSelectorBuilder를 생성
        .apis(RequestHandlerSelectors.basePackage("com.nile.apiservice")) // api 스펙이 작성되어 있는 패키지를 지정. 즉, 컨트롤러가 존재하는 패키지를 basepackage로 지정하여, RequestMapping( GetMapping, PostMapping ... )이 선언된 API를 문서화
        .paths(PathSelectors.ant("/v1/api/**")) // apis()로 선택되어진 API중 특정 path 조건에 맞는 API들을 다시 필터링하여 문서화
        .build()
        .apiInfo(apiInfo(docTitle, docVersion)) // 제목, 설명 등 문서에 대한 정보들을 보여주기 위해 호출
        .globalResponseMessage(RequestMethod.GET, responseMessages)
        ;
    }

    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }

    private ApiInfo apiInfo(String docTitle, String docVertsion) {
        return new ApiInfo(
            docTitle,
            "Swagger ApiInfo Description",
            docVertsion,
            "www.nilesoft.co.kr",
            new Contact("Manager", "www.nilesoft.co.kr", "apimanager@nilesoft.co.kr"),
            "license",
            "www.nilesoft-license.co.kr",
            Collections.emptyList()// new ArrayList<>()
        );
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}