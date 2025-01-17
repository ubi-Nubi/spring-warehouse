package nl.averageflow.springwarehouse.domain.category;

import nl.averageflow.springwarehouse.domain.category.dto.AddCategoriesRequest;
import nl.averageflow.springwarehouse.domain.category.dto.EditCategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin
public class CategoryController {

    private final CategoryServiceContract categoryService;

    public CategoryController(final CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/api/categories")
    public Page<Category> getCategories(final Pageable pageable) {
        return this.categoryService.getCategories(pageable);
    }

    @GetMapping("/api/categories/{uid}")
    public Optional<Category> getCategory(@PathVariable final UUID uid) {
        return this.categoryService.getCategoryByUid(uid);
    }

    @PostMapping("/api/categories")
    public void addCategories(@RequestBody final AddCategoriesRequest request) {
        this.categoryService.addCategories(request.items());
    }

    @PatchMapping("/api/categories/{uid}")
    public Category editCategory(@PathVariable final UUID uid, @RequestBody final EditCategoryRequest request) {
        return this.categoryService.editCategory(uid, request);
    }

    @DeleteMapping("/api/categories/{uid}")
    public void deleteCategory(@PathVariable final UUID uid) {
        this.categoryService.deleteCategoryByUid(uid);
    }
}
