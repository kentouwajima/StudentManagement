package raisetech.StudentManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentRepository {

  @Select("select * from student where name = #{name}")
  Student searchByName(String name);

  @Insert("insert student values(#{name}, #{age})")
  void registerStudent(String name, int age);

  @Update("update student set age = #{age} where name = #{name}")
  void updateStudent(String name, int age);

  @Delete("delete from student where name = #{name}")
  void deleteStudent(String name);
}

