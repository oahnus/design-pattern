package Template;

import java.util.Map;

/**
 * Created by oahnus on 2019/4/5
 * 19:42.
 */
public class SimpleServlet extends AbstractServletTemplate {
    @Override
    protected void doPost(MyRequest req, MyResponse resp) {
        Map<String, String> queries = req.getQueries();
        resp.setRespMsg("SimpleServlet Handle Post Request With Queries " + queries);
    }

    @Override
    protected void doGet(MyRequest req, MyResponse resp) {
        Map<String, String> queries = req.getQueries();
        resp.setRespMsg("SimpleServlet Handle Get Request With Queries " + queries);
    }
}
