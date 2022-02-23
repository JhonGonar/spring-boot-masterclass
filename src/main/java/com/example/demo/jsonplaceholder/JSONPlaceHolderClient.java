package com.example.demo.jsonplaceholder;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        value = "jsonplaceholder",
        url = "https://jsonplaceholder.typicode.com" //fake api
)
public interface JSONPlaceHolderClient {

    @GetMapping("/posts")
    List<Post> getPosts();

    @GetMapping("/posts/{postId}")
    Post getSingularPost(@PathVariable("postId") Integer id);
}
