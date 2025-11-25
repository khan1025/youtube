package dasturlash.uz.mapper;

import java.time.LocalDateTime;

public interface StudentCourseMarkInfoMapper {

     String getCourseMarkId();
     String getStudentId();
     String getCourseId();
     String getMark();
     LocalDateTime getCreatedDate();
}
