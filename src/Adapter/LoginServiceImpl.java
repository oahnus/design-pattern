package Adapter;

/**
 * Created by oahnus on 2019/4/5
 * 19:53.
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public String login(String username, String pwd) {
        System.out.println(String.format("Login With Username [%s] And Password [%s]", username, pwd));
        String token = "token";
        return token;
    }
}
