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

import tr.com.obss.model.Role;
import tr.com.obss.service.RoleService;

@Controller
@ResponseBody
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@GetMapping("/{userID}")
	public Role getRole(@PathVariable int userID) {
		return roleService.get(userID);
	}

	@PostMapping
	public Role saveRole(@RequestBody Role role) {
		return roleService.post(role);
	}

	@PutMapping("/{userID}")
	public Role updateRole(@PathVariable int userID,@RequestBody Role role) {
		return roleService.put(userID, role);
	}

	@DeleteMapping("/{userID}")
	public void deleteRole(@PathVariable int userID) {
		roleService.delete(userID);
	}
}
