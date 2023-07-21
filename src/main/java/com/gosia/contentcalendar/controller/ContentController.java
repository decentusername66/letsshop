package com.gosia.contentcalendar.controller;

import com.gosia.contentcalendar.model.Content;
import com.gosia.contentcalendar.repositiry.ContentCollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/content")
public class ContentController {

    private final ContentCollectionRepository repository;

    @Autowired //don't need with one public constructor; implicit;
    public ContentController(ContentCollectionRepository repository){
        this.repository = repository;
    }

    @GetMapping("")//empty cuz @RequestMapping already has an address
    public List<Content> findAll(){
        return repository.findAll();
    }

}
