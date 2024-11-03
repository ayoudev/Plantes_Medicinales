package com.pfa.backend.repository;

import com.pfa.backend.entiey.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

}
