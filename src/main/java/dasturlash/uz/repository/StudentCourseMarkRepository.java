package dasturlash.uz.repository;

import dasturlash.uz.entity.StudentCourseMarkEntity;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.mapper.CourseInfoMapper;
import dasturlash.uz.mapper.StudentCourseMarkInfoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentCourseMarkRepository extends CrudRepository<StudentCourseMarkEntity, Integer> {

    @Query(value = "select id as id, studentId as studentId, courseId as courseId From CourseEntity where courseName=?1")
    List<StudentCourseMarkInfoMapper> findByName(String courseName);
    @Query(value = "select id as id, studentId as studentId, courseId as courseId From CourseEntity where coursePrice=?1")
    List<StudentCourseMarkInfoMapper> findByPrice(String coursePrice);
    @Query(value = "select id as id, studentId as studentId, courseId as courseId From CourseEntity where courseId=?1")
    List<StudentCourseMarkInfoMapper> findByCourseId(String courseId);
    @Query(value = "select id as id, studentId as studentId, courseId as courseId From CourseEntity where studentId=?1")
    List<StudentCourseMarkInfoMapper> findByStudentId(String studentId);
    @Query(value = "select id as id, studentId as studentId, courseId as courseId From CourseEntity where courseDuration=?1")
    List<StudentCourseMarkInfoMapper> findByDuration(String courseDuration);
    @Query(value = "select mark as mark From CourseEntity where createdDate=?1")
    List<StudentCourseMarkInfoMapper> findMarkByCreatedDate(String courseDuration);
    // 9-10 misollarni korish

    List<StudentCourseMarkInfoMapper> findByDuraion(String courseDuration);
//    List<StudentCourseMarkInfoMapper> findByDuration(String courseDuration);
//    List<StudentCourseMarkInfoMapper> findByDuration(String courseDuration);
//    List<StudentCourseMarkInfoMapper> findByDuration(String courseDuration);
    @Query("From StudentCourseMarkEntity where courseId =? order by createdDate desc")
    Page<StudentCourseMarkEntity> findByCourseId(String courseId, Pageable pageable);
    @Query("From StudentCourseMarkEntity where studentId =? order by createdDate desc")
    Page<StudentCourseMarkEntity> findByStudentId(String studentId, Pageable pageable);





}
