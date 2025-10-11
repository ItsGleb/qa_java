import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class FelineTests {

    Feline feline;
    @Spy
    Feline felineSpy;
    @BeforeEach
    public void setup () {
        feline = new Feline();
    }

    @Test
    public void getFamilyShouldReturnFeline(){
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult,actualResult,"Feline.getFamily() should return \"Кошачьи\"");
    }
    @Test
    public void eatMeatShouldReturnAnimalsBirdsFish() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = feline.eatMeat();
        assertEquals(expectedList,actualList,"Expected list : Animals,Birds,Fish");
    }
    @Test
    public void getKittensShouldReturnOne(){
        int actual = felineSpy.getKittens();
        Mockito.verify(felineSpy,Mockito.times(1)).getKittens();
    }
    @Test
    public void getKittensShouldReturnKittensCount(){
        int expected = 4;
        int actual = felineSpy.getKittens(expected);
        assertEquals(expected,actual," getKittens(int int) should return the transmitted value");
    }
}
