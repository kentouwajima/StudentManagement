package raisetech.StudentManagement;


import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentCourse {
  private int id;
  private int studentId;
  private String courseName;
  private Timestamp courseStartAt;
  private Timestamp courseEndAt;
}
