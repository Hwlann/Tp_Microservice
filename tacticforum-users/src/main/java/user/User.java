package user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import org.springframework.core.style.ToStringCreator;

import com.tacticforum.base.Person;
import com.tacticforum.*;

public class User extends Person {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5576496367924486237L;


	private Set<Post> posts;
	
	private Set<Comment> topics;

	protected Set<Post> getPostsInternal() {
		if (this.posts == null) {
			this.posts = new HashSet<>();
		}
		return this.posts;
	}

	protected void setPetsInternal(Set<Pet> pets) {
		this.pets = pets;
	}

	public List<Post> getPosts() {
		List<Post> sortedPets = new ArrayList<>(getPostsInternal());
		PropertyComparator.sort(sortedPets, new MutableSortDefinition("name", true, true));
		return Collections.unmodifiableList(sortedPets);
	}

	public void addPost(Post post) {
		if (post.isNew()) {
			getPostsInternal().add(post);
		}
		pet.setOwner(this);
	}

	/**
	 * Return the Pet with the given name, or null if none found for this Owner.
	 * @param name to test
	 * @return true if pet name is already in use
	 */
	public Post getPost(String name) {
		return getPost(name, false);
	}

	/**
	 * Return the Pet with the given name, or null if none found for this Owner.
	 * @param name to test
	 * @return true if pet name is already in use
	 */
	public Post getPost(String name, boolean ignoreNew) {
		name = name.toLowerCase();
		for (Pet pet : getPostsInternal()) {
			if (!ignoreNew || !pet.isNew()) {
				String compName = pet.getName();
				compName = compName.toLowerCase();
				if (compName.equals(name)) {
					return pet;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return new ToStringCreator(this)

				.append("id", this.getId()).append("new", this.isNew()).append("pseudo", this.getPseudo())
				.append("email", this.getEmail()).append("password", this.password).toString();
	}

}
