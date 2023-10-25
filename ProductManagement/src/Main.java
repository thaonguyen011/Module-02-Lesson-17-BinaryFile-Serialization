import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "A", 1000, "Apple", "good"));
        products.add(new Product(2, "B", 1000, "Samsung", "good"));
        products.add(new Product(3, "C", 2000, "Oppo", "medium"));

        System.out.println(products);
        writeProductList("src/products.txt", products);
        System.out.println(readProductList("src/products.txt"));

        writeProductList("src/products1.txt", products);
        System.out.println(readProductList("src/products1.txt"));

    }



    private static void writeProductList(String filePath, List<Product> list) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

            fos.close();
            oos.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Product> readProductList(String filePath) {
        List<Product> productList = new ArrayList<>();

        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            productList = (List <Product>) ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return productList;
    }
}