package json.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: ssm-json
 * @description: test
 * @author: dongwei
 * @create: 2019-02-27 13:42
 **/
@Controller
@RequestMapping("/test/")
public class test {

    @ResponseBody
    @RequestMapping(value = "1",method = RequestMethod.POST)
    public JSONObject get(){
        Map<String,Object> map = new HashMap<>();
        map.put( "1",2 );
        return new JSONObject( map );
    }
}
