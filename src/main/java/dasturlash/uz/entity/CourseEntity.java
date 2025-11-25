package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "course")
@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseId;
    @Column
    private String courseName;
    @Column
    private Double coursePrice;
    @Column
    private String courseDuration;
    @Column
    private LocalDateTime createdDate;
}
