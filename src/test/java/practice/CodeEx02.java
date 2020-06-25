package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CodeEx02 {

    //1.
    //2.
    //3.
    //4.
    @Test
    public void test001() {
        int[] input = {1, 2, 3, 4, 5, 6, 7};

        solution(input);
    }

    @Test
    public void test002() {
        int[] input = {0};

        solution(input);
    }

    private void solution(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] % 2 == 0) myPrint(input[i]);
        }

    }

    private void myPrint(int i) {
        System.out.println("hello world");
    }

    //1.
    //2.
    //3.
    //4.
    @Test
    public void test_NumberOfLetters() throws Exception {
        String input = "hello world";
        char character = 'l';

        int numberOfLetters = countLetters(input, character);

        Assert.assertEquals(numberOfLetters, 3);
    }

    private int countLetters(String input, char character) throws Exception {
        int result = 0;

        if (input.isEmpty()) {
            throw new Exception("input is empty");
        }

        for (char eachChar : input.toCharArray()) {
            if (eachChar == character) {
                result++;
            }
        }

        return result;
    }

    @Test
    public void test_NumberOfLetters02() throws Exception {
        String input = "hello world";
        char character = 'h';

        int numberOfLetters = countLetters(input, character);

        Assert.assertEquals(numberOfLetters, 1);
    }

    @Test
    public void test_NumberOfLetters03() throws Exception {
        String input = "hello world";
        char character = 'x';

        int numberOfLetters = countLetters(input, character);

        Assert.assertEquals(numberOfLetters, 0);
    }

    @Test
    public void test_NumberOfLetters04() throws Exception {
        String input = "";
        char character = 'x';

        int numberOfLetters = countLetters(input, character);

        Assert.assertEquals(numberOfLetters, 0);
    }
}
