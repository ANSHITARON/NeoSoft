package payload;
import lombok.*;
import org.springframework.http.HttpStatus;
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseMessage {

    private String message;
    private boolean success;
    private HttpStatus Status;
}