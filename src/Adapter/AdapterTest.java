package Adapter;

/**
 * Created by oahnus on 2019/4/5
 * 20:45.
 */
public class AdapterTest {
    public static void main(String... args) {
        LoginService loginService = new LoginServiceImpl();
        loginService.login("admin", "pwd");

        LoginServiceAdapter adapter = new LoginServiceAdapter(loginService);
        adapter.loginForWechat("OpenId-alsjdfkasld");
    }
}
