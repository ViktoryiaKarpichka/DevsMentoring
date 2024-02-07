package task_one;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class User {
    private String name;
    private int age;
    private String surname;
    private String mail;
    @ToString.Exclude
    private String password;
    private Long id;
}
