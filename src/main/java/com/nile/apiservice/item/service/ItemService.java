package com.nile.apiservice.item.service;

import com.nile.apiservice.common.page.DomainSpec;
import com.nile.apiservice.common.page.PageableDTO;
import com.nile.apiservice.item.model.dto.ItemDto;
import com.nile.apiservice.item.model.entity.Item;
import com.nile.apiservice.item.model.enums.ItemMetaType;
import com.nile.apiservice.item.model.strategy.ItemSortStrategy;
import com.nile.apiservice.item.repository.ItemRepository;
// import com.nile.apiservice.item.response.GetItemResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
// @RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private DomainSpec<ItemMetaType, Item> spec;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
        this.spec = new DomainSpec<>(ItemMetaType.class, new ItemSortStrategy());
    }

    public Page<ItemDto> getItems(PageableDTO pageableDTO) {
        final var pageable = this.spec.getPageable(pageableDTO);
        final var items = this.itemRepository.findAll(pageable, pageableDTO.getTotalItems());
        return items.map(ItemDto::of);
    }
}
