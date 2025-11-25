package dasturlash.uz.repository;

import dasturlash.uz.entity.CourseEntity;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.mapper.StudentInfoMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {

    @Query("select  name as name, surname as surname, age as age From StudentEntity where name=?1")
    List<StudentInfoMapper> findByName(String n);
    @Query("select  name as name, surname as surname, age as age From StudentEntity where surname=?1")
    List<StudentInfoMapper> findBySurname(String surname);
    @Query("select  name as name, surname as surname From StudentEntity where age=?1")
    List<StudentInfoMapper> findByAge(Integer age);
    @Query("select  name as name, surname as surname, age as age From StudentEntity where level=?1")
    List<StudentInfoMapper> findByLevel(String level);
    @Query("select  name as name, surname as surname, age as age From StudentEntity where gender=?1")
    List<StudentInfoMapper> findByGender(String gender);
    @Query("select  name as name, surname as surname, age as age From StudentEntity where local datetime =?1")
    List<StudentInfoMapper> findByGivenData(LocalDateTime localDateTime);
    @Query("select  name as name, surname as surname, age as age From StudentEntity where name=?1")
    List<StudentInfoMapper> findByGivenDates(LocalDateTime localDateTime1, LocalDateTime localDateTime2);

    List<StudentEntity> queryByNameLike(String name);
    // select * from student where name like '%gul%'
    List<StudentEntity> findAllByNameLike(String name);
    // select count(*) from student where name like '%gul%'
    Long countByName(String name);
    // select * from student where name like '%gul%' limit 1
    StudentEntity findFirstByName(String name);
    // select * from student where name like '%gul%' limit 1
    StudentEntity findTopByName(String name);
    // select * from student where name like '%gul%' limit 4
    StudentEntity findTop4ByName(String name);
    // delete from student where name id = ?
    @Modifying
    @Transactional
    void deleteById(Integer id);
    @Query("From StudentEntity  where name =:name and surname =:surname and age =:age ")
    List<StudentEntity> findByDetail(@Param("name") String n, @Param("surname") String surname, @Param("age") Integer age);
    @Query("From CourseEntity  where coursePrice >:price1 and coursePrice <:price2 ")
    List<CourseEntity> findByDetail(@Param("price1") Double p1, @Param("price2") Double p2);
    @Query("From StudentEntity  where name =?1 and surname =?2 and age =?3 ")
    List<StudentEntity> findInfo(String name, String surname, Integer age);
    @Query("select id as id, name as name, surname as surname From StudentEntity where age=?1")
    List<StudentInfoMapper> findShortInfo(Integer age);

    @Query("From StudentEntity  where name = ? order by id desc")
    Page<StudentEntity> paginationByName(String name, Pageable pageable);  // limit ? offset ? order by ...
    @Query("From StudentEntity where age = ? order by id desc")
    Page<StudentEntity> paginationByAge(Integer age, Pageable pageable); // limit ? offset ? order by ...
    @Query("From StudentEntity where gender =? order by createdDate desc")
    Page<StudentEntity>  findByGender(String gender, Pageable pageable);
    @Query("From StudentEntity where surname =? order by id desc")
    Page<StudentEntity>  findBySurname(String surname, Pageable pageable);


}
