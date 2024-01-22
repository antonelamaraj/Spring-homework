package com.ikub.jdbc.springbootjdbc;

import com.ikub.jdbc.springbootjdbc.entity.Categories;
import com.ikub.jdbc.springbootjdbc.entity.Post;
import com.ikub.jdbc.springbootjdbc.entity.Users;
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

import java.time.LocalDate;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

	public static Logger logger = LoggerFactory.getLogger(SpringBootJdbcApplication.class);

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostCategoryService postCategoryService;
	@Autowired
	private PostService postService;
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJdbcApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		////get all users
		logger.info("{}", userService.getUsers());

		////user me id specifike
		logger.info("User me id {} is {}", 2, userService.getUserById((long) 2));

		////insert user
//		var u = Users.builder()
//				.username("Antonela")
//				.email("amaraj@gmail.com")
//				.password("123456")
//				.dateCreated(LocalDate.now())
//				.dateModified(LocalDate.now())
//				.build();
//		logger.info("Is new User inserted? {} ", userService.createUser(u));


		////update the User
//		var u = Users.builder()
//				.username("Antonela21")
//				.email("a1maraj@gmail.com")
//				.password("123456")
//				.dateCreated(LocalDate.now())
//				.dateModified(LocalDate.now())
//				.build();
//		logger.info("Is the User updated? {} ", userService.updateUser(1L, u));


//		//delete user
//		logger.info("Is user me id {} deleted?", userService.deleteUser((long) 6));

		/**********************Categories*******************************************/

		////get all Posts
		logger.info("{}", postService.getPosts());

		////post me id specifike
		logger.info("Post me id {} is {}", 2, postService.getPostsById(2L));

		////get te gjitha postimet e nje Useri me id specifike
		logger.info("{}", postService.getPostsByUserId(1L));

		//// create a new Post
//		var postCreated = Post.builder()
//				.title("Post 10")
//				.body("Post i 10")
//				.userId(2)
//				.dateCreated(null)
//				.dateModified(null)
//				.build();
//		logger.info("Is new Post inserted? {}", postService.createPost(postCreated));

		////update a post
//		var postUpdated = Post.builder()
//				.title("Post 101")
//				.body("Post i 101")
//				.userId(2)
//				.dateCreated(null)
//				.dateModified(null)
//				.build();
//		logger.info("Is the Post updated? {}",postService.updatePost(1l,postUpdated ) );


			/**********************CATEGORIES*******************************************/

			////Get ALL CATEGORIES
		logger.info("{}", categoryService.getCategories());

		///// GET CATEGORY BY ID
		logger.info("Category with id {} is {} ",1, categoryService.getCategoryById(1L));

		/////// CREAT NEW CATEGORY
		var categoryCreated = Categories.builder()
				.name("Category 111")
				.dateCreated(null)
				.dateModified(null)
				.build();
		// logger.info("Is the Category created? {}", categoryService.createCategory(categoryCreated));


		/**********************POST CATEGORIES*******************************************/

		/////GET POSTCATEGORY BY POST ID
		logger.info("PostCategories with post id {} is {}", 1, postCategoryService.getPostGategoryByPostId(1L));

		/////GET POSTCATEGORY BY POST ID AND CATGORY ID
		logger.info("PostCategories with post id {} AND category id {}  is {}", 1, postCategoryService.getPostGategoryByPostId(1L));


	}
}
