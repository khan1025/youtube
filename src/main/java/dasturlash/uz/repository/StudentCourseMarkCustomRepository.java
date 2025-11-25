package dasturlash.uz.repository;

import dasturlash.uz.dto.FilterResultDTO;
import dasturlash.uz.dto.StudentCourseMarkFilterDTO;
import dasturlash.uz.dto.StudentFilterDTO;
import dasturlash.uz.entity.StudentCourseMarkEntity;
import dasturlash.uz.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentCourseMarkCustomRepository {

    @Autowired
    private EntityManager entityManager;
    public FilterResultDTO<StudentCourseMarkEntity> filter(StudentCourseMarkFilterDTO filter, int page, int size) {
        StringBuilder selectQb = new StringBuilder("SELECT s FROM StudentCourseMarkEntity s  ");
        StringBuilder countQb = new StringBuilder("SELECT count() FROM StudentCourseMarkEntity s  ");
        StringBuilder conditionQb = new StringBuilder(" where 1=1 ");

        Map<String, Object> params = new HashMap<>();

        if (filter.getCourseId() != null) { // condition by id
            conditionQb.append(" and s.courseId =:courseId ");
            params.put("courseId", filter.getCourseId());
        }
        if (filter.getStudentId() != null) { // condition by id
            conditionQb.append(" and s.studentId =:studentId ");
            params.put("studentId", filter.getStudentId());
        }
        if (filter.getMark() != null) { // condition by id
            conditionQb.append(" and s.mark like :mark ");
            params.put("mark", filter.getMark());
        }
        if (filter.getCreatedDate() != null) { // condition by id
            conditionQb.append(" and s.createdDate like :createdDate ");
            params.put("createdDate", filter.getCreatedDate());
        }

        selectQb.append(conditionQb.toString());
        countQb.append(conditionQb.toString());

        Query selectQuery = entityManager.createQuery(selectQb.toString());
        Query countQuery = entityManager.createQuery(countQb.toString());

        params.forEach(selectQuery::setParameter);
        params.forEach(countQuery::setParameter);

        selectQuery.setFirstResult((page) * size); // offset
        selectQuery.setMaxResults(size); // limit
        List<StudentCourseMarkEntity> studentCourseMarkList = selectQuery.getResultList();

        Long totalCount = (Long) countQuery.getSingleResult();

        return new FilterResultDTO<>(studentCourseMarkList, totalCount);

    }
}
