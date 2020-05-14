package codingchallenge.grocerylist.service;

import org.springframework.beans.factory.annotation.Autowired;

import codingchallenge.grocerylist.model.ItemList;
import codingchallenge.grocerylist.repo.ListRepo;



public class ListService {

	@Autowired
	private ListRepo lr;

	public Iterable<ItemList> findAll() {
		return lr.findAll();
	}
	
	public void save(ItemList list) {
		lr.save(list);
	}

	public void delete(ItemList list) {
		lr.delete(list);
	}
	
	
}