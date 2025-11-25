package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Getter
@Setter
@Repository
public class CourseFilterDTO{
    private String courseName;
    private String title;
    private LocalDateTime createdDate;
    private LocalDateTime createddDateDTO;
}
