package com.whh.shiro;

import com.whh.bean.pojo.Permission;
import com.whh.bean.pojo.Role;
import com.whh.bean.pojo.User;
import com.whh.dao.PermissionMapper;
import com.whh.dao.RoleMapper;
import com.whh.dao.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author admin
 * @Date: 2018/12/11 17:52
 * @Description:
 */
public class MyShiroRealm extends AuthorizingRealm {


    @Resource
    private UserMapper userMapper;

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 授权
     * 权限信息，包括角色以及权限
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("权限认证--> MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //如果身份认证的时候没有传入User对象，这里只能取到userName
        //也就是SimpleAuthenticationInfo构造的时候第一个参数传递需要User对象
        User user = (User) principals.getPrimaryPrincipal();

        //  根据userId  查询此用户具有多少种角色
//        set  role
        List<Role> roleList = roleMapper.selectByUserId(user.getUserId());
        Set<String> roleSet =roleList.stream().map(Role::getRoleName).collect(Collectors.toSet());
        authorizationInfo.setRoles(roleSet);
//      取出所有 roleid   set  permission
        List<Integer> ids =  roleList.stream().map(Role::getRoleId).collect(Collectors.toList());
        List<Permission> permissionList = permissionMapper.selectBysroleids(ids);
        Set<String> permSet =permissionList.stream().map(Permission::getPerms).collect(Collectors.toSet());
        authorizationInfo.setStringPermissions(permSet);

        return authorizationInfo;
    }

    /**
     * 认证
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("权限认证--> MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String userName = (String) token.getPrincipal();
        //通过username从数据库中查找 User对象.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User user = userMapper.findByUserName(userName);
        System.out.println("----->>user=" + user);
        if (user == null) {
            return null;
        }
        //这里传入的是user对象，比对的是用户名，直接传入用户名也没错，但是在授权部分就需要自己重新从数据库里取权限
        //密码
        //salt=username+salt                  ByteSource.Util.bytes(user.getCredentialsSalt()),
        //realm name
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                getName()
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getUserId());
        return authenticationInfo;

    }
}
