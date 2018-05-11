package com.zisal.security.springbootbasicsecurity.service;

import com.zisal.security.springbootbasicsecurity.dao.IUserDAO;
import com.zisal.security.springbootbasicsecurity.entity.CustomUserDetails;
import com.zisal.security.springbootbasicsecurity.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created on 5/2/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> optionalUser = userDAO.findByCode(s);
        optionalUser.orElseThrow(() -> new UsernameNotFoundException("User Name Not Found"));
        return optionalUser.map(CustomUserDetails::new).get();
    }
}
