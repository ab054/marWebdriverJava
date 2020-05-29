public class Actor {

    String firstName;
    String lastName;
    double height;
    double weight;
    private int age;

    public Actor(int age, String firstName, String lastName, double height, double weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
    }


    public int getAge() {
        return age;
    }

    void speak() {
        System.out.println("I am speaking");
    }

    void play() {
        System.out.println("I am playing");
    }

    void sing() {
        System.out.println("I am singing");
    }

    String tellName(){
        return firstName;
    }

}
