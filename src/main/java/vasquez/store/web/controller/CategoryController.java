package vasquez.store.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vasquez.store.domain.dto.Category;
import vasquez.store.domain.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/all/active")
    public ResponseEntity<List<Category>> getAllActive() {
        return new ResponseEntity<>(categoryService.getAllActive(), HttpStatus.OK);
    }

    @GetMapping("/all/desactive")
    public ResponseEntity<List<Category>> getAllDesactive() {
        return new ResponseEntity<>(categoryService.getAllDesactive(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable int id) {
        return  categoryService.getById(id)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Category> update(@PathVariable("id") int categoryId, @RequestBody Category category) {
        return categoryService.update(categoryId, category)
                .map(categoryUpdated -> new ResponseEntity<>(categoryUpdated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/patch/{id}")
    public ResponseEntity<Category> update(
            @PathVariable("id") int categoryId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Boolean active
    ){
        Category category = new Category();
        if (name != null) {
            category.setName(name);
        }
        if (active != null) {
            category.setActive(active);
        }
        return categoryService.update(categoryId, category)
                .map(categoryUpdated -> new ResponseEntity<>(categoryUpdated, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Category> delete(@PathVariable("id") int categoryId) {
        return categoryService.deleteById(categoryId)
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
