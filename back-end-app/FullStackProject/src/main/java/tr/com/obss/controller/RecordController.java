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

import tr.com.obss.model.Record;
import tr.com.obss.service.RecordService;

@Controller
@ResponseBody
@RequestMapping("/records")
public class RecordController {
	@Autowired
	private RecordService recordService;

	@GetMapping("/{userID}")
	public Record getRecord(@PathVariable int userID) {
		return recordService.get(userID);
	}

	@PostMapping
	public Record saveRecord(@RequestBody Record record) {
		return recordService.post(record);
	}

	@PutMapping("/{userID}")
	public Record updateRecord(@PathVariable int userID,@RequestBody Record record) {
		return recordService.put(userID, record);
	}

	@DeleteMapping("/{userID}")
	public void deleteRecord(@PathVariable int userID) {
		recordService.delete(userID);
	}
}
