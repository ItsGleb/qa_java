import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTests {

    Feline feline;
    Cat cat;
    @Mock
    Feline felineMock;
    @BeforeEach
    public void setUp() {
        feline = new Feline();
        cat = new Cat(feline);
    }

    @Test
    public void getSoundShouldReturnMeow() {
        String actualResult = cat.getSound();
        String expectedResult = "Мяу";
        assertEquals(expectedResult, actualResult, "Cat says \"Meow\"");
    }

    @Test
    public void getFoodShouldReturnAnimalsBirdsFish() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = cat.getFood();
        assertEquals(expectedList, actualList, "Expected list : Animals,Birds,Fish");
    }

    @Test
    public void getFoodShouldCallEatMeatMethod() throws Exception{
        Cat cat = new Cat(felineMock);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedList);
        List<String> actualList = cat.getFood();
        Mockito.verify(felineMock).eatMeat();
    }
}
