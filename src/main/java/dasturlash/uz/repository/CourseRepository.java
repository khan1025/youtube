package dasturlash.uz.repository;

import dasturlash.uz.entity.CourseEntity;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.mapper.CourseInfoMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer> {

    @Query("select name as name From CourseEntity where name=?1")
    List<CourseInfoMapper> findByName(String name);
    @Query("select id as id, name as name, surname as surname From CourseEntity where coursePrice=?1")
    List<CourseInfoMapper> findByPrice(Double coursePrice);
    @Query("select id as id, name as name, surname as surname From CourseEntity where courseDuration=?1")
    List<CourseInfoMapper> findByDuration(Integer courseduration);
    @Query("From CourseEntity where coursePrice=:price1 and coursePrice=:price2")
    List<CourseEntity> findByGiven2Prices(@Param("price1")Double price1, @Param("price2") Double price2);
    @Query("From CourseEntity where local datetime=:localDateTime1 and local datetime =:localDateTime2")
    List<CourseEntity> findByGiven2Dates(@Param("localDateTime1") LocalDateTime localDateTime1, @Param("localDateTime2") LocalDateTime localDateTime2);
    @Query("From CourseEntity where coursePrice =? order by createdDate desc")
    Page<CourseEntity> findByPriceBetween(Double price1, Double price2, Pageable pageable);



}
