package com.nile.apiservice.item.controller;

import com.nile.apiservice.item.model.dto.ItemDto;
import com.nile.apiservice.item.service.ItemService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/nileapi/items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    private final PagedResourcesAssembler<ItemDto> pagedResourcesAssembler;

    @GetMapping("/items")
    public ResponseEntity<PagedModel<EntityModel<ItemDto>>> getItems(
        Pageable pageable,
        @RequestParam(required = false, name = "total_items") Integer totalItems
    ) {
        Page<ItemDto> items = this.itemService.getItems(pageable, totalItems);
        PagedModel<EntityModel<ItemDto>> pagedModel = pagedResourcesAssembler.toModel(items);
        return ResponseEntity.ok(pagedModel);
    }
}
