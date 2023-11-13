import java.util.regex.Matcher;
import java.util.regex.Pattern;
public abstract class RegestrationService {
    private String EmailRegex= "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
    private String UserNameRegex = "^[a-zA-Z0-9_]{3,16}$";
    private String PhoneRegex = "^(010|011|012|015)\\d{8}$";
    private String StrongPsswordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
    protected User user;
    public boolean VerifyEmail(){
        Pattern pattern = Pattern.compile(EmailRegex);
        Matcher matcher = pattern.matcher(user.GetEmail());
        return matcher.matches();
    }
    public boolean VerifyUserName(){
        Pattern pattern = Pattern.compile(UserNameRegex);
        Matcher matcher = pattern.matcher(user.GetUserName());
        return matcher.matches();
    }
    public boolean VerifyPhoneNumber(){
        Pattern pattern = Pattern.compile(PhoneRegex);
        Matcher matcher = pattern.matcher(user.GetPhone());
        return matcher.matches();
    }
    public Boolean VerifyStrongPassword(){
        Pattern pattern = Pattern.compile(StrongPsswordRegex);
        Matcher matcher = pattern.matcher(user.GetPassword());
        return matcher.matches();
    }

    public void SetUser(User user){
        this.user = user;
    }
    public boolean VerifyData(){
        if(!VerifyEmail()){
            System.out.println("Please write ur Email in the following format test@example.com");
            return false;
        }
        if(!VerifyUserName()){
            System.out.println("Invalid username. Username should contain only letters, numbers, or underscores and be between 3 and 16 characters long.");
            return false;
        }
        if(!VerifyPhoneNumber()){
            System.out.println("Invalid phone number. Please enter a valid Egyptian phone number starting with 010, 011, 012, or 015, followed by 8 digits.");
            return false;
        }
        if(!VerifyStrongPassword()){
            System.out.println("Weak password. Please enter a strong password containing at least one lowercase letter, one uppercase letter, one digit, and one special character, with a minimum length of 8 characters.");
            return false;
        }
        return true;
    }
    public abstract User Register();
}
