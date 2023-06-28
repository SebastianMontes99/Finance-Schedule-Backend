package com.finanzas.trabajoFinanzas.controllers;

import com.finanzas.trabajoFinanzas.entities.Users;
import com.finanzas.trabajoFinanzas.services.IUsersService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UsersController {
    private IUsersService usersService;

    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Users>> findAll(){
        try {
            List<Users> users= usersService.getAll();
            if(users.size()>0)
                return new ResponseEntity<>(users, HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> findById(@PathVariable("id")Long id){
        try{
            Optional<Users> users=usersService.getById(id);
            if(!users.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            return new ResponseEntity<>(users.get(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> insertUsers(@Valid @RequestBody Users users){
        try{
            Users usersNew= usersService.save(users);
            return ResponseEntity.status(HttpStatus.CREATED).body(usersNew);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping(value="/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> updateUsers(@PathVariable("id")Long id,@Valid @RequestBody Users users){
        try{
            Optional<Users> usersUpdate= usersService.getById(id);
            if(!usersUpdate.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            users.setId(id);
            usersService.save(users);
            return new ResponseEntity<>(users,HttpStatus.OK);
        }catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Users> deleteUser(@PathVariable("id")Long id){
        try{
            Optional<Users> usersDelete=usersService.getById(id);
            if(!usersDelete.isPresent())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            usersService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
