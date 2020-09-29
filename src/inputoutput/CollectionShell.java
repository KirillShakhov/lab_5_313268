package inputoutput;

import classes.Product;

import java.util.List;

public interface CollectionShell {

    void addNewProduct(Product product);
    Product getById(Integer id);
    void removeProductById(Integer id);
    void clearAll();
    List<Product> getProductList();
    void sort();
    String getInfo();
    boolean isEmpty();

}
