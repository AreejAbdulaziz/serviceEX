package com.example.newsarticle.Model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class NewsArticleModel {
    @NotNull(message = "id cannot be null!")
    private String id;
    @NotNull(message = "title cannot be null!")
    @Size(max = 100)
    private String title;
    @NotNull(message = "author cannot be null!")
    @Size(min = 5,max = 20,message = "enter size in the range 5-20")
    private String author;
    @NotNull(message = "content cannot be null")
    @Size(min = 201)
    private String content;
    @NotNull(message = "category cannot be null!")
    @Pattern(regexp = "^(politics|sports|technology)$",message = "enter either politics,sports or technology only")
    private String category;
    @NotNull(message = "image URL cannot be null!")
    private String imageUrl;
    @AssertFalse(message = "must be false")
    private boolean isPublished;
    private LocalDate publishDate; //كلاس معينه تعرض لك الوقت الحالي تخلينها تنعرض
}
