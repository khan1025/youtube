package dasturlash.uz.service;
import dasturlash.uz.dto.*;
import dasturlash.uz.entity.StudentCourseMarkEntity;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.mapper.StudentCourseMarkInfoMapper;
import dasturlash.uz.repository.StudentCourseMarkCustomRepository;
import dasturlash.uz.repository.StudentCourseMarkRepository;
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
public class StudentCourseMarkService {

    @Autowired
    private StudentCourseMarkRepository studentCourseMarkRepository;
    @Autowired
    private StudentCourseMarkCustomRepository studentCourseMarkCustomRepository;
    public StudentCourseMark create(StudentCourseMark dto) {
        StudentCourseMarkEntity studentCourseMarkEntity = new StudentCourseMarkEntity();
        studentCourseMarkEntity.setMark(dto.getMark());
        studentCourseMarkEntity.setCreatedDate(dto.getCreatedDate());
        studentCourseMarkRepository.save(studentCourseMarkEntity);
        dto.setCourseMarkId(dto.getCourseId());
        return dto;
    }

    public List<StudentCourseMark> getAllStudentCourseMark(){
        Iterable<StudentCourseMarkEntity> entityList = studentCourseMarkRepository.findAll();
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkEntity entity : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(entity.getCourseMarkId());
            dto.setMark(entity.getMark());
            dto.setCreatedDate(entity.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public StudentCourseMark getStudentCourseMarkById(Integer id) {
        Optional<StudentCourseMarkEntity> optional = studentCourseMarkRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }

        StudentCourseMarkEntity entity = optional.get();
        StudentCourseMark dto = new StudentCourseMark();
        dto.setCourseMarkId(entity.getCourseMarkId());
        dto.setMark(entity.getMark());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }

    public Boolean upadateStudentCourseMark(StudentCourseMark dto, Integer id) {
        Optional<StudentCourseMarkEntity> optional = studentCourseMarkRepository.findById(id);
        if(optional.isEmpty()) {
            return false;
        }
        StudentCourseMarkEntity entity = optional.get();
        entity.setMark(dto.getMark());
        entity.setCreatedDate(dto.getCreatedDate());
        studentCourseMarkRepository.save(entity);
        return true;
    }

    public void deleteStudentCourseMarkById(Integer id) {
        studentCourseMarkRepository.deleteById(id);
    }

    public List<StudentCourseMark> getStudentCourseMarkByName(String name){
        List<StudentCourseMarkInfoMapper> entityList = studentCourseMarkRepository.findByName(name);
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkInfoMapper mapper : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(mapper.getCourseMarkId());
            dto.setMark(mapper.getMark());
            dto.setCreatedDate(mapper.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

public List<StudentCourseMark> getStudentCourseMarkByPrice(Double price){
        List<StudentCourseMarkInfoMapper> entityList = studentCourseMarkRepository.findByPrice(String.valueOf(price));
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkInfoMapper mapper : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(mapper.getCourseMarkId());
            dto.setMark(mapper.getMark());
            dto.setCreatedDate(mapper.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

public List<StudentCourseMark> getStudentCourseMarkByCourseId(String courseId){
        List<StudentCourseMarkInfoMapper> entityList = studentCourseMarkRepository.findByCourseId(courseId);
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkInfoMapper mapper : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(mapper.getCourseMarkId());
            dto.setMark(mapper.getMark());
            dto.setCreatedDate(mapper.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

public List<StudentCourseMark> getStudentCourseMarkByDuration(Integer duration){
        List<StudentCourseMarkInfoMapper> entityList = studentCourseMarkRepository.findByDuration(String.valueOf(duration));
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkInfoMapper mapper : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(mapper.getCourseMarkId());
            dto.setMark(mapper.getMark());
            dto.setCreatedDate(mapper.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<StudentCourseMark> getStudentCourseMarkByStudentId(String studentId){
        List<StudentCourseMarkInfoMapper> entityList = studentCourseMarkRepository.findByStudentId((studentId));
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkInfoMapper mapper : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(mapper.getCourseMarkId());
            dto.setMark(mapper.getMark());
            dto.setCreatedDate(mapper.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
    }

       public List<StudentCourseMark> findMarkByCreatedDate(LocalDateTime localDateTime){
        List<StudentCourseMarkInfoMapper> entityList = studentCourseMarkRepository.findMarkByCreatedDate(String.valueOf((localDateTime)));
        List<StudentCourseMark> dtoList = new ArrayList<>();
        for (StudentCourseMarkInfoMapper mapper : entityList) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setCourseMarkId(mapper.getCourseMarkId());
            dto.setMark(mapper.getMark());
            dto.setCreatedDate(mapper.getCreatedDate());
            dtoList.add(dto);
        }
        return dtoList;
          }

    public PageImpl<StudentCourseMark> filter(StudentCourseMarkFilterDTO filter, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        FilterResultDTO<StudentCourseMarkEntity> result = studentCourseMarkCustomRepository.filter(filter, page, size);

        List<StudentCourseMark> dtoList = new LinkedList<>();
        for (StudentCourseMarkEntity entity : result.getContent()) {
            StudentCourseMark dto = new StudentCourseMark();
            dto.setStudentId(entity.getStudentId());
            dto.setCourseId(entity.getCourseId());
            dto.setMark(entity.getMark());
            dtoList.add(dto);
        }
        return new PageImpl<>(dtoList, pageRequest, result.getTotalCount());
    }





}
