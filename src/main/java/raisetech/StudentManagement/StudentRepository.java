package raisetech.StudentManagement;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("select * from students")
  List<Student> search();

  @Select("select * from students_courses")
  List<StudentCourse> searchStudentCourse();
}

