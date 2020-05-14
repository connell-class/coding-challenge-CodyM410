package codingchallenge.grocerylist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import codingchallenge.grocerylist.model.ItemInfo;



@Repository
public interface ItemInfoRepo extends CrudRepository<ItemInfo, Integer>{

	Iterable<ItemInfo> findAll();

}
