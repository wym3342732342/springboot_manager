package club.maddm;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author King
 * @TableLogic 1.0
 * @date 2019/12/10 16:50
 */
@SpringBootApplication
public class ManageApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class);
    }
}
