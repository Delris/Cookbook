package delris.Cookbook.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.lang.NonNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPostDTO {
    @JsonProperty("id")
    private long userId;
    @JsonProperty("name")
    private String name;
    @JsonProperty("surname")
    private String surname;
    @JsonProperty("nickname")
    private String nickname;
    @JsonProperty("password")
    @NonNull
    private String password;
}
