package com.edacy.edacylabs.ServiceImpl;

import com.edacy.edacylabs.Repository.ItemRepository;
import com.edacy.edacylabs.Service.ItemService;
import com.edacy.edacylabs.dtos.ItemDto;
import com.edacy.edacylabs.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item saveItem(Item item) {
        Item optionalItem = itemRepository.save(item);
        if (optionalItem!=null){
            return optionalItem;
        }
        return null;
    }

    @Override
    public List<Item> saveAllItem(List<Item> items) {
        return itemRepository.saveAll(items);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    @Override
    public Page<Item> getAllItemsPage(int page, int size) {
        Pageable requestedPage = PageRequest.of(page, size);
        return itemRepository.findAll(requestedPage);
    }

    @Override
    public Item getItemById(Long id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()){
            return item.get();
        }else {
            return  null;
        }
    }

    @Override
    public Item updateItem(ItemDto itemDto) {
        Optional<Item> item = itemRepository.findById(itemDto.getIdItem());
        if (item.isPresent()){
            item.get().setDescription(itemDto.getDescription());
            item.get().setTitle(itemDto.getTitle());
            return  itemRepository.save(item.get());
        }
        return null;
    }

}
