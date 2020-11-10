package com.tacticforum.post;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/posts/{userId}")
public class PostController extends Post{

	private final PostRepository posts;

	public PostController(PostRepository posts) {
		this.posts = posts;
	}

	@GetMapping("/posts")
	public Iterable<Post> getPosts() {
		return posts.findAll();
	}

	@GetMapping("/posts/{id}")
	public Optional<Post> getPostById(@PathVariable("id") Integer id) {
		return posts.findById(id);
	}

	@PostMapping("/posts")
	public Post addPost(@RequestParam("title") String title, @RequestParam("userId") Integer userId,
			@RequestParam("content") String content, @RequestParam("createDate") LocalDate createDate) {
		Post post = new Post();
		post.setTitle(title);
		post.setUser(userId);
		post.setContent(content);
		post.setCreateDate(createDate);
		return posts.save(post);
	}

	@PutMapping("/posts/{id}")
	public Post editPost(@PathVariable("id") Integer id, @RequestParam("title") String title,
			@RequestParam("userId") Integer userId, @RequestParam("content") String content,
			@RequestParam("createDate") LocalDate createDate) {

		Optional<Post> postOpt = posts.findById(id);
		if (postOpt.isPresent()) {
			Post post = postOpt.get();
			post.setTitle(title);
			post.setUser(userId);
			post.setContent(content);
			post.setCreateDate(createDate);
			posts.save(post);
		}
		return postOpt.get();
	}

	@DeleteMapping("/posts/{id}")
	public void deletePet(@PathVariable("id") Integer id) {
		posts.deleteById(id);
	}

	@PostMapping("/posts/{postId}/addComment")
	public void addVisitToPet(@PathVariable("postId") Integer postId, @RequestParam("commentId") Integer commentId) {
		Optional<Post> postOpt = posts.findById(postId);
		if (postOpt.isPresent()) {
			Post post = postOpt.get();
			post.addComment(commentId);
			posts.save(post);
		}

	}
}
