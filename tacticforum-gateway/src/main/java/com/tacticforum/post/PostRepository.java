package com.tacticforum.post;

import java.util.Collection;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@FeignClient(name = "post-service")
public interface PostRepository {
	@GetMapping("/posts/findId/{id}")
	Collection<Post> findTitle(@PathVariable("title") String title);

	@GetMapping("/posts/{id}")
	public Post findById(@PathVariable("id") Integer id);

	@PostMapping("/posts/")
	void save(@RequestBody Post owner);
}
