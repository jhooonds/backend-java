/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoTCE.repository;

import br.com.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jonat
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
    User findByNameAndUserName(String name, String userName);
    User findByEmail(String email);
    
}
