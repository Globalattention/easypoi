import com.baizhi.my.Animal;
import org.junit.Test;

public class TestPOI {
    @Test
    public void name() {
        System.out.println("miaoyi hello");
        Animal animal = new Animal();
        animal.setId("1");
        animal.setName("可爱的猫咪");
        System.out.println(animal);

    }
}
