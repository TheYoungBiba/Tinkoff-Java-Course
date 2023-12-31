package edu.hw3;

import java.util.HashMap;

public class Task1 {
    private Task1() {}

//    Метод который создает экземпляр словаря и заполняет его буквами латинского алфавита из константного массива букв
    private static HashMap<Character, Character> initCipherDictionary() {
        final int englishAlphabetLength = 26;
        final int intOfA = 97;
        final int intOfZ = 123;
        final int shift = 97;
        char[] alphabet = new char[englishAlphabetLength];

        for (int i = intOfA; i < intOfZ; i++) {
            alphabet[i - shift] = ((char) i);
        }

        HashMap<Character, Character> cipherDictionary = new HashMap<>();

        for (int i = 0; i < alphabet.length; i++) {
            cipherDictionary.put(alphabet[i], alphabet[alphabet.length - i - 1]);
        }

        return cipherDictionary;
    }

//    Проверка на то, в каком регистре находится буква
    private static boolean isUpCase(Character letter) {
        return !letter.equals(Character.toLowerCase(letter));
    }

    public static String atbashCipher(String uncipheredStr) {
        HashMap<Character, Character> cipherDictionary = initCipherDictionary();

        StringBuilder cipheredStr = new StringBuilder();

//        Прохожусь по всем символам строки и если символ является буквой опускаю регистр, получаю значение по ключу
//        проверяю в каом регистре была оригинальная буква и добваляю его в строку,
//        если сивол не буква, просто добавляю его в строку
        for (Character letter : uncipheredStr.toCharArray()) {
            if (Character.isLetter(letter)) {
                Character cipheredLetter = cipherDictionary.get(Character.toLowerCase(letter));
                if (isUpCase(letter)) {
                    cipheredLetter = Character.toUpperCase(cipheredLetter);
                }
                cipheredStr.append(cipheredLetter);
            } else {
                cipheredStr.append(letter);
            }
        }

        return cipheredStr.toString();
    }
}
