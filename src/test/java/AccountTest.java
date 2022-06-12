import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String message;
    private final String name;
    private final boolean expected;

    public AccountTest(String message, String name, boolean expected) {
        this.message = message;
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0} {1}")
    public static Object[][] getData() {
        return new Object[][] {
                {"Длина 12, есть пробел", "Артур Морган", true},
                {"Имя 3 символа", "Ж к", true},
                {"Граничные, 19 символов имя", "Артурррр Морганнннн", true},
                {"Имя без пробела", "АртурМорган", false},
                {"Негативная, 2 символа в имени", "Ви", false},
                {"Негативная, 20 символов в имени", "Артурррр Морганннннн", false},
                {"Пробел в начале имени", " АртурМорган", false},
                {"Пробел в конце имени", "АртурМорган ", false},
                {"Несколько пробеловв имени", "Артур Мо Рган", false},
                {"Пустое имя", "", false},
                {"Проверка на null", null, false}

        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss(name);
        assertEquals(message, expected, actual);
    }
}