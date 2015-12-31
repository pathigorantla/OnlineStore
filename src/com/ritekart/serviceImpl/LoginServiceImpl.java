package com.ritekart.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ritekart.dao.LoginDAO;
import com.ritekart.daoImpl.LoginDAOImpl;
import com.ritekart.model.AppUser;
import com.ritekart.model.UserRole;

/**
 * This class gets the appuser information from the database and 
 * populates the "org.springframework.security.core.userdetails.User" type object for appuser.
 *
 * @author Bikshapathi Gorantla
 */
@Service("loginServiceImpl")
public class LoginServiceImpl implements UserDetailsService {
	private  final Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private LoginDAO loginDAO;
	/**
     * @see UserDetailsService#loadUserByUsername(String)
     */
	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		if(!userName.equals("bhargav")){
            throw new UsernameNotFoundException(userName + " not found");
        }
         
        //creating dummy user details, should do JDBC operations
        return new UserDetails() {
             
            private static final long serialVersionUID = 2059202961588104658L;
 
            @Override
            public boolean isEnabled() {
                return true;
            }
             
            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }
             
            @Override
            public boolean isAccountNonLocked() {
                return true;
            }
             
            @Override
            public boolean isAccountNonExpired() {
                return true;
            }
             
            @Override
            public String getUsername() {
                return userName;
            }
             
            @Override
            public String getPassword() {
                return "bhargav123";
            }
             
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
                auths.add(new SimpleGrantedAuthority("ROLE_USER"));
                return auths;
            }
        };
		/*AppUser user = (AppUser) loginDAO.findUserByUserName(userName);
		List<SimpleGrantedAuthority> authorities = buildUserAuthority((Set<UserRole>) user.getUserRoles());
		return buildUserForAuthentication(user,authorities);*/
	}
	 private  List<SimpleGrantedAuthority> buildUserAuthority(Set<UserRole> UserRoles) {
	        Set<SimpleGrantedAuthority> setAuths = new HashSet<SimpleGrantedAuthority>();
	        // Build user's authorities
	        for (UserRole userRole : UserRoles) {
	        	logger.debug("****" + userRole.getUserRole());
	            setAuths.add(new SimpleGrantedAuthority(userRole.getUserRole()));
	        }
	        List<SimpleGrantedAuthority> Result = new ArrayList<SimpleGrantedAuthority>(setAuths);
	        return Result;
	    }
	 private User buildUserForAuthentication(AppUser user, List<SimpleGrantedAuthority> authorities) {
	        return new User(user.getUserName(), user.getPassword(), true, true, true, true, authorities);
	    }
}
