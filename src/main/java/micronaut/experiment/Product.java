package micronaut.experiment;

public final class Product {
    public String id;
    public String name;
    public Integer price;

    public Product(String i, String n, Integer p) {
        id = i;
        name = n;
        price = p;
    }
}
