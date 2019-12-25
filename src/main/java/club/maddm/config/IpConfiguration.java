package club.maddm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 文件上传获取服务器地址
 */
@Component
public class IpConfiguration implements ApplicationListener<WebServerInitializedEvent> {

    @Value("${server.servlet.context-path}")
    private String path;

    private int serverPort;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
        System.out.println(this.getAddress());
    }

    public String getAddress() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
        return "http://" + address.getHostAddress() + ":" + this.serverPort + path;
    }
}