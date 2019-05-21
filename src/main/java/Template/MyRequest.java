package Template;

import java.util.Map;

/**
 * Created by oahnus on 2019/4/5
 * 19:29.
 */
public class MyRequest {
    private String method;
    private Map<String, String> queries;

    public MyRequest(String method, Map<String, String> queries) {
        this.method = method;
        this.queries = queries;
    }

    public Map<String, String> getQueries() {
        return queries;
    }

    public void setQueries(Map<String, String> queries) {
        this.queries = queries;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
