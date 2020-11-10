package com.tacticforum.comments;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CommentController {

	private final CommentRepository comments;

	public CommentController(CommentRepository tacticforumService) {
		this.comments = tacticforumService;
	}

	@GetMapping("/comments")
	public Iterable<Comment> getComments() {
		return comments.findAll();
	}

	@PostMapping("/comments")
	public Comment addTopics(@RequestParam("author") String author, @RequestParam("date") String date,
			@RequestParam("time") String time) {
		Comment comment = new Comment();
		comment.setAuthor(author);
		comment.setDate(date);
		comment.setTime(time);
		return comments.save(comment);
	}

	@DeleteMapping("/comments/{id}")
	public void deleteComment(@PathVariable("id") Integer id) {
		comments.deleteById(id);
	}

	@GetMapping("/comments/findById/{id}")
	public Optional<Comment> findById(@PathVariable("id") Integer id) {
		return comments.findById(id);
	}

}
