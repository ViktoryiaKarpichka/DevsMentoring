package task_one;

public class Main {
    public static void main(String[] args) {
        User user1 = User.builder()
                .name("User1")
                .age(17)
                .surname("Ivanov")
                .id(1L)
                .mail("aasd@gmail.com")
                .password("asdfgdfhgdfhdf")
                .build();

        User user2 = User.builder()
                .name("User2")
                .age(20)
                .surname("Petrov")
                .id(2L)
                .mail("aasd@gmail.com")
                .password("asdfghghf")
                .build();

        User user3 = User.builder()
                .name("User3")
                .age(20)
                .surname("Sidorov")
                .id(3L)
                .mail("aasd@gmail.com")
                .password("asdfgfdhf")
                .build();

        DataBase dataBase = new DataBase();
        dataBase.save(user1);
        dataBase.save(user2);
        dataBase.save(user3);

        System.out.println(dataBase.getUserById(1L).toString());
        dataBase.update(70,1L);
        System.out.println(dataBase);

    }

}
