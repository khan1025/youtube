package dasturlash.uz.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
@Setter
@Getter
@Repository
public class StudentCourseMarkFilterDTO {
    private String courseMarkId;
    private String studentId;
    private String courseId;
    private String mark;
    private LocalDateTime createdDate;
}