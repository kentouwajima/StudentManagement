package raisetech.StudentManagement.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import raisetech.StudentManagement.domain.StudentDetail;
import raisetech.StudentManagement.exception.TestException;
import raisetech.StudentManagement.service.StudentService;

/**
 * 受講生の検索や登録、更新などを行うREST APIとして受け付けるControllerです。
 */
@Validated
@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  /**
   * 受講生詳細の一覧検索です。全件検索を行うので、条件指定は行いません。
   *
   * @return　受講生詳細一覧（全件）
   */
  @Operation(summary = "一覧検索", description = "受講生の一覧を検索します。")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "受講生一覧を正常に取得しました。"),
      @ApiResponse(responseCode = "500", description = "サーバーエラーが発生しました。")
  })
  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    return service.searchStudentList();
  }

  /**
   * 受講生詳細の検索です。IDに紐づく任意の受講生の情報を取得します。
   *
   * @param id　受講生ID
   * @return　受講生
   */
  @Operation(summary = "受講生詳細検索", description = "IDに紐づく任意の受講生の情報を取得します。")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "受講生の詳細を正常に取得しました。"),
      @ApiResponse(responseCode = "404", description = "指定された受講生が見つかりません。"),
      @ApiResponse(responseCode = "500", description = "サーバーエラーが発生しました。")
  })
  @GetMapping("/student/{id}")
  public StudentDetail getStudent(@PathVariable String id){
    return service.searchStudent(id);
  }

  /**
   * 受講生詳細の登録を行います。
   *
   * @param studentDetail　受講生詳細
   * @return　実行結果
   */
  @Operation(summary = "受講生登録", description = "受講生を登録します。")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "受講生を正常に登録しました。"),
      @ApiResponse(responseCode = "400", description = "無効なリクエストです。"),
      @ApiResponse(responseCode = "500", description = "サーバーエラーが発生しました。")
  })
  @PostMapping("/registerStudent")
  public ResponseEntity<StudentDetail> registerStudent(@RequestBody @Valid StudentDetail studentDetail){
    StudentDetail responseStudentDetail = service.registerStudent(studentDetail);
    return ResponseEntity.ok(responseStudentDetail);
  }

  /**
   * 受講生詳細の更新を行います。キャンセルフラグの更新もここで行います。（論理削除）
   *
   * @param studentDetail　受講生詳細
   * @return　実行結果
   */
  @Operation(summary = "受講生詳細更新", description = "受講生の情報を更新します。")
  @ApiResponses({
      @ApiResponse(responseCode = "200", description = "受講生情報を正常に更新しました。"),
      @ApiResponse(responseCode = "400", description = "無効なリクエストです。"),
      @ApiResponse(responseCode = "404", description = "指定された受講生が見つかりません。"),
      @ApiResponse(responseCode = "500", description = "サーバーエラーが発生しました。")
  })
  @PutMapping("/updateStudent")
  public ResponseEntity<String> updateStudent(@RequestBody @Valid StudentDetail studentDetail){
    service.updateStudent(studentDetail);
    return ResponseEntity.ok("更新処理が成功しました。");
  }

  @ExceptionHandler(TestException.class)
  public ResponseEntity<String> handleTestException(TestException ex){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
  }
}
