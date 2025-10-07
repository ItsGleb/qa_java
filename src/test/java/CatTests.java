import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTests {
    Feline feline;

    @BeforeEach
    public void setUp() {
        feline = new Feline();

    }
    @Test
    public void getSoundShouldReturnMeow() {

        Cat cat = new Cat(feline);
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        assertEquals(actualResult, expectedResult, "Кошка говорит \"Мяу\"");
    }
    @Test
    public void getFoodShouldReturnAnimalsBirdsFish() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = cat.getFood();
        assertEquals(actualList, expectedList, "Expected list : Animals,Birds,Fish");
    }
}
