package com.edacy.edacylabs.Service;

import com.edacy.edacylabs.dtos.ItemDto;
import com.edacy.edacylabs.entities.Item;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {
    Item saveItem(Item item);

    List<Item> saveAllItem(List<Item> items);

    Page<Item> getAllItemsPage(int page, int size);

    Item getItemById(Long id);

    Item updateItem(ItemDto itemDto);

     List<Item> getAllItems() ;

}
