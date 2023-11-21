package com.example.newsarticle.Controller;

import com.example.newsarticle.Model.NewsArticleModel;
import com.example.newsarticle.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/article")
@RequiredArgsConstructor
public class NewsArticleController {
       private final NewsArticleService newsArticleService;
@GetMapping("/get")
       public ResponseEntity getNewsArticle(){
    ArrayList<NewsArticleModel> Articles=newsArticleService.getArticle();
           return ResponseEntity.status(HttpStatus.OK).body(Articles);
       }
       @PostMapping("/add")
       public ResponseEntity addArticle(@RequestBody @Valid NewsArticleModel article, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        newsArticleService.addArticle(article);
        return ResponseEntity.status(HttpStatus.OK).body("article added");
       }
       @PutMapping("/update/{id}")
       public ResponseEntity updateArticle(@RequestBody @Valid NewsArticleModel article,@PathVariable String id,Errors errors){
    if(errors.hasErrors()){
        String message=errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    } boolean isUpdated=newsArticleService.updateArticle(id,article);
        if(isUpdated){
            return ResponseEntity.status(HttpStatus.OK).body("article updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
       }
    @GetMapping("/search/{category}")
    public ResponseEntity search(@PathVariable String category){
    ArrayList Articless=newsArticleService.searchCategory(category);
    return ResponseEntity.status(HttpStatus.OK).body(Articless);
    }
    @PutMapping("/publish")
    public ResponseEntity published(){
    newsArticleService.publish();
    return ResponseEntity.status(HttpStatus.OK).body("published successfully");
    }
    @GetMapping("/allPublished")
    public ResponseEntity allPublished(){
    ArrayList published=newsArticleService.allpublish();
    return ResponseEntity.status(HttpStatus.OK).body(published);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable String id){
        boolean isRemoved=newsArticleService.deletArticle(id);
        if(isRemoved)
        {
            return ResponseEntity.status(HttpStatus.OK).body("news article deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
}
