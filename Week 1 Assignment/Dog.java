package Week1.abstraction;

public class Dog extends Animal {
    public static final String DOG_BARK_SOUND = "Bow Bow";

    // Overrides the makeSound method for sound of dog
    @Override
    void makeSound() {
        System.out.println(DOG_BARK_SOUND);
    }
}
