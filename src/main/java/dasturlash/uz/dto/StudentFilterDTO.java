package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Repository
@Setter
@Getter
public class StudentFilterDTO {
    private String name;
    private String surname;
    private Integer age;
    private LocalDateTime birthDate;
    private LocalDateTime createdDate;
    private LocalDateTime createddDateDTO;

}
