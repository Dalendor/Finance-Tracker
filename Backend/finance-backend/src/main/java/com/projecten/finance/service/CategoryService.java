package com.projecten.finance.service;

import com.projecten.finance.entity.Category;
import com.projecten.finance.repository.CategoryRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public List<Category> getAll() {
        return repo.findAll();
    }

    public Category getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category create(Category category) {
        return repo.save(category);
    }

    public Category update(Long id, Category updated) {
        Category c = getById(id);
        c.setName(updated.getName());
        c.setColor(updated.getColor());
        return repo.save(c);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}