package codingchallenge.grocerylist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codingchallenge.grocerylist.model.ItemInfo;
import codingchallenge.grocerylist.repo.ItemInfoRepo;


@Service
public class ItemService {
	
	@Autowired
	private ItemInfoRepo ir;
	
	public Iterable<ItemInfo> getAll(){
		return ir.findAll();
	}
	
	public ItemInfo save(ItemInfo item){
		return ir.save(item);
	}

	public void delete(ItemInfo item) {
		ir.delete(item);
	}
}
