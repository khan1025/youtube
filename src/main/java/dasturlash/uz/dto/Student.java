package dasturlash.uz.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Data
public class Student {
    private String id;
    private String name;
    private String surname;
    private String level;
    private Integer age;
    private String gender;
    private LocalDateTime createdDate;

}
