package com.spring.springdata.controller;

import com.spring.springdata.configuration.BasicConfiguration;
import com.spring.springdata.model.User;
import com.spring.springdata.repository.UserJpaRepository;
import com.spring.springdata.repository.UserPagedJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Value("${author.name:random}")
    private String author;

    @Autowired
    BasicConfiguration basicConfiguration;

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    UserPagedJpaRepository userPagedJpaRepository;

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userJpaRepository.findAll();
    }

    @GetMapping("/{name}")
    public User findByName(@PathVariable final String name) {
        return userJpaRepository.findByName(name);
    }

    @GetMapping("/author")
    public Map<String, String> getAuthorName(){
    Map<String, String> myMap = new HashMap<>();
        myMap.put("Author Name", basicConfiguration.getName());
        myMap.put("Author Salutation", basicConfiguration.getSalutation());
        return myMap;
    }

    @GetMapping("/paged")
    public Page<User> findAllPagedUser(
            @RequestParam(value = "page") final Integer page,
            @RequestParam(value = "size") final Integer size) {

    return userPagedJpaRepository.findAll(PageRequest.of(page, size, Sort.by("name")));
    }

    @GetMapping
    public Optional<User> findById(
            @RequestParam(value = "id") final Long id)
    {
       return userJpaRepository.findById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody @Nullable final User user) {
        userJpaRepository.save(user);
        return userJpaRepository.findByName(user.getName());
    }
}
