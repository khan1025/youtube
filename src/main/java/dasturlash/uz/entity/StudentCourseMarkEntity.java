package dasturlash.uz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@Table(name= "markEntity")
public class StudentCourseMarkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String courseMarkId;
    @Column
    private String studentId;
    @Column
    private String courseId;
    @Column
    private String mark;
    @Column
    private LocalDateTime createdDate;
}
