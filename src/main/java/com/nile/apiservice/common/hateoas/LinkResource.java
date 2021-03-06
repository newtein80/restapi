package com.nile.apiservice.common.hateoas;

import java.util.function.Function;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

public class LinkResource<T> extends EntityModel<T> {
    public static <T> EntityModel<T> of(WebMvcLinkBuilder builder, T model, Function<T,?> resourceFunc){
        return EntityModel.of(model, getSelfLink(builder, model, resourceFunc));
    }

    private static<T> Link getSelfLink(WebMvcLinkBuilder builder, T data, Function<T, ?> resourceFunc){
        WebMvcLinkBuilder slash = builder.slash(resourceFunc.apply(data));
        return slash.withSelfRel();
    }
}
