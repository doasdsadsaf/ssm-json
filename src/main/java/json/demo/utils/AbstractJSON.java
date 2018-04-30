package json.demo.utils;

import java.util.Date;

/**
 * Created by 或 on 2018/4/30.
 */
public class AbstractJSON {
//    响应状态码
    private String code;
//  响应消息
    private String message;
//    时间戳
    private Long time = new Date().getTime();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
