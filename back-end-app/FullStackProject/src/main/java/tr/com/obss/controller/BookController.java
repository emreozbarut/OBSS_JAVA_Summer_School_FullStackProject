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

import tr.com.obss.model.Book;
import tr.com.obss.service.BookService;
@Controller
@ResponseBody
@RequestMapping("/bookinfos")
public class BookController {
	
		@Autowired
		private BookService bookService;

		@GetMapping("/{bookID}")
		public Book getBook(@PathVariable int bookID) {
			return bookService.get(bookID);
		}

		@PostMapping
		public Book saveBook(@RequestBody Book book) {
			return bookService.post(book);
		}

		@PutMapping("/{bookID}")
		public Book updateBook(@PathVariable int bookID,@RequestBody Book book) {
			return bookService.put(bookID, book);
		}

		@DeleteMapping("/{bookID}")
		public void deleteBook(@PathVariable int bookID) {
			bookService.delete(bookID);
		}
	}
