package com.nile.apiservice.item.model.dto;

import java.util.Date;

import com.nile.apiservice.item.model.entity.Item;
import com.nile.apiservice.item.model.enums.ItemType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder(access = AccessLevel.PRIVATE)
@Getter
@AllArgsConstructor
@NoArgsConstructor
// @JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@ApiModel(value = "아이템 상세 정보 DTO", description = "Item's Data Transfer Object")
public class ItemDto {

    @ApiModelProperty(position = 1, notes = "item dto's title")
    private String title;
    @ApiModelProperty(position = 2, notes = "item dto's content")
    private String content;
    @ApiModelProperty(position = 3, notes = "item dto's views")
    private Long views;
    @ApiModelProperty(position = 4, notes = "item dto's createDt")
    private Date createDt;
    @ApiModelProperty(position = 5, notes = "item dto's itemType")
    private ItemType itemType;
    @ApiModelProperty(position = 6, notes = "item dto's topItem")
    private Boolean topItem;

    public static ItemDto of(Item item) {
        return ItemDto.builder()
        .title(item.getTitle())
        .content(item.getContent())
        .views(item.getViews())
        .itemType(item.getItemType())
        .topItem(item.isTopItem())
        .build();
    }
}
