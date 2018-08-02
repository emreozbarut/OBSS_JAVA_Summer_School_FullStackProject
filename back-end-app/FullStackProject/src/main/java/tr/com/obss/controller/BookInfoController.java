package tr.com.obss.controller;

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

import tr.com.obss.model.BookInfo;
import tr.com.obss.service.BookInfoService;

@Controller
@ResponseBody
@RequestMapping("/books")
public class BookInfoController {
	@Autowired
	private BookInfoService bookService;
	
	@GetMapping
	public List<BookInfo> getAllBooks(){
		System.out.println("getAll Controller");
		return bookService.getAll();
	}
	@GetMapping("/{title}")
	public List<BookInfo> getBookInfo(@PathVariable String title){
		System.out.println("getBookInfo");
		return bookService.getBookByTitle(title);
	}
//	@GetMapping("/{bookID}")
//	public BookInfo getBook(@PathVariable int bookID) {
//		System.out.println("getBook Controller");
//		return bookService.get(bookID);
//	}

	@PostMapping
	public BookInfo saveBook(@RequestBody BookInfo book) {
		System.out.println("saveBook Controller");
		return bookService.post(book);
	}

	@PutMapping("/{bookID}")
	public BookInfo updateBook(@PathVariable int bookID, @RequestBody BookInfo book) {
		System.out.println("updateBook Controller");
		return bookService.put(bookID, book);
	}

	@DeleteMapping("/{title}")
	public void deleteBook(@PathVariable String title) {
		System.out.println("deleteBook Controller");
		bookService.delete(title);
	}
}
