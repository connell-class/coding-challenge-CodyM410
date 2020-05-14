package codingchallenge.grocerylist.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codingchallenge.grocerylist.model.ItemInfo;
import codingchallenge.grocerylist.model.ItemList;
import codingchallenge.grocerylist.service.ItemService;
import codingchallenge.grocerylist.service.ListService;



@RestController
@CrossOrigin(origins="*")
@RequestMapping(value="/groceryservice")
public class TheController {
	private ListService ls;
	private ItemService is;

	@GetMapping(value = "/grocery-lists")
	public Iterable<ItemList> getLists() {
		return ls.findAll();
	}

	@PostMapping(value = "/grocery-lists")
	public boolean newList(@RequestBody ItemList list) {
		try {
			ls.save(list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@PostMapping(value = "/grocery-lists/items")
	public boolean newItem(@RequestBody ItemInfo item) {
		try {
			is.save(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@DeleteMapping(value = "/grocery-lists/items/{itemId}")
	public boolean removeItem(@RequestBody ItemInfo item) {
		try {
			is.delete(item);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@DeleteMapping(value = "/grocery-lists")
	public boolean removeList(@RequestBody ItemList list) {
		try {
			ls.delete(list);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
