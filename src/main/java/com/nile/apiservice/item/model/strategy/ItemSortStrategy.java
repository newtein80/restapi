package com.nile.apiservice.item.model.strategy;

import com.nile.apiservice.common.page.SortOption;
import com.nile.apiservice.common.page.SortStrategy;
import com.nile.apiservice.item.model.enums.ItemMetaType;

import org.springframework.data.domain.Sort;

public class ItemSortStrategy implements SortStrategy<ItemMetaType> {
    @Override
    public Sort.Order getSortOrder(ItemMetaType domainKey, SortOption order) {
        Sort.Order sortOrder = null;
        switch (domainKey){
            case ITEM_ID:
            case TITLE:
                final var column = domainKey.getName();
                sortOrder = (order == SortOption.ASC) ? Sort.Order.asc(column) : Sort.Order.desc(column);
        }
        return sortOrder;
    }
}