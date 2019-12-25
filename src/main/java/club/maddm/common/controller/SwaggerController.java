package club.maddm.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/*
 * @author King
 * @version 1.0
 * @date 2019/12/18 09:10
 */
@Controller
public class SwaggerController {
    /**
     * swagger
     * @return
     */
    @GetMapping("/swagger-ui.html")
    public String swagger(){
        return "swagger";
    }
}
