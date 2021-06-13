package tomcat_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tomcat_example.component.Product;
import tomcat_example.component.ProductRepository;

@Controller
@RequestMapping("/product")
public class HomeController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("products", productRepository.findAll());

        model.addAttribute("newProduct", new Product());
//        model.addAttribute("findId", new Object());
        return "products";
    }

    @PostMapping("/add")
    public String testPostRequest(Product product) {
        productRepository.findAll().add(product);
        return "redirect:/product";
    }

//    @PostMapping("/search")
//    public void searchById(int id) {
//        productRepository.findById(id);
//    }

}
