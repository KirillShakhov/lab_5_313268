package classes;

import inputoutput.CollectionShell;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class ProductCollectionManager implements CollectionShell {
    private HashMap<Integer, Product> coll;
    private LocalDateTime creationDate;

    public ProductCollectionManager(){
        coll = new HashMap<>();
        creationDate = LocalDateTime.now();
    }


    @Override
    public void addNewProduct(Product product) {
        coll.put(product.getId(), product);
    }

    @Override
    public Product getById(Integer id) throws NullPointerException {
        Product returnProduct = coll.get(id);
        if (returnProduct == null){
            throw new NullPointerException();
        }
        return returnProduct;
    }

    @Override
    public void removeProductById(Integer id) throws NullPointerException {
        Product returnProduct = coll.get(id);
        if (returnProduct == null){
            throw new NullPointerException();
        }
        coll.remove(id);
    }

    @Override
    public void clearAll() {
        coll.clear();
    }

    @Override
    public List<Product> getProductList() {
        return new ArrayList<>(coll.values());
    }

    @Override
    public void sort() {
        coll.keySet().stream().sorted(Comparator.comparingInt(x -> x));
    }

    @Override
    public String getInfo() {
        return "Размер коллекции: " + coll.size() + ", тип коллекции: HashMap, дата создания: " + creationDate;
    }

    @Override
    public boolean isEmpty() {
        return coll.isEmpty();
    }
}
