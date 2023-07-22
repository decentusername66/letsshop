package com.gosia.contentcalendar.controller;

import com.gosia.contentcalendar.model.Content;
import com.gosia.contentcalendar.repositiry.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    @Autowired //don't need with one public constructor; implicit;
    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")//empty cuz @RequestMapping already has an address
    public List<Content> findAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id) {       //@PathVariable assigns whats in the path ({id}) to the argument name;
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@RequestBody Content content) {
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public void update(@RequestBody Content content, @PathVariable Integer id) {
        if (!repository.existById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.save(content);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Integer id) {
        repository.delete(id);
    }

}
