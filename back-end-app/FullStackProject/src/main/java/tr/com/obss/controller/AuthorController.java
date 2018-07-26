package tr.com.obss.controller;

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
import tr.com.obss.service.AuthorService;

@Controller
@ResponseBody
@RequestMapping("/authors")
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@GetMapping("/{authorID}")
	public Author getAuthor(@PathVariable int authorID) {
		return authorService.get(authorID);
	}

	@PostMapping
	public Author saveAuthor(@RequestBody Author author) {
		return authorService.post(author);
	}

	@PutMapping("/{authorID}")
	public Author updateAuthor(@PathVariable int authorID,@RequestBody Author author) {
		return authorService.put(authorID, author);
	}

	@DeleteMapping("/{authorID}")
	public void deleteAuthor(@PathVariable int authorID) {
		authorService.delete(authorID);
	}
}
