package se.jensenyh.javacourse.saltmerch.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.jensenyh.javacourse.saltmerch.backend.model.Product;
import se.jensenyh.javacourse.saltmerch.backend.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository proDb;

    public List<Product> getAllProducts(){

        return proDb.selectAll();
    }
    public List<Product> selectAllOfCategoryHats(){
        return proDb.selectAllOfCategory("hats");
    }
    public List<Product> selectAllOfCategoryBags(){
        return proDb.selectAllOfCategory("bags");
    }
    public List<Product> selectAllOfCategoryJackets(){
        return proDb.selectAllOfCategory("jackets");
    }
    public List<Product> selectAllOfCategoryTshirts(){
        return proDb.selectAllOfCategory("tShirts");
    }
    public Object selectProductById(int id){
        return proDb.getEntireProduct(id);
    }


}
