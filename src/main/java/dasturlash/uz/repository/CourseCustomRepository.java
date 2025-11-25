package dasturlash.uz.repository;

import dasturlash.uz.dto.Course;
import dasturlash.uz.dto.CourseFilterDTO;
import dasturlash.uz.dto.FilterResultDTO;
import dasturlash.uz.entity.CourseEntity;
import dasturlash.uz.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CourseCustomRepository {

    @Autowired
    private EntityManager entityManager;

    public FilterResultDTO<CourseEntity> filter(CourseFilterDTO filter, int page, int size) {
        StringBuilder selectQb = new StringBuilder("SELECT s FROM CoursetEntity s  ");
        StringBuilder countQb = new StringBuilder("SELECT count() FROM CoursetEntity s  ");
        StringBuilder conditionQb = new StringBuilder(" where 1=1 ");

        Map<String, Object> params = new HashMap<>();

        if (filter.getCourseName() != null) { // condition by id
            conditionQb.append(" and s.courseName =:courseName ");
            params.put("courseName", filter.getCourseName());
        }
        if (filter.getTitle() != null) { // condition by id
            conditionQb.append(" and s.title =title ");
            params.put("title", filter.getTitle());
        }

        selectQb.append(conditionQb.toString());
        countQb.append(conditionQb.toString());

        Query selectQuery = entityManager.createQuery(selectQb.toString());
        Query countQuery = entityManager.createQuery(countQb.toString());

        params.forEach(selectQuery::setParameter);
        params.forEach(countQuery::setParameter);

        selectQuery.setFirstResult((page) * size); // offset
        selectQuery.setMaxResults(size); // limit
        List<CourseEntity> courseList = selectQuery.getResultList();

        Long totalCount = (Long) countQuery.getSingleResult();

        return new FilterResultDTO<>(courseList, totalCount);

    }
}
