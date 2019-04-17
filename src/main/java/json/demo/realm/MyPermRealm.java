package json.demo.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ssm-json
 * @description: MyPermRealm
 * @author: dongwei
 * @create: 2019-04-16 22:34
 **/
public class MyPermRealm extends AuthorizingRealm {

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        // 获取用户名
        String username = principal.getPrimaryPrincipal().toString();
        System.out.println(username);
        List<String> perms = new ArrayList<>();
        //根据用户名从数据库中获取角色信息
        String[] roles = {"role1","role2"};
        //遍历角色,根据角色获取每一个角色具有权限信息
        for(String role : roles){
            System.out.println(role);
            // 获取用户权限,存入到列表
            perms.add("user:create");
            perms.add("user.delete");
            perms.add("user.update");
        }
        SimpleAuthorizationInfo saif = new SimpleAuthorizationInfo();
        saif.addStringPermissions(perms);
        return saif;
    }

    /**
     * 认证方法
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = token.getPrincipal().toString();
        //根据用户从数据库获取用户密码
        String password = "admin";
        // 把用户名和密码封装到AuthenticationInfo的实现类中
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, "authRealm");


        return info;
    }
}
