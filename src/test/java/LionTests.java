import com.example.Cat;
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class LionTests {

    Feline feline;
    Lion lion;
    @Mock
    Feline felineMock;

    @BeforeEach
    public void setup() {
        feline = new Feline();
    }

    @ParameterizedTest
    @CsvSource({
            "Самец,true",
            "Самка,false"
    })
    public void doesHaveManeShouldReturnTrue(String sex, boolean mane) throws Exception {
        lion = new Lion(sex, feline);
        boolean actual = lion.doesHaveMane();
        assertEquals(mane, actual, "The male is expected to have a mane, while the female does not have a mane.");

    }

    @Test
    public void lionConstructorThrowsException() {
        Executable ex = () -> new Lion("Unknown", feline);
        assertThrows(Exception.class, ex);
    }

    @Test
    public void getFoodShouldReturnAnimalsBirdsFish() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = lion.getFood();
        assertEquals(expectedList, actualList, "Expected list : Animals,Birds,Fish");
    }

    @Test
    public void getFoodShouldCallEatMeatMethod() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(felineMock.eatMeat()).thenReturn(expectedList);
        List<String> actualList = lion.getFood();
        Mockito.verify(felineMock).eatMeat();
    }

    @Test
    public void getKittensCallFelineGetKittens() throws Exception {
        Lion lion = new Lion("Самец", felineMock);
        int kittens = lion.getKittens();
        Mockito.verify(felineMock, Mockito.times(1)).getKittens();
    }
}
