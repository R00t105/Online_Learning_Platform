package online_learning_platform__rest_api.Service.Category;

import online_learning_platform__rest_api.Entity.Category;
import java.util.List;

public interface CategoryService {

    Category createCategory(Category category);
    Category getCategoryById(int id);
    List<Category> getAllCategories();
    Category updateCategory(int id, Category category);
    void deleteCategory(int id);

}
