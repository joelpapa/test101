package com.example.test101.repository;

import com.example.test101.constant.ItemSellStatus;
import com.example.test101.entity.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath::application-test.properties")

class ItemRepositoryTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("test")
    public void createItemTest(){
        Item item = new Item();
        item.setItemNm("test 상품");
        item.setPrice(12000);
        item.setItemSellStatus(ItemSellStatus.SELL);
        item.setStockNumber(34);
        item.setItemDetail("이상한 나라에서 온 정상적인 제품");
        item.setRegTime(LocalDateTime.now());
        item.setUpdateTime(LocalDateTime.now());
        Item savedItem= itemRepository.save(item);
        System.out.println(savedItem.toString());

    }
}