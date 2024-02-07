package task_one;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@ToString
public class DataBase {
    private List<User> users;

    public DataBase() {
        this.users = new ArrayList<>();
    }

    public User getUserById(Long id) {
        for (User user : users) {
            if (Objects.equals(user.getId(), id)) {
                return user;
            }
        }
        throw new UserNotFoundException("User not found with id " + id);
    }

    public void save(User user) {
        boolean isValidPasswordLength = user.getPassword().length() > 8 && user.getPassword().length() < 30;
        boolean isValidAge = user.getAge() >= 18;
        if (!isValidPasswordLength) {
            throw new ValidationException("The password not valid");
        } else if (!isValidAge) {
            throw new AgeValidationException("Age not valid");
        } else {
            users.add(user);
        }
    }
    public void update(int age, Long id) {
        for (User us : users) {
            if (us.getId().equals(id)) {
                us.setAge(age);
            }
        }
    }

    public boolean delete(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
