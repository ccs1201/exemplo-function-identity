import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class LetraTest {

    private static List<Letra> getLetras() {
        List<Letra> charList = new LinkedList<>();

        for (char ch = 'a'; ch <= 'z'; ch++) {
            charList.add(new Letra(ch));
        }

        return charList;
    }

    private static char transformarEmMaiuscula(Letra letra) {
        return letra.getLetra().toString().toUpperCase().charAt(0);
    }

    @Test
    public void testComFor() {

        Map<Letra, Character> mapLetras = new HashMap<>();

        getLetras().forEach(letra -> mapLetras.put(letra, transformarEmMaiuscula(letra)));

        assertEquals(mapLetras.get(new Letra('a')), Character.valueOf('A'));
        assertEquals(mapLetras.get(new Letra('z')), Character.valueOf('Z'));
    }

    @Test
    public void testComStreamMapIdentity() {

        Map<Letra, Character> mapLetras = getLetras()
                .stream()
                .collect(Collectors.toMap(Function.identity(), LetraTest::transformarEmMaiuscula));

        assertEquals(mapLetras.get(new Letra('a')), Character.valueOf('A'));
        assertEquals(mapLetras.get(new Letra('z')), Character.valueOf('Z'));
    }
}
