package dasturlash.uz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    private String courseId;
    private String courseName;
    private Double coursePrice;
    private String courseDuration;
    private LocalDateTime createdDate;

}
