package com.zisal.security.springbootbasicsecurity.dao;


import com.zisal.security.springbootbasicsecurity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created on 4/23/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IUserDAO extends JpaRepository<User, Long> {

    Optional<User> findByCode(String p_Code);
}
