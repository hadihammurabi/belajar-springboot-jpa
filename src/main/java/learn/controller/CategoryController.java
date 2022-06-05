package learn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import learn.entity.Category;
import learn.repository.CategoryRepository;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepo;
    
    @GetMapping
    @ResponseBody
    public List<HashMap<String, Object>> index() {
        List<Category> categories = this.categoryRepo.findAll();
        List<HashMap<String, Object>> response = new ArrayList<>();
        categories.forEach((category) -> {
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("id", category.getId());
            hm.put("name", category.getName());
            hm.put("products", category.getProducts());
            response.add(hm);
        });

        return response;
    }

}
