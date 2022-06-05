package learn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import learn.entity.Product;
import learn.repository.ProductRepository;

@Controller
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository productRepo;
    
    @GetMapping
    @ResponseBody
    public List<HashMap<String, Object>> index() {
        List<Product> products = this.productRepo.findAll();
        List<HashMap<String, Object>> response = new ArrayList<>();
        products.forEach((product) -> {
            HashMap<String, Object> hm = new HashMap<>();
            hm.put("id", product.getId());
            hm.put("name", product.getName());
            hm.put("price", product.getPrice());
            hm.put("category", product.getCategory());
            response.add(hm);
        });

        return response;
    }

}
