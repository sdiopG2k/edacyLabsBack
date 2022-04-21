package com.edacy.edacylabs.Controller;

import com.edacy.edacylabs.Service.ItemService;
import com.edacy.edacylabs.commons.Response;
import com.edacy.edacylabs.dtos.ItemDto;
import com.edacy.edacylabs.entities.Item;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "item")
@Slf4j
@CrossOrigin(origins = "*")
public class ItemController {
    private final ItemService itemService;

    @GetMapping(value = "getAllItems")
    public Response<?> getAllItems() {
        List<Item> items = itemService.getAllItems();
        return Response.ok().setPayload(items).setMetadata("List of items");
    }

    @GetMapping(value = "getById/{id}")
    public Response<?> getItemById(@PathVariable("id") Long id) {
        return Response.ok().setPayload(itemService.getItemById(id));
    }

    @PutMapping(value = "updateItem")
    public Response<?> updateItem(@RequestBody ItemDto itemDto) {
        return Response.ok().setPayload(itemService.updateItem(itemDto));
    }
    /*

    @GetMapping(value = "getAllItems")
    public Response<?> getAllItems(@RequestParam(value = "page",defaultValue = "0") int page,
                                   @RequestParam(value = "size",defaultValue = "10") int size) {
        Page<Item> items = itemService.getAllItems(page, size);
        int newSize = items.getSize();
        Long totalElements = items.getTotalElements();
        int totalPages = items.getTotalPages();
        int number = items.getNumber();
        return Response.ok().setPayload(items.getContent()).setMetadata(new Response.PageMetadata(newSize, totalElements, totalPages, number));
    }

    */

}
