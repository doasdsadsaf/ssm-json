package json.demo.test;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * @program: ssm-json
 * @description: ShiroTest
 * @author: dongwei
 * @create: 2019-04-15 23:04
 **/

public class ShiroTest {

    /**
     * 测试 shiro 校验配置文件账号密码
     */
    @Test
    public void loginTest() {
        //认证操作
        //加载资源文件
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new
                IniSecurityManagerFactory
                ("classpath:shiro/shiro.ini");
        //创建安全管理器
        org.apache.shiro.mgt.SecurityManager securityManager =
                factory.getInstance();
        //把安全管理器设置到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //通过安全工具类创建subject主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建用户认证用的令牌
        UsernamePasswordToken token = new
                UsernamePasswordToken("admin", "admin");
        try {
            //通过subject
            subject.login(token);
            System.out.println("通过验证");
        } catch (Exception e) {
            System.out.println("验证失败");
        }

        // 判断认证结果
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        // 退出系统
        subject.logout();
    }

    // 模拟真实数据库操作
    @Test
    public void testRealm() {
        //认证操作
        //加载资源文件
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new
                IniSecurityManagerFactory
                ("classpath:shiro/shiro-realm.ini");
        //创建安全管理器
        org.apache.shiro.mgt.SecurityManager securityManager =
                factory.getInstance();
        //把安全管理器设置到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //通过安全工具类创建subject主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建用户认证用的令牌
        UsernamePasswordToken token = new
                UsernamePasswordToken("admin", "admin");
        try {
            //通过subject
            subject.login(token);
            System.out.println("通过验证");
        } catch (Exception e) {
            System.out.println("验证失败");
        }

        // 判断认证结果
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        // 退出系统
        subject.logout();
    }


    /**
     * 测试shiro MD5和sha加密算法
     */
    @Test
    public void testMd5() {
        String password = "admin";
        String salt = "admin";
        int times = 1;
        //带参构造生成md5加密(原始密码,盐值,散列次数)
        Md5Hash md = new Md5Hash(password, salt, times);
        System.out.println(md);
        //指定MD5加密算法(加密方式,原始密码,盐值,散列次数)
        SimpleHash sh = new SimpleHash("md5", password, salt, times);
        System.out.println(sh);
    }

    /**
     * 模拟真实登录校验MD5
     */
    @Test
    public void testTrueMd5() {
        //认证操作
        //加载资源文件
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new
                IniSecurityManagerFactory
                ("classpath:shiro/shiro-realm-md5.ini");
        //创建安全管理器
        org.apache.shiro.mgt.SecurityManager securityManager =
                factory.getInstance();
        //把安全管理器设置到SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        //通过安全工具类创建subject主体对象
        Subject subject = SecurityUtils.getSubject();
        //创建用户认证用的令牌
        UsernamePasswordToken token = new
                UsernamePasswordToken("admin", "admin");
        try {
            //通过subject
            subject.login(token);
            System.out.println("通过验证");
        } catch (Exception e) {
            System.out.println("验证失败");
        }

        // 判断认证结果
        boolean authenticated = subject.isAuthenticated();
        System.out.println(authenticated);
        // 退出系统
        subject.logout();
    }

}