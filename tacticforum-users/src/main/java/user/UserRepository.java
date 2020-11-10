package user;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "http://localhost:8085")
public interface UserRepository {s

	@GetMapping("/users/findByPseudo/{pseudo}")
	Collection<User> findByPseudo(@PathVariable("pseudo") String pseudo);

	@GetMapping("/users/{id}")
	public User findById(@PathVariable("id") Integer id);

	@PostMapping("/users/")
	void save(@RequestBody User owner);

}
