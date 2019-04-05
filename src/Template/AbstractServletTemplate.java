package Template;

import java.util.Map;

/**
 * Created by oahnus on 2019/4/5
 * 19:26.
 */
public abstract class AbstractServletTemplate {

    private final static String METHOD_POST = "POST";
    private final static String METHOD_GET = "GET";
    private final static String METHOD_DELETE = "DELETE";
    private final static String METHOD_PUT = "PUT";

    public void doService(MyRequest req, MyResponse resp) {
        String method = req.getMethod();

        if (method.equals(METHOD_GET)) {
            doGet(req, resp);
        } else if (method.equals(METHOD_POST)) {
            doPost(req, resp);
        } else if (method.equals(METHOD_PUT)) {
            doPut(req, resp);
        } else if (method.equals(METHOD_DELETE)) {
            doDelete(req, resp);
        } else {
            throw new RuntimeException("Http Method Not Supported");
        }
    }

    protected void doDelete(MyRequest req, MyResponse resp) {
        Map<String, String> queries = req.getQueries();
        resp.setRespMsg("Handle Delete Request With Queries " + queries);
    }

    protected void doPut(MyRequest req, MyResponse resp) {
        Map<String, String> queries = req.getQueries();
        resp.setRespMsg(" Handle Put Request With Queries :" + queries);

    }

    protected void doPost(MyRequest req, MyResponse resp) {
        Map<String, String> queries = req.getQueries();
        resp.setRespMsg(" Handle Post Request With Queries :" + queries);
    }

    protected void doGet(MyRequest req, MyResponse resp) {
        Map<String, String> queries = req.getQueries();
        resp.setRespMsg(" Handle Get Request With Queries :" + queries);
    }
}
