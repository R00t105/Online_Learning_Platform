package online_learning_platform__rest_api.Service.Category;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import online_learning_platform__rest_api.Entity.Category;
import online_learning_platform__rest_api.Exception.Category.CategoryNotFoundException;
import online_learning_platform__rest_api.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).
                orElseThrow(() -> new CategoryNotFoundException(id));
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCategory(int id, Category category) {
        Category existCategory = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        existCategory.setName(category.getName());
        categoryRepository.save(existCategory);

        return existCategory;
    }

    @Override
    @Transactional
    public void deleteCategory(int id) {
        if(!categoryRepository.existsById(id))
            throw new CategoryNotFoundException(id);

        categoryRepository.deleteById(id);
    }

}
