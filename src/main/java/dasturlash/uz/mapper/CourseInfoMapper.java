package dasturlash.uz.mapper;

import java.time.LocalDateTime;

public interface CourseInfoMapper {

     String getCourseId();
     String getCourseName();
     Double getCoursePrice();
     String getCourseDuration();
     LocalDateTime getCreatedDate();
}
