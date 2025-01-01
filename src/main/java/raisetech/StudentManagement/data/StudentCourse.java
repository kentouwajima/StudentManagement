package raisetech.StudentManagement.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "受講生コース情報")
@Getter
@Setter
public class StudentCourse {

  @NotBlank
  @Schema(description = "コースID", example = "1")
  private int id;

  @NotBlank
  @Schema(description = "受講生ID", example = "1")
  private int studentId;

  @NotBlank
  @Schema(description = "コース名", example = "Javaコース")
  private String courseName;

  @Schema(description = "コース開始日", example = "2023-12-01T10:00:00")
  private LocalDateTime courseStartAt;

  @Schema(description = "コース終了日", example = "2023-12-15T16:00:00")
  private LocalDateTime courseEndAt;
}
