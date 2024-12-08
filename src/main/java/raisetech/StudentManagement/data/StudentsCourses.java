package raisetech.StudentManagement.data;


import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {
  private int id;
  private int studentId;
  private String courseName;
  private Timestamp courseStartAt;
  private Timestamp courseEndAt;
}
