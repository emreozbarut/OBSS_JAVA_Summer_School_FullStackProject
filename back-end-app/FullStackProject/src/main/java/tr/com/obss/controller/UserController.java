package tr.com.obss.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import tr.com.obss.model.Author;
import tr.com.obss.model.BookInfo;
import tr.com.obss.model.User;
import tr.com.obss.service.UserService;

@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping
	public List<Object> getUsers() {
		List<Object> list = new ArrayList<>();
		User user = new User();
		user.setUsername("OBSS1");
		list.add(user);

		user = new User();
		user.setUsername("OBSS2");
		list.add(user);

		user = new User();
		user.setUsername("OBSS3");
		list.add(user);

		Author author = new Author();
		author.setName("Yasin");
		list.add(author);

		BookInfo bookInfo = new BookInfo();
		bookInfo.setTitle("Comic");
		list.add(bookInfo);

		return list;
	}

	@GetMapping("/{userID}")
	public User getUser(@PathVariable int userID) {
		return userService.get(userID);
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.post(user);
	}

	@PutMapping("/{userID}")
	public User updateUser(@PathVariable int userID, @RequestBody User user) {
		return userService.put(userID,user);
	}

	@DeleteMapping("/{userID}")
	public void deleteUser(@PathVariable int userID) {
		userService.delete(userID);
	}
}
