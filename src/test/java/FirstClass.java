import org.testng.annotations.Test;

public class FirstClass {

    @Test
    public void test00001() {
        System.out.println("This will be printed");
    }

    @Test
    public void test0002() {
        int myNumber = 5;

        System.out.println(myNumber);
    }


    @Test
    public void test0003() {

        String messageOne = new String("Who let the dogs out?");

        String messageTwo = "Who who who who!";

        String completeMessage = messageOne + messageTwo;

        System.out.println(completeMessage);
    }

    @Test
    public void test004() {
        int num = 5;
        String message = "I have " + num + " cookies";

        System.out.println(message);
    }

    @Test
    public void test005() {
        boolean toBe = false;

        boolean b = toBe || !toBe;
        if (b) {
            System.out.println(toBe);
        }

        int children = 0;


        int a = 0;
        b = true;
        boolean c = false;
        //The following line will give an error
        System.out.println(a);
    }

    //TODO: change to accept parameters so it will always print correct message
    @Test
    public void test006() {
        int a = 5;

        if (a == 5) {
            System.out.println("Ohhh! So a is 4!");
        } else {
            System.out.println("A IS NOT EQUAL TO 4");
        }
    }

    public void printAllMembersOfArray(int[] arrayParameter) {
        for (int i = 0; i < arrayParameter.length; i++) {
            int currentElement = arrayParameter[i];
            System.out.println(currentElement);
        }
    }

    public void printAllMembersOfArrayE(int[] arrayParameter) {
        for (int eachMember : arrayParameter) {
            System.out.println(eachMember);
        }
    }

    @Test
    public void test007() {
        int[] input = {1, 9, 9, 5};
        printAllMembersOfArrayE(input);
    }


    @Test
    public void testPrintEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println(i);
        }
    }

    @Test
    public void printHelloAtEvenNumbers() {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) System.out.println("hello world");
        }
    }

    //Swap two numbers in an array
    //1. create an input array
    //2. create a method with int[] parameter
    //3. new method will also take indexes of L and R elements
    //4. use indexes R and L and respective elements will be swapped with each other
    //5. print out final version of the array
    @Test
    public void test_swapNumbers() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int indexL = 0;
        int indexR = 1;

        swap(input, indexL, indexR);
        printAllMembersOfArray(input);
    }

    @Test
    public void test_swap_Exception() {
        int[] input = {1, 2, 3, 4, 5, 6};
        int indexL = -1;
        int indexR = 1;

        checkInputs(input, indexL, indexR);
        swap(input, indexL, indexR);
        printAllMembersOfArray(input);
    }

    //TODO: add checks for input array
    private void checkInputs(int[] input, int indexL, int indexR) {
        if (indexL >= 0 && indexL < input.length && indexR >= 0 && indexR < input.length) {
            System.out.println("Inputs are OK");
        } else {
            throw new AssertionError("Inputs are NOT OK: indexL=" + indexL + ", indexR=" + indexR);
        }
    }

    private void swap(int[] input, int indexL, int indexR) {
        int temporaryElement = 0;
        temporaryElement = input[indexL];
        input[indexL] = input[indexR];
        input[indexR] = temporaryElement;
    }

    //TODO: break down into sub-steps (external methods), `letter` should be a parameter as well
    @Test
    public void testCountLetters() {
        String input = "hello world";
        int result = 0;

        char[] charArray = input.toCharArray();

        for (char eachChar : charArray) {
            if (eachChar == 'l') result++;
        }
        System.out.println(result);
    }

}
