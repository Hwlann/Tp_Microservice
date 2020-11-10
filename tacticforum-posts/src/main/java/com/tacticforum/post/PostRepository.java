package com.tacticforum.post;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface PostRepository extends CrudRepository<Post, Integer> {
	@Query("SELECT DISTINCT post FROM Post post WHERE post.title LIKE :title%")
	@Transactional(readOnly = true)
	Collection<Post> findByLastName(@Param("title") String title);
}
