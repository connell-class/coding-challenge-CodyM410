package codingchallenge.grocerylist.repo;

import org.springframework.data.repository.CrudRepository;

import codingchallenge.grocerylist.model.ItemList;

public interface ListRepo extends CrudRepository<ItemList, Integer>{
	
}