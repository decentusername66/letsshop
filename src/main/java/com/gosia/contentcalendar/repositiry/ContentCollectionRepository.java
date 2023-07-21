package com.gosia.contentcalendar.repositiry;

import com.gosia.contentcalendar.model.Content;
import com.gosia.contentcalendar.model.Status;
import com.gosia.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> content = new ArrayList<>();

    public  ContentCollectionRepository() {

    }

    public List<Content> findAll() {
        return content;
    }

    public Optional<Content> findById(Integer id) {
        return content.stream().filter(c->c.id().equals(id)).findFirst();
    }

@PostConstruct
    private void init(){
    Content c = new Content(
            1,
            "My first Post",
            "Well, it is, what it is.",
            Status.IDEA, Type.ARTICLE,
            LocalDateTime.now(),
            null,
            "");
        content.add(c);
}

}
