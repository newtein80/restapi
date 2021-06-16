package com.nile.apiservice.item.model.entity;

import static org.assertj.core.api.Assertions.assertThat;

import com.nile.apiservice.item.model.enums.ItemType;

import org.junit.Test;

public class ItemTest {
    @Test
    public void testBuilder() {
        Item item = Item.builder().title("title").content("content").topItem(true).itemType(ItemType.BOARD).build();
        assertThat(item).isNotNull();
    }
}
