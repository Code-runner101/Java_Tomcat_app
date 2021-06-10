package tomcat_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import tomcat_example.component.Product;
import tomcat_example.component.ProductRepository;
import tomcat_example.config.AppConfig;

import javax.annotation.PostConstruct;

@Controller
@RequestMapping("/product")
public class HomeController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("products", productRepository.findAll());

        model.addAttribute("newProduct", new ProductRepository());
        return "products";
    }

    @PostMapping("/add")
    public String testPostRequest(ProductRepository products, Product product) {
        products.add(product);

        return "redirect:/product";
    }

}
