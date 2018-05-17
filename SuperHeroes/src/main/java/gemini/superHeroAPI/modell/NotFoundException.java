package gemini.superHeroAPI.modell;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class NotFoundException {

    private String errorMessage;

    public NotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMesage(String errorMesage) {
        this.errorMessage = errorMesage;
    }

    public String toString(String username, String password) {
        return "username: " + username + " or password: " + password + " is not correct";
    }
}
