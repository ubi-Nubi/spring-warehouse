package nl.averageflow.springwarehouse.domain.article;

import nl.averageflow.springwarehouse.domain.article.model.Article;
import nl.averageflow.springwarehouse.domain.article.dto.AddArticlesRequest;
import nl.averageflow.springwarehouse.domain.article.dto.EditArticleRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public final class ArticleController {
    private final ArticleServiceContract articleService;

    public ArticleController(final ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/api/articles")
    public Page<Article> getArticles(final Pageable pageable) {
        return this.articleService.getArticles(pageable);
    }

    @GetMapping("/api/articles/{uid}")
    public Optional<Article> getArticle(@PathVariable final UUID uid) {
        return this.articleService.getArticleByUid(uid);
    }

    @PostMapping("/api/articles")
    public void addArticles(@RequestBody final AddArticlesRequest request) {
        this.articleService.addArticles(request.inventory());
    }

    @PatchMapping("/api/articles/{uid}")
    public Article editArticle(@PathVariable final UUID uid, @RequestBody final EditArticleRequest request) {
        return this.articleService.editArticle(uid, request);
    }

    @DeleteMapping("/api/articles/{uid}")
    public void deleteArticle(@PathVariable final UUID uid) {
        this.articleService.deleteArticleByUid(uid);
    }
}
