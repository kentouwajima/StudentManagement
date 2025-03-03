package raisetech.StudentManagement.data;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Schema(description = "受講生")
@Getter
@Setter
public class Student {

  @Schema(description = "受講生のID", example = "1", required = true)
  private String id;

  @NotBlank
  @Schema(description = "受講生の名前", example = "山田 太郎", required = true)
  private String name;

  @NotBlank
  @Schema(description = "受講生の名前（フリガナ）", example = "ヤマダ タロウ", required = true)
  private String kanaName;

  @NotBlank
  @Schema(description = "受講生のニックネーム", example = "タロちゃん", required = true)
  private String nickname;

  @NotBlank
  @Email
  @Schema(description = "受講生のメールアドレス", example = "example@domain.com", required = true, format = "email")
  private String email;

  @NotBlank
  @Schema(description = "受講生の居住地域", example = "東京都", required = true)
  private String area;

  @Schema(description = "受講生の年齢", example = "25", minimum = "0", maximum = "100")
  private int age;

  @NotBlank
  @Schema(description = "受講生の性別", example = "男性", allowableValues = {"男性", "女性", "その他"}, required = true)
  private String sex;

  @Schema(description = "備考", example = "特に無し")
  private String remark;

  @Schema(description = "論理削除フラグ", example = "false", defaultValue = "false")
  private boolean isDeleted;
}
