package dasturlash.uz.controller;

import dasturlash.uz.dto.Course;
import dasturlash.uz.dto.CourseFilterDTO;
import dasturlash.uz.dto.Student;
import dasturlash.uz.dto.StudentFilterDTO;
import dasturlash.uz.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseService courseService;


    @PostMapping("")
    public ResponseEntity<Course> create(@RequestBody Course dto) {
        Course result = courseService.create(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("")
    public ResponseEntity<List<Course>> getAll() {
        List<Course> result = courseService.getAllCourse();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Integer id) {
        Course result = courseService.getCourseById(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@RequestBody Course course,
                                          @PathVariable("id") Integer id) {
        Boolean result = courseService.upadateCourse(course, id);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        courseService.deleteCourseById(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{name}")
    public ResponseEntity<Course> getCourseByName(@PathVariable("name") String name) {
        courseService.getCourseByName(name);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{price}")
    public ResponseEntity<Course> getCourseByPrice(@PathVariable("price") Double price) {
        courseService.getCourseByPrice(price);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{duration}")
    public ResponseEntity<Course> getCourseByDuration(@PathVariable("duration") Integer duration) {
        courseService.getCourseByDuration(duration);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{2Price}")
    public ResponseEntity<Course> getCourseByGiven2Prices(@PathVariable("2Price") Double price1, @PathVariable("2price") Double price2) {
        courseService.getCourseByGiven2Prices(price1, price2);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/filter")
    public ResponseEntity<PageImpl<Course>> filter(@RequestParam(value = "page", defaultValue = "1") int page,
                                                    @RequestParam(value = "size", defaultValue = "30") int size,
                                                    @RequestBody CourseFilterDTO filterDTO) {
        return ResponseEntity.ok(courseService.filter(filterDTO, page - 1, size));
    }


}
