package tomcat_example.component;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    private AtomicInteger count = new AtomicInteger(1);

    {
        Product product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Apple");
        product.setCost(35);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Carrot");
        product.setCost(35);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Banana");
        product.setCost(35);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Watermelon");
        product.setCost(35);
        products.add(product);
        product = new Product();
        product.setId(count.getAndIncrement());
        product.setName("Grape");
        product.setCost(35);
        products.add(product);
    }


    public Product findById(int id){
        return products.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
    }

    public List<Product> findAll(){
        return products;
    }

    public void add(Product product){
        products.add(product);
    }
}
