package comm.controller;

import comm.entity.Item;
import comm.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService service;

    @PostMapping("api/items")
    public Item addItem(@RequestBody Item item)
    {
    	return service.addItem(item);
    }

    @GetMapping("/api/items/{code}")
    public Item getCustomerByAccount(@PathVariable String code) {
        return service.getByCode(code);
    }
    
    
    @PutMapping("/api/items/{code}/{price}")
    public String updateItemPrice(@PathVariable String code, @PathVariable double price) {
        return service.updatePrice(code, price);
    }
    
    @PostMapping("/api/bill")
    public String generateBill(@RequestBody Item requestItem) {
        return service.generateTotal(requestItem.getCode(), requestItem.getQuantity());
    }






}
