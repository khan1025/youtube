package dasturlash.uz.controller;
import dasturlash.uz.dto.StudentCourseMark;
import dasturlash.uz.dto.StudentCourseMarkFilterDTO;
import dasturlash.uz.service.StudentCourseMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/courseMark")
public class StudentCourseMarkController {
    @Autowired
    StudentCourseMarkService studentCourseMarkService;

    @PostMapping("")
    public ResponseEntity<StudentCourseMark> create(@RequestBody StudentCourseMark dto) {
        StudentCourseMark result = studentCourseMarkService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<StudentCourseMark>> getAll() {
        List<StudentCourseMark> result = studentCourseMarkService.getAllStudentCourseMark();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourseMark> getById(@PathVariable Integer id) {
        StudentCourseMark result = studentCourseMarkService.getStudentCourseMarkById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody StudentCourseMark studentCourseMark,
                                          @PathVariable("id") Integer id) {
        Boolean result = studentCourseMarkService.upadateStudentCourseMark(studentCourseMark, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        studentCourseMarkService.deleteStudentCourseMarkById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{mark-createdData}")
    public ResponseEntity<StudentCourseMark> getMarkByCreatedDate(@PathVariable LocalDateTime localDateTime) {
        StudentCourseMark result = (StudentCourseMark) studentCourseMarkService.findMarkByCreatedDate(localDateTime);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<PageImpl<StudentCourseMark>> filter(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "size", defaultValue = "30") int size,
                                                    @RequestBody StudentCourseMarkFilterDTO filterDTO) {
        return ResponseEntity.ok(studentCourseMarkService.filter(filterDTO, page - 1, size));
    }



}
