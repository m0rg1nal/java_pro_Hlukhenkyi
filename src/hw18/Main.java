package hw18;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(0,"Ivan", "qwerty@gmail.com"));
        users.add(new User(1,"Dmytro", "zxcv@gmail.com"));
        users.add(new User(2,"Maria", "asdf@gmail.com"));
        users.add(new User(3,"Anton", "1234@gmail.com"));

        UserRepository userRepository = new UserRepository(users);
        userRepository.getById(1);
        userRepository.getByEmail("qwerty@gmail.com");
        userRepository.getById(5);
        userRepository.getByEmail("sdfsfg");
        userRepository.getAllUsers();
    }
}
