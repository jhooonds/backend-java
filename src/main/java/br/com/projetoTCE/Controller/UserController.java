/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projetoTCE.Controller;

import br.com.projetoTCE.repository.UserRepository;
import br.com.users.models.User;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonatan
 */
@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable(name = "id") Long idUser) {
        System.out.println(idUser);
        if (idUser == null) {
            return ResponseEntity.badRequest().body("Favor informar um ID valido");
        }

        User user = userRepo.getOne(idUser);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(user);

    }

    @RequestMapping("/")
    public ResponseEntity create(@Valid @RequestBody User user) {
        User createdUser = userRepo.save(user);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @RequestBody User userDTO, Errors errors, @PathVariable(name = "idUser") Long idUser) {

        if (idUser == null) {
            return ResponseEntity.badRequest().body("Por favor informe um Id válido");
        }
        User user = userRepo.getOne(idUser);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        user.setName(userDTO.getName());
        user.setSurname(userDTO.getSurname());
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        user.setRegister_date(userDTO.getRegister_date());
        user.setPhone(userDTO.getPhone());

        try {
            User updatedUser = userRepo.save(user);
            return ResponseEntity.ok(updatedUser);
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body("CPF ou Email, já estão em uso");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ocorreu um erro na solicitação, favor tentar novamente");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity del(@PathVariable(name = "id") Long idUser) {

        if (idUser == null) {
            return ResponseEntity.badRequest().body("Favor informar um ID valido");
        }

        User user = userRepo.getOne(idUser);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            userRepo.delete(user);
            return ResponseEntity.ok("Usuário excluido com sucesso");
        } catch (DataIntegrityViolationException ex) {
            return ResponseEntity.badRequest().body("O CPF ou E-mail informado esta já esta em uso");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Ocorreu um erro na solicitação, favor tentar novamente");
        }

    }

}
