import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product item1 = new Product(20, "фалафель", 250);

    @Test
    public void shouldRemoveByIdNonexistentElement() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-100);
        });
    }

    @Test
    public void shouldRemoveByIdOneProduct() {
        ShopRepository repo = new ShopRepository();
        repo.add(item1);
        repo.remove(20);

        Product[] expected = new Product[]{};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(actual, expected);
    }
}
