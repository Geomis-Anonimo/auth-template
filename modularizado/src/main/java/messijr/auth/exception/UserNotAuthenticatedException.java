package messijr.auth.exception;

public class UserNotAuthenticatedException extends CustomException {
    public UserNotAuthenticatedException() {
        super(401, "Usuário não autenticado");
    }
}
