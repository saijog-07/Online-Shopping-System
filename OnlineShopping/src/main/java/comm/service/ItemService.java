package comm.service;

import comm.JPArepo.ItemRepo;
import comm.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepo repo;


    public Item getByCode(String code) {
        return repo.findByCode(code);
    }
    
    public Item addItem(Item item) {
    	return repo.save(item);
    }
    
    public String updatePrice(String code, double price) {
        int updated = repo.updateItemPrice(code, price);
        if (updated > 0) {
            return "Price updated successfully for item code: " + code;
        } else {
            return "Item not found or update failed.";
        }
    }
    
    public String generateTotal(String code, int quantity) {
        Item item = repo.findById(code).orElse(null);
        if (item != null && item.getQuantity() >= quantity) {
        	
        	int or_qty = item.getQuantity();
        	item.setQuantity(or_qty - quantity);
        	repo.save(item);
            return "Your total is : " + item.getPrice() * quantity;
        }
        else {
        	return "Item is not present / Quantity is not sufficient";
        }
        
    }






}
