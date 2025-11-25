package dasturlash.uz.repository;

import dasturlash.uz.dto.FilterResultDTO;
import dasturlash.uz.dto.StudentFilterDTO;
import dasturlash.uz.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class StudentCustomRepository {
        @Autowired
        private EntityManager entityManager;
        public FilterResultDTO<StudentEntity> filter(StudentFilterDTO filter, int page, int size) {
            StringBuilder selectQb = new StringBuilder("SELECT s FROM StudentEntity s  ");
            StringBuilder countQb = new StringBuilder("SELECT count() FROM StudentEntity s  ");
            StringBuilder conditionQb = new StringBuilder(" where 1=1 ");

            Map<String, Object> params = new HashMap<>();

            if (filter.getAge() != null) { // condition by id
                conditionQb.append(" and s.age =:age ");
                params.put("age", filter.getAge());
            }
            if (filter.getName() != null) { // condition by id
                conditionQb.append(" and s.name =:name ");
                params.put("name", filter.getName());
            }
            if (filter.getSurname() != null) { // condition by id
                conditionQb.append(" and s.surname like :surname ");
                params.put("surname", filter.getSurname());
            }

            selectQb.append(conditionQb.toString());
            countQb.append(conditionQb.toString());

            Query selectQuery = entityManager.createQuery(selectQb.toString());
            Query countQuery = entityManager.createQuery(countQb.toString());

            params.forEach(selectQuery::setParameter);
            params.forEach(countQuery::setParameter);

            selectQuery.setFirstResult((page) * size); // offset
            selectQuery.setMaxResults(size); // limit
            List<StudentEntity> studentList = selectQuery.getResultList();

            Long totalCount = (Long) countQuery.getSingleResult();

            return new FilterResultDTO<>(studentList, totalCount);

        }
}
