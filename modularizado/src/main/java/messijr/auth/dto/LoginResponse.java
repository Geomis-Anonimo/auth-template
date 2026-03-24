package messijr.auth.dto;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String token;
    private String type;

    public LoginResponse(String token) {
        this.token = token;
        this.type = "Bearer";
    }
}
