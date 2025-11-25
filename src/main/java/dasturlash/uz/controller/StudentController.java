package dasturlash.uz.controller;

import dasturlash.uz.dto.Student;
import dasturlash.uz.dto.StudentFilterDTO;
import dasturlash.uz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("")
    public ResponseEntity<Student> create(@RequestBody Student dto) {
        Student result = studentService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> result = studentService.getAllStudent();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Integer id) {
        Student result = studentService.getStudentById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody Student student,
                                          @PathVariable("id") Integer id) {
        Boolean result = studentService.upadateStudent(student, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Student>> getByName(@PathVariable("name") String  name) {
        Student result = (Student) studentService.findByName(name);
        return ResponseEntity.ok((List<Student>) result);
    }

    @GetMapping("/{surname}")
    public ResponseEntity<List<Student>> getBySurname(@PathVariable("surname")String surname) {
        Student result = (Student) studentService.getStudentBySurname(surname);
        return ResponseEntity.ok((List<Student>) result);
    }
    @GetMapping("/{age}")
    public ResponseEntity<List<Student>> getByAge(@RequestParam("age") Integer age) {
        Student result = (Student) studentService.getStudentByAge(age);
        return ResponseEntity.ok((List<Student>) result);

    }
    @GetMapping("/{level}")
    public ResponseEntity<List<Student>> getSyudentByLevel(@PathVariable("level") String  level) {
        Student result = (Student) studentService.getStudentByLevel(level);
        return ResponseEntity.ok((List<Student>) result);
    }
    @GetMapping("/{givenDate}")
    public ResponseEntity<List<Student>> getStudentByGivenDate(@RequestParam("givenDate") LocalDateTime localDateTime) {
        Student result = (Student) studentService.getStudentByGivenData(localDateTime);
        return ResponseEntity.ok((List<Student>) result);
    }
    @GetMapping("/{givenDates}")
    public ResponseEntity<List<Student>> getStudentByGivenDates(@RequestParam("givenDates") LocalDateTime localDateTime1, @RequestParam("givenDates") LocalDateTime localDateTime2) {
        Student result = (Student) studentService.getStudentByGivenDates(localDateTime1,localDateTime2);
        return ResponseEntity.ok((List<Student>) result);
    }
    @GetMapping("/short-info}")
    public ResponseEntity<List<Student>> getShortInfoByAge(@RequestParam("age") Integer age) {
        List<Student> result = studentService.findShortInfo(age);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/info}")
    public ResponseEntity<List<Student>> getShortInfoByAge(@RequestParam("age") Integer age, @RequestParam("name") String name, @RequestParam("surname") String surname ) {
        List<Student> result = studentService.findInfo(name, surname, age);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/detail-info}")
    public ResponseEntity<List<Student>> getShortInfoByDetail(@RequestParam("age") Integer age, @RequestParam("name") String name, @RequestParam("surname") String surname ) {
        List<Student> result = studentService.findByDetail(name, surname, age);
        return ResponseEntity.ok(result);
    }




    @GetMapping("/filter")
    public ResponseEntity<PageImpl<Student>> filter(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "size", defaultValue = "30") int size,
                                                    @RequestBody StudentFilterDTO filterDTO) {
        return ResponseEntity.ok(studentService.filter(filterDTO, page - 1, size));
    }







}
