package com.tacticforum.comments;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query("SELECT * FROM Comment comment WHERE comment.id = id")
	@Transactional(readOnly = true)
	Optional<Comment> findById(@Param("id") Integer id);

}