package dasturlash.uz.service;


import dasturlash.uz.dto.FilterResultDTO;
import dasturlash.uz.dto.Student;
import dasturlash.uz.dto.StudentFilterDTO;
import dasturlash.uz.entity.StudentEntity;
import dasturlash.uz.mapper.StudentInfoMapper;
import dasturlash.uz.repository.StudentCustomRepository;
import dasturlash.uz.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCustomRepository studentCustomRepository;
    public Student create(Student dto) {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName(dto.getName());
        studentEntity.setSurname(dto.getSurname());
        studentEntity.setAge(dto.getAge());
        studentRepository.save(studentEntity);
        dto.setId(dto.getId());
        return dto;
    }

    public List<Student> getAllStudent(){
        Iterable<StudentEntity> entityList = studentRepository.findAll();
        List<Student> dtoList = new ArrayList<>();
        for (StudentEntity entity : entityList) {
            Student dto = new Student();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dto.setAge(entity.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public Student getStudentById(Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isEmpty()) {
            return null;
        }

        StudentEntity entity = optional.get();
        Student dto = new Student();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());

        return dto;
    }

    public Boolean upadateStudent(Student dto, Integer id) {
        Optional<StudentEntity> optional = studentRepository.findById(id);
        if(optional.isEmpty()) {
            return false;
        }
        StudentEntity entity = optional.get();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        studentRepository.save(entity);
        return true;
    }

    public void deleteStudentById(Integer id) {
        studentRepository.deleteById(id);
    }

    public List<Student> findByName(String name){
        List<StudentInfoMapper> entityList = studentRepository.findByName(name);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Student> getStudentBySurname(String surname){
        List<StudentInfoMapper> entityList = studentRepository.findBySurname(surname);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Student> getStudentByAge(int age){
        List<StudentInfoMapper> entityList = studentRepository.findByAge(age);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<Student> getStudentByLevel(String level){
        List<StudentInfoMapper> entityList = studentRepository.findByLevel(level);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Student> getStudentByGender(String gender){
        List<StudentInfoMapper> entityList = studentRepository.findByGender(gender);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Student> getStudentByGivenData(LocalDateTime localDateTime){
        List<StudentInfoMapper> entityList = studentRepository.findByGivenData(localDateTime);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Student> getStudentByGivenDates(LocalDateTime localDateTime1, LocalDateTime localDateTime2){
        List<StudentInfoMapper> entityList = studentRepository.findByGivenDates(localDateTime1, localDateTime2);
        List<Student> dtoList = new ArrayList<>();
        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dto.setAge(mapper.getAge());
            dtoList.add(dto);
        }
        return dtoList;
    }

    public List<Student> findShortInfo(Integer age) {
        List<StudentInfoMapper> entityList = studentRepository.findShortInfo(age);
        List<Student> dtoList = new LinkedList<>();

        for (StudentInfoMapper mapper : entityList) {
            Student dto = new Student();
            dto.setId(mapper.getId());
            dto.setName(mapper.getName());
            dto.setSurname(mapper.getSurname());
            dtoList.add(dto);
        }
        return dtoList;
    }

     public List<Student> findByDetail(String name, String surname, Integer age) {
        List<StudentEntity> entityList = studentRepository.findByDetail(name, surname, age);
        List<Student> dtoList = new LinkedList<>();
        for (StudentEntity entity : entityList) {
            Student dto = new Student();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        }
        return dtoList;
    }
    public List<Student> findInfo(String name, String surname, Integer age) {
        List<StudentEntity> entityList = studentRepository.findInfo(name, surname, age);
        List<Student> dtoList = new LinkedList<>();
        for (StudentEntity entity : entityList) {
            Student dto = new Student();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        }
        return dtoList;
    }


    public PageImpl<Student> paginationByName(String name, int page, int size) {
    // page = 1, size = 30
    PageRequest pageRequest = PageRequest.of(page - 1, size);
    Page<StudentEntity> pageResult = studentRepository.paginationByName(name, pageRequest);
    // content - select * from student limit :size offset :page
    // totalCount - select count(*) from student

    List<Student> dtoList = new LinkedList<>();
    for (StudentEntity entity : pageResult.getContent()) {
        Student dto = new Student();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dtoList.add(dto);
    }

    Long totalCount = pageResult.getTotalElements();

    return new PageImpl<>(dtoList, pageRequest, totalCount);
  }
//   public PageImpl<Student> paginationByName(String name, int page, int size) {
//    // page = 1, size = 30
//    PageRequest pageRequest = PageRequest.of(page - 1, size);
//    Page<StudentEntity> pageResult = studentRepository.paginationByName(name, pageRequest);
//    // content - select * from student limit :size offset :page
//    // totalCount - select count(*) from student
//
//    List<Student> dtoList = new LinkedList<>();
//    for (StudentEntity entity : pageResult.getContent()) {
//        Student dto = new Student();
//        dto.setId(entity.getId());
//        dto.setName(entity.getName());
//        dto.setSurname(entity.getSurname());
//        dtoList.add(dto);
//    }
//
//    Long totalCount = pageResult.getTotalElements();
//
//    return new PageImpl<>(dtoList, pageRequest, totalCount);
//   }


   public PageImpl<Student> paginationByAge(Integer age, int page, int size) {
    // page = 1, size = 30
    PageRequest pageRequest = PageRequest.of(page - 1, size);
    Page<StudentEntity> pageResult = studentRepository.paginationByAge(age, pageRequest);
    // content - select * from student limit :size offset :page
    // totalCount - select count(*) from student

    List<Student> dtoList = new LinkedList<>();
    for (StudentEntity entity : pageResult.getContent()) {
        Student dto = new Student();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dtoList.add(dto);
    }

    Long totalCount = pageResult.getTotalElements();

    return new PageImpl<>(dtoList, pageRequest, totalCount);
   }

    public PageImpl<Student> filter(StudentFilterDTO filter, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        FilterResultDTO<StudentEntity> result = studentCustomRepository.filter(filter, page, size);

        List<Student> dtoList = new LinkedList<>();
        for (StudentEntity entity : result.getContent()) {
            Student dto = new Student();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            dtoList.add(dto);
        }
        return new PageImpl<>(dtoList, pageRequest, result.getTotalCount());
    }



}






