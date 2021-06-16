package com.nile.apiservice.item.repository;

import com.nile.apiservice.common.BaseRepository;
import com.nile.apiservice.item.model.entity.Item;

// public interface ItemRepository extends JpaRepository<Item, Long>{
public interface ItemRepository extends BaseRepository<Item, Long>{
    Item findByTitle(String title);
}
