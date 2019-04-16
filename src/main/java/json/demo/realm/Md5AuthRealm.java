package json.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

/**
 * @program: ssm-json
 * @description: Md5AuthRealm
 * @author: dongwei
 * @create: 2019-04-16 20:49
 **/
public class Md5AuthRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        return null;
    }

    /**
     * 重写认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户输入的 通过token对象获取用户账号,用户自己输入的账号
        String username = token.getPrincipal().toString();
        //查询库的 根据获取到的用户账号查询数据表中对应密码和盐值
        String password = "f6fdffe48c908deb0f4c3bd36c032e72";
        String salt = "admin";
        // 封装到SimpleAuthenticationInfo 实现类对象中
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, ByteSource.Util.bytes(salt), "md5AuthRealm");
        return info;
    }
}
