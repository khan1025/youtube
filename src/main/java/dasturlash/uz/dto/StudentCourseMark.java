package dasturlash.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentCourseMark {

    private String courseMarkId;
    private String studentId;
    private String courseId;
    private String mark;
    private LocalDateTime createdDate;


}
