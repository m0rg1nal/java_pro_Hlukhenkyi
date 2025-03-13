package hw18;

import java.util.List;
import java.util.Optional;

public class UserRepository {
    private List<User> users;

    public UserRepository(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    Optional<User> findUserById(int id){
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }
    Optional<User> findUserByEmail(String email){
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst();
    }
    Optional<List<User>> findAllUsers(){
        return Optional.ofNullable(users);
    }
    public void getById(int id){
        findUserById(id).ifPresentOrElse(
                user -> System.out.println(user.getName()),
                () -> System.out.println("No such user with id: " + id)

        );
    }
    public void getByEmail(String email){
        findUserByEmail(email).ifPresentOrElse(
                user -> System.out.println(user.getName()),
                () -> System.out.println("No such user with email: " + email)
        );
    }
    public void getAllUsers(){
        findAllUsers().ifPresentOrElse(
                System.out::println,
                () -> System.out.println("The list is null")
        );
    }
}
