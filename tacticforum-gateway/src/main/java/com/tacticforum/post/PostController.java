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


@Controller
@RequestMapping("/posts/{userId}")
public class PostController extends Post{

	private static final String VIEWS_POSTS_CREATE_OR_UPDATE_FORM = "posts/createOrUpdatePetForm";

}
