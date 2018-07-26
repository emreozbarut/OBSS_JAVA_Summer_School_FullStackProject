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

import tr.com.obss.model.Favorite;
import tr.com.obss.service.FavoriteService;

@Controller
@ResponseBody
@RequestMapping("/favorites")
public class FavoriteController {
	@Autowired
	private FavoriteService favoriteService;

	@GetMapping("/{userID}")
	public Favorite getFavorite(@PathVariable int userID) {
		return favoriteService.get(userID);
	}

	@PostMapping
	public Favorite saveFavorite(@RequestBody Favorite favorite) {
		return favoriteService.post(favorite);
	}

	@PutMapping("/{userID}")
	public Favorite updateFavorite(@PathVariable int userID,@RequestBody Favorite favorite) {
		return favoriteService.put(userID, favorite);
	}

	@DeleteMapping("/{bookID}")
	public void deleteFavorite(@PathVariable int bookID) {
		favoriteService.delete(bookID);
	}
}
