package edu.hw4;

import edu.hw4.animal.Animal;
import edu.hw4.animal.Sex;
import edu.hw4.animal.Type;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task13Test {
    @Test
    void toLostOfTwoWordsInName() {
        List<Animal> testCase = new LinkedList<>();
        Collections.addAll(testCase,
            new Animal("qwerty11 qwerty V", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 30, 70, true),
            new Animal("qwerty e", Type.FISH, Sex.F, 0, 41, 50, false),
            new Animal("qwerty3333", Type.BIRD, Sex.F, 0, 41, 4, false)
        );
        List<Animal> referent = new LinkedList<>();
        Collections.addAll(referent,
            new Animal("qwerty11 qwerty V", Type.CAT, Sex.M, 1, 101, 3, true),
            new Animal("qwerty222 qw X", Type.DOG, Sex.F, 4, 30, 70, true)
        );
        assertEquals(referent, Task13.toLostOfTwoWordsInName(testCase));
    }
}
