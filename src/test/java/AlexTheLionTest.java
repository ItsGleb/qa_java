import com.example.AlexTheLion;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlexTheLionTest {

    AlexTheLion alex;
    Feline feline;
    @BeforeEach
    public void setup() throws Exception {
        alex = new AlexTheLion(feline);
    }
    @Test
    public void getKittensShouldReturnZero(){
        int expected = 0 ;
        int actual = alex.getKittens();
        assertEquals(expected,actual,"The Alex has not a kitten");
    }
    @Test
    public void getFriendsShouldReturnMartyGloriaMelman(){
        List<String> expectedList = List.of("Зебра Марти","Бегемотиха Глория","Жираф Мелман");
        List<String> actualList = alex.getFriends();
        assertEquals(expectedList,actualList,"Leo Alex's Expected Friends : Зебра Марти, Бегемотиха Глория, Жираф Мелман");
    }
    @Test
    public void getPlaceOfLivingReturnNewYorkZoo(){
        String expected = "Нью-Йоркский зоопарк";
        String actual = alex.getPlaceOfLiving();
        assertEquals(expected,actual);
    }
}
