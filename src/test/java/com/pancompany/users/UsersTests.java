package com.pancompany.users;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.util.Collection;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTests {
	@Autowired
	private UserRepository userRepository;

	@Before
	public void setup() {
		User user = new User();
		user.setName("Marco van Boommel");
		user.setAge(40);
		user.setSalary(4500.50);
		userRepository.save(user);
	}

	@Test
	public void testFindAllUsers() {
		List<User> users = userRepository.findAll();
		assertThat(users.size(), is(1));
		assertThat(users.get(0).getAge(), is(40));
	}
}
