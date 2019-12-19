package rest.client;


import com.alibaba.fastjson.JSONObject;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestClient {


    //import everything here
    public static void main(String[] args) {

        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("x-tenant-id", "2");
        headers.put("x-user-id", "1000");
        headers.put("cache-control", "no-cache");

        Object arg = "{\"objectId\":\"830c63dff5ae4835b6e25845434594a3\"} ";
        try {
            ResteasyClient client = new ResteasyClientBuilder().build();
            ResteasyWebTarget target = client.target("http://10.113.32.47:8008/fs-crm-workflow/approval/approvalInstance");
            Invocation.Builder request = target.request();
            if (null != headers && !headers.isEmpty()) {
                headers.forEach(request::header);
            }
            Response post = request.post(Entity.entity(arg, MediaType.APPLICATION_JSON_TYPE));
            assert post.getStatus() == 200;
            System.out.println(JSONObject.toJSONString(post.readEntity(Map.class)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
