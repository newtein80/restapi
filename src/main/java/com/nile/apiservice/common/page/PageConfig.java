package com.nile.apiservice.common.page;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class PageConfig implements WebMvcConfigurer{
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new PageableArgumentResolver());
    }

    @Bean(name="customPagedResourceAssembler")
    @Primary
    public CustomPagedResourceAssembler<?> customPagedResourceAssembler(){
        return new CustomPagedResourceAssembler<>(new HateoasPageableHandlerMethodArgumentResolver(),10);
    }
}
