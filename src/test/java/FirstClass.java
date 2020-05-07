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

    @Test
    public void test007() {
        int[] arrayOfIntegers = {1, 9, 9, 5};

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            int currentElement = arrayOfIntegers[i];
            System.out.println(currentElement);
        }
    }
}
