import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author: wangdawei
 * @Description:
 * @Date: 2021/3/19 14:54
 */
public class NT {
    public static void main(String[] args) throws Exception {
        HttpPost post = new HttpPost("https://xin-sandbox.asiainfo.com:16020/gateway/bin/oauth2/token?client_id=91cc9299ed8e1a073c76879ffb99424a&client_secret=08566a4bf65dbcba1c35e075ed487a6c&grant_type=authorization_code&code=tY922nw1TzK4iLfCCk5krK74KID6fnPz&redirect_uri=http://10.3.3.198:18081/auto/webConfig/mainPage");
       // HttpPost post = new HttpPost("https://xin-sandbox.asiainfo.com:16020/xin/oauth2/token?client_id=u1ru3LGpHYJiniiUn1BTDh3Q1SBBmaWX&client_secret=JWSZM2sTV40Sbv0oNKF7fvz7ipLtCtA4&grant_type=authorization_code&code=pr9sGiEFlmfGNAyi4qrps3vZY6cwdkwT");
        // 添加参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
/*        params.add(new BasicNameValuePair("key", "68d7b52b0e37a602fac910e02d521994"));
        params.add(new BasicNameValuePair("city", "北京"));*/
        post.setHeader("Content-Type","application/json;charset=utf-8");
        post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
        // (3) 发送请求
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpResponse response = httpClient.execute(post);
        if (response.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = response.getEntity();
            String message = EntityUtils.toString(resEntity, "utf-8");
            System.out.println(message);
        } else {
            System.out.println("请求失败");
        }
        System.out.println("响应状态信息为"+response.getStatusLine());
    }

}
