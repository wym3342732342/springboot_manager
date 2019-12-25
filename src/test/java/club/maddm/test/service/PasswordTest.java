package club.maddm.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author King
 * @version 1.0
 * @date 2019/12/22 17:16
 */

public class PasswordTest {

    @Test
    public void test() {

        String password = "123456";
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        System.out.println(hashed);

        String hashed2 = BCrypt.hashpw(password, BCrypt.gensalt(12));

        System.out.println(hashed2);

        String candidate = "123456";
        if (BCrypt.checkpw(candidate, hashed)) {
            System.out.println("hashed匹配");
        }else{
            System.out.println("hashed不匹配");
        }

        if (BCrypt.checkpw(candidate, hashed2)) {
            System.out.println("hashed2匹配");
        }else{
            System.out.println("hashed2不匹配");
        }
    }
}
