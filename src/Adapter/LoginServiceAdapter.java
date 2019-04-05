package Adapter;

/**
 * Created by oahnus on 2019/4/5
 * 19:55.
 */
public class LoginServiceAdapter {
    LoginService loginService;

    public LoginServiceAdapter(LoginService loginService) {
        this.loginService = loginService;
    }

    public String loginForWechat(String openId) {
        System.out.println("Login With OpenId " + openId);
        String username = "WeChat Username";
        String password = "WeChat Pwd";

        return loginService.login(username, password);
    }
}
