package linilq.shop.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import linilq.shop.bean.database.SysUser;
import linilq.shop.service.SysUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @author lizhijian
 * @description
 * @date 2019/5/13
 */
public class CustomizeRealm extends AuthorizingRealm {

    private SysUserService sysUserService;

    public SysUserService getSysUserService() {
        return sysUserService;
    }

    public void setSysUserService(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    /**
     * 鉴权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 身份验证
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String password = new String((char[]) token.getCredentials());
        String userName = (String) token.getPrincipal();
        SimpleAuthenticationInfo simpleAuthenticationInfo = null;

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        SysUser tcUser = sysUserService.selectOne(wrapper);

        if (tcUser == null) {
            throw new UnknownAccountException();
        }


        if (userName.equals("linilq")) {
            simpleAuthenticationInfo = new SimpleAuthenticationInfo(userName, password, getName());
        }
        return simpleAuthenticationInfo;
    }
}
