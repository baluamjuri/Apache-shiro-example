package org.balu.learn.shiro.config;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.PersistenceException;

import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.balu.learn.shiro.dao.UserRepository;
import org.balu.learn.shiro.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomJdbcRealm extends JdbcRealm {

	@Autowired
	private UserRepository userRepository;
	
	@Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        User user = (User) principalCollection.getPrimaryPrincipal();
        List<String> stringRoles = user.getRoles()
							        	.stream()
							        	.map(role->role.getRole())
							        	.collect(Collectors.toList());
        
        List<String> stringPermissions = user.getRoles()
								        	.stream()
								        	.map(role->role.getPermisssions())
								        	.flatMap(List::stream)
								        	.map(permission->permission.getPermission())
								        	.distinct()
								        	.collect(Collectors.toList());
        	
        authorizationInfo.addRoles(stringRoles); 
        authorizationInfo.addStringPermissions(stringPermissions);
        
        
        return authorizationInfo;
    }

	@Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String username = upToken.getUsername();

        if (username == null) {
            throw new AccountException("UserName is required");
        }

        User user = null;
        try {
            user = userRepository.findById(username).get();
            if (user == null) {
                throw new UnknownAccountException("No account found for userName [" + username + "]");
            }
        } catch (PersistenceException e) {
            final String message = "There was a SQL error while authenticating userName [" + username + "]";
            // Rethrow any SQL errors as an authentication exception
            throw new AuthenticationException(message, e);
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
//                ByteSource.Util.bytes(user.getSalt()),
                getName()
        );
        return authenticationInfo;
    }
	 
	@Override
    public boolean supports(AuthenticationToken token) {
        return token.getClass().isAssignableFrom(UsernamePasswordToken.class);
    }

/*	@Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        hashedCredentialsMatcher.setHashIterations(1024);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }*/
}
