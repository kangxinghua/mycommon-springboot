package org.mycommon.springboot.config;

import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.mycommon.modules.utils.Encodes;
import org.mycommon.springboot.model.UserModel;
import org.mycommon.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 验证用户登录
 * 
 * @author Administrator
 */
@Component("userRealm")
public class UserRealm extends AuthorizingRealm {
	@Autowired
	private UserService userService;

	public UserRealm() {
		setName("UserRealm");
		// 采用SHA-1加密
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(UserService.HASH_ALGORITHM);
		matcher.setHashIterations(UserService.HASH_INTERATIONS);
		setCredentialsMatcher(matcher);
	}

	//权限资源角色
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		//add Permission Resources
		info.addStringPermissions(userService.findPermissions(username));
		//add Roles String[Set<String> roles]
		//info.setRoles(roles);
		return info;
	}
	
	//登录验证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		UserModel userModel = userService.getUser(usernamePasswordToken.getUsername());
		if (userModel != null) {
//			if (userModel.getStatus() != 1) {
//				throw new LockedAccountException(); // 帐号锁定
//			}
			byte[] salt = Encodes.decodeHex(userModel.getSalt());

			return new SimpleAuthenticationInfo(userModel.getUserName(),
					userModel.getPassword(), ByteSource.Util.bytes(salt), getName());
		} else {
			return null;
		}
	}
}