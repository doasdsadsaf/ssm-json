package json.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @program: ssm-json
 * @description: MyRealm
 * @author: dongwei
 * @create: 2019-04-15 23:34
 **/
public class MyRealm extends AuthorizingRealm {

    /**
     * 授权方法
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection collection) {
        return null;
    }

    // 认证方法
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        // 通过token令牌 获取用户账号信息
        String username = (String) token.getPrincipal();
        //根据用户名从数据库中查询用户密码
        // 省略数据库操作
        String password = "admin";
        if(password == null || "".equals(password)){
            return null;
        }
        // 把用户名,密码,域简写类名封装到对象传出去
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo( username, password, "myRealm" );
        return info;
    }
}
