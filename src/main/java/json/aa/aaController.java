package json.aa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 或 on 2018/4/29.
 */
@Controller
@RequestMapping("")
public class aaController {
    @RequestMapping("aa")
    public String aa(){
        return "aa";
    }



}
