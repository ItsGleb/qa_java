import com.example.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTests {
    Animal animal;

    @BeforeEach
    public void setUp() {
        animal = new Animal();
    }

    @Test
    public void getFamilyShouldReturnSeveralFamiliesAsString() {
        String actualResult = animal.getFamily();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expectedResult, actualResult, "The list of families is different");
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        String expectedException = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            animal.getFood("Unknown");
        } catch (Exception exception) {
            assertEquals(expectedException, exception.getMessage());
        }
    }

    @ParameterizedTest
    @CsvSource({
            "Травоядное, Трава|Различные растения",
            "Хищник, Животные|Птицы|Рыба"
    })
    public void getFoodReturnsCorrectFood(String animalKind, String expectedFood) throws Exception {
        List<String> expectedFoodList = List.of(expectedFood.split("\\|"));
        List<String> actualFoodList = animal.getFood(animalKind);
        assertEquals(expectedFoodList,actualFoodList,"Expected list : Animals,Birds,Fish");
    }
}



