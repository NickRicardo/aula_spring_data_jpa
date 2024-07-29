package dio_aula;

import dio_aula.model.User;
import dio_aula.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = repository.findByNameContaining("Keilla");

        for (User u : users) {
            System.out.println(u);
        }

        User user = new User();
        user.setName("Nícolas");
        user.setUsername("nicollas");
        user.setPassword("dio123");

        User user1 = new User();
        user1.setName("Keilla");
        user1.setUsername("keilla");
        user1.setPassword("dio321");

        User user2 = new User();
        user2.setName("Laura");
        user2.setUsername("laura");
        user2.setPassword("123456");

        repository.save(user);
        repository.save(user1);
        repository.save(user2);

        for (User u : repository.findAll()) {
            System.out.println(u);
        }
    }
}
