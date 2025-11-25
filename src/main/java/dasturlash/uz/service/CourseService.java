package dasturlash.uz.service;

import dasturlash.uz.dto.*;
import dasturlash.uz.entity.CourseEntity;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.mapper.CourseInfoMapper;
import dasturlash.uz.repository.CourseCustomRepository;
import dasturlash.uz.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private CourseCustomRepository courseCustomRepository;

    public Course create(Course dto) {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName(dto.getCourseName());
        courseEntity.setCourseDuration(dto.getCourseDuration());
        courseEntity.setCoursePrice(dto.getCoursePrice());
        courseRepository.save(courseEntity);
        dto.setCourseId(dto.getCourseId());
        return dto;
    }

    public List<Course> getAllCourse() {
        Iterable<CourseEntity> entityList = courseRepository.findAll();
        List<Course> dtoList = new ArrayList<>();
        for (CourseEntity entity : entityList) {
            Course dto = new Course();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseName(entity.getCourseName());
            dto.setCourseDuration(entity.getCourseDuration());
            dto.setCoursePrice(entity.getCoursePrice());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public Course getCourseById(Integer id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()) {
            return null;
        }

        CourseEntity entity = optional.get();
        Course dto = new Course();
        dto.setCourseId(entity.getCourseId());
        dto.setCourseName(entity.getCourseName());
        dto.setCourseDuration(entity.getCourseDuration());
        dto.setCourseId(entity.getCourseId());
        dto.setCoursePrice(entity.getCoursePrice());
        return dto;
    }

    public Boolean upadateCourse(Course dto, Integer id) {
        Optional<CourseEntity> optional = courseRepository.findById(id);
        if (optional.isEmpty()) {
            return false;
        }
        CourseEntity entity = optional.get();
        entity.setCourseName(dto.getCourseName());
        entity.setCoursePrice(dto.getCoursePrice());
        entity.setCoursePrice(dto.getCoursePrice());
        courseRepository.save(entity);
        return true;
    }

    public void deleteCourseById(Integer id) {
        courseRepository.deleteById(id);
    }

    public List<Course> getCourseByName(String name) {
        List<CourseInfoMapper> entityList = courseRepository.findByName(name);
        List<Course> dtoList = new ArrayList<>();
        for (CourseInfoMapper mapper : entityList) {
            Course dto = new Course();
            dto.setCourseId(mapper.getCourseId());
            dto.setCourseName(mapper.getCourseName());
            dto.setCourseDuration(mapper.getCourseDuration());
            dto.setCoursePrice(mapper.getCoursePrice());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Course> getCourseByPrice(Double price) {
        List<CourseInfoMapper> entityList = courseRepository.findByPrice(price);
        List<Course> dtoList = new ArrayList<>();
        for (CourseInfoMapper mapper : entityList) {
            Course dto = new Course();
            dto.setCourseId(mapper.getCourseId());
            dto.setCourseName(mapper.getCourseName());
            dto.setCourseDuration(mapper.getCourseDuration());
            dto.setCoursePrice(mapper.getCoursePrice());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Course> getCourseByDuration(Integer duration) {
        List<CourseInfoMapper> entityList = courseRepository.findByDuration(duration);
        List<Course> dtoList = new ArrayList<>();
        for (CourseInfoMapper entity : entityList) {
            Course dto = new Course();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseName(entity.getCourseName());
            dto.setCourseDuration(entity.getCourseDuration());
            dto.setCoursePrice(entity.getCoursePrice());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Course> getCourseByGiven2Prices(Double price1, Double price2) {
        List<CourseEntity> entityList = courseRepository.findByGiven2Prices(price1, price2);
        List<Course> dtoList = new ArrayList<>();
        for (CourseEntity entity : entityList) {
            Course dto = new Course();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseName(entity.getCourseName());
            dto.setCourseDuration(entity.getCourseDuration());
            dto.setCoursePrice(entity.getCoursePrice());
            dtoList.add(dto);
        }
        return dtoList;
        }


      public List<Course> getCourseByGiven2Dates(LocalDateTime localDateTime1, LocalDateTime  localDateTime){
        List<CourseEntity> entityList = courseRepository.findByGiven2Dates(localDateTime1,  localDateTime);
        List<Course> dtoList = new ArrayList<>();
        for (CourseEntity entity : entityList) {
            Course dto = new Course();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseName(entity.getCourseName());
            dto.setCourseDuration(entity.getCourseDuration());
            dto.setCoursePrice(entity.getCoursePrice());
            dtoList.add(dto);
        }
        return dtoList;
      }


    public PageImpl<Course> filter(CourseFilterDTO filter, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        FilterResultDTO<CourseEntity> result = courseCustomRepository.filter(filter, page, size);
        List<Course> dtoList = new LinkedList<>();
        for (CourseEntity entity : result.getContent()) {
            Course dto = new Course();
            dto.setCourseId(entity.getCourseId());
            dto.setCourseName(entity.getCourseName());
            dto.setCourseDuration(entity.getCourseDuration());
            dtoList.add(dto);
        }
        return new PageImpl<>(dtoList, pageRequest, result.getTotalCount());
    }

}
