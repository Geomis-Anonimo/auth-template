package messijr.auth.exception;

public class UserNotFoundException extends CustomException {
    public UserNotFoundException() {
        super(404, "Usuário não encontrado");
    }
}
