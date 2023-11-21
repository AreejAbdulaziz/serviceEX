package com.example.newsarticle.Service;

import com.example.newsarticle.Model.NewsArticleModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NewsArticleService {
    ArrayList<NewsArticleModel>Articles=new ArrayList<>();
    public ArrayList<NewsArticleModel> getArticle(){
    return Articles;
    }
    public void addArticle(NewsArticleModel article){
        Articles.add(article);
    }
    public boolean updateArticle(String id,NewsArticleModel article){
        for(int i=0;i<Articles.size();i++){
            if(Articles.get(i).getId().equals(id)){
                Articles.set(i,article);
                return true;
            }
        }
        return false;
    }
//    public void publish(){
//        ArrayList<NewsArticleModel>published=new ArrayList<>();
//        for(NewsArticleModel n: Articles){
//            if(n.isPublished()==false){
//                n.setPublished(true);
//                n.setPublishDate(LocalDate.now());
//                published.add(n);
//            }
//        }
//    }
public void publish(){
    ArrayList<NewsArticleModel>published=new ArrayList<>();
    for(NewsArticleModel n: Articles){
        if(n.isPublished()){
            System.out.println("good");
        } else {
            n.setPublished(true);
            n.setPublishDate(LocalDate.now());
            published.add(n);
        }
    }
}
//    public ArrayList<NewsArticleModel> searchCategory(String category){
//        ArrayList<NewsArticleModel>Articless=new ArrayList<>();
//        for(int i=0;i<Articles.size();i++){
//            if(Articles.get(i).getCategory().equals(category)){
//                Articless.add(Articles.get(i));
//                return Articless;
//            }
//        }
//        return null;
//    }
    public ArrayList<NewsArticleModel>searchCategory(String category){
        ArrayList<NewsArticleModel>Articless=new ArrayList<>();
        for(NewsArticleModel n:Articles){
            if(n.getCategory().equals(category)){
                Articless.add(n);
            }
        } return Articless;
    }
    public ArrayList<NewsArticleModel> allpublish(){
        ArrayList<NewsArticleModel>published=new ArrayList<>();
        for(NewsArticleModel n: Articles){
            if(n.isPublished()){
                published.add(n);

            }
        } return published;
    }
    public boolean deletArticle(String id){
        for(int i=0;i<Articles.size();i++){
            if(Articles.get(i).getId().equals(id)){
                Articles.remove(i);
                return true;
            }
        }
        return false;
    }
}
