package messijr.auth.exception;

public class UnauthorizedException extends CustomException {
    public UnauthorizedException() {
        super(401, "Unauthorized");
    }
}
