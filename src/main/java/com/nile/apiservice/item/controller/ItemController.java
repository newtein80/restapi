package com.nile.apiservice.item.controller;

import com.nile.apiservice.common.hateoas.LinkHrefUtil;
import com.nile.apiservice.common.page.CustomPagedResourceAssembler;
import com.nile.apiservice.common.page.PageableDTO;
import com.nile.apiservice.item.model.dto.ItemDto;
import com.nile.apiservice.item.service.ItemService;

import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * https://cla9.tistory.com/category/JAVA/JPA
 */
@RestController
@RequestMapping("/v1/nileapi/item")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final CustomPagedResourceAssembler<ItemDto> customPagedResourceAssembler;

    @GetMapping("/items")
    public ResponseEntity<PagedModel<EntityModel<ItemDto>>> getItems(
        PageableDTO pageableDTO
    ) {
        Page<ItemDto> items = this.itemService.getItems(pageableDTO);
        PagedModel<EntityModel<ItemDto>> pagedModel = LinkHrefUtil.getEntityModels(
            customPagedResourceAssembler,
            items,
            WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getItems(null)),
            // ItemDto::getItemId
            v -> v.getItemId()
        );
        return ResponseEntity.ok(pagedModel);
    }
}
