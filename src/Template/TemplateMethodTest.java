package Template;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by oahnus on 2019/4/5
 * 19:42.
 */
public class TemplateMethodTest {
    public static void main(String... args) {
        AbstractServletTemplate servlet = new SimpleServlet();

        Map<String, String> queries = new HashMap<>();
        queries.put("username", "admin");
        queries.put("password", "pwd");


        MyResponse response = new MyResponse();

        MyRequest getRequest = new MyRequest("GET", queries);
        servlet.doService(getRequest, response);
        System.out.println(response.getRespMsg());

        MyRequest putRequest = new MyRequest("PUT", queries);
        servlet.doService(putRequest, response);
        System.out.println(response.getRespMsg());
    }
}
