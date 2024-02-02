package com.ikub.jdbc.springbootjdbc;

import com.ikub.jdbc.springbootjdbc.entity.Category;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.User;
import com.ikub.jdbc.springbootjdbc.service.CategoryService;
import com.ikub.jdbc.springbootjdbc.service.PostCategoryService;
import com.ikub.jdbc.springbootjdbc.service.PostService;
import com.ikub.jdbc.springbootjdbc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataIntegrityViolationException;

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {
	public SpringBootJdbcApplication(UserService userService, PostService postService, PostCategoryService postCategoryService, CategoryService categoryService) {
		this.userService = userService;
		this.postService = postService;
		this.postCategoryService = postCategoryService;
		this.categoryService = categoryService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}
	public static Logger logger = LoggerFactory.getLogger(SpringBootJdbcApplication.class);

	private final UserService userService;
	private final PostService postService;
	private final PostCategoryService postCategoryService;
	private final CategoryService categoryService;


	@Override
	public void run(String... args) {
		logger.info("User {} is  {}", 1, userService.getUserById(1L));
		logger.info("The users {}", userService.getUsers());

//		var user = new User();
//		user.setUsername("Linda");
//		user.setEmail("linda@gmail.com");
//		user.setPassword("lindaaa");
//		user.setDateCreated(LocalDate.now());
//		user.setDateModified(LocalDate.now());

		//logger.info("New user created: {}",userService.createUser(user));
		try {
			logger.info("Deleted user: {}", userService.deleteUser(4L));
		} catch (DataIntegrityViolationException e) {
			System.out.println("First, delete all the posts");
		}
		logger.info("User with id {} is updated: {}", 2, userService.updateUser(2L, userService.getUserById(2L)));
      /*  var p2 = User.builder()
                .username("Player 444")
                .email("Albania")
                .password("100kdre")
                .dateCreated(LocalDate.now())
                .dateModified(LocalDate.now())
                .build();
        logger.info("Inseted player id is {}",userService.createUser(p2));*/
		User user3=userService.getUserById(3L);

//		var post = postService.getPostsById(1L);
//		post.setTitle("vacations");
//		post.setBody("Vacations in Spain");
//		post.setDateModified(LocalDate.now());
//		post.setUser(user3);
//
//		logger.info("Post with id {} is modified {}", 1, postService.updatePost(1L, post));


		logger.info("All the posts {}", postService.getPosts());
		logger.info("Posts for user id: {} are: {} ", 3, postService.getPostsByUserId(3L));

//		var newPost = Post.builder()
//				.title("Holidays")
//				.body("wow")
//				.dateCreated(LocalDate.now())
//				.dateModified(LocalDate.now())
//				.user(user3)
//				.build();
//		logger.info("Create new post: {} ", postService.createPost(newPost));


		logger.info("This is your post category for post id {} and category id {} : {}", 2, 2,
				postCategoryService.getPostCategoryByPostIdAndCategoryId(2L, 2L));

		logger.info("This is your post category for post id {}: {} ", 4, postCategoryService.getPostGategoryByPostId(4L));


		logger.info("These are the categories: {} ", categoryService.getCategories());
		logger.info("This is the category with id: {} {} ", 5, categoryService.getCategoryById(5L));

//		var category = Category.builder()
//				.name("DaysOff")
//				.dateCreated(LocalDate.now())
//				.dateModified(LocalDate.now()).build();
//		logger.info("New category created: {} ", categoryService.createCategory(category));

	}
}
