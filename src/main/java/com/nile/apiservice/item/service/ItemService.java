package com.nile.apiservice.item.service;

import com.nile.apiservice.item.model.dto.ItemDto;
import com.nile.apiservice.item.model.entity.Item;
import com.nile.apiservice.item.repository.ItemRepository;
// import com.nile.apiservice.item.response.GetItemResponse;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public Page<ItemDto> getItems(Pageable pageable, Integer totalItems) {
        Page<Item> items = this.itemRepository.findAll(pageable, totalItems);
        return items.map(ItemDto::of);
    }
}
