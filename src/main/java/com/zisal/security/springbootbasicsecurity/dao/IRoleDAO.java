package com.zisal.security.springbootbasicsecurity.dao;

import com.zisal.security.springbootbasicsecurity.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created on 4/28/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public interface IRoleDAO extends JpaRepository<Role, Long> {
}
