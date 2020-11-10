package user;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

class UserController {

	private static final String VIEWS_USER_CREATE_OR_UPDATE_FORM = "users/createOrUpdateUserForm";

	private final UserRepository users;

	public UserController(UserRepository userService) {
		this.users = userService;
	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setDisallowedFields("id");
	}

	@HysterixCommand
	@GetMapping("/users/new")
	public String initCreationForm(Map<String, Object> model) {
		User owner = new User();
		model.put("user", users);
		return VIEWS_USER_CREATE_OR_UPDATE_FORM;
	}
	
	@HysterixCommand
	@PostMapping("/users/new")
	public String processCreationForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_USER_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.users.save(user);
			return "redirect:/users/" + user.getId();
		}
	}
	
	@HysterixCommand
	@GetMapping("/users/{userID}")
	public ModelAndView showOwner(@PathVariable("userID") int userID) {
		ModelAndView mav = new ModelAndView("users/userDetails");
		User owner = this.users.findById(userID);
		mav.addObject(owner);
		return mav;
	}

}
