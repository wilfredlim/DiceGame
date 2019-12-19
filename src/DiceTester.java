public class DiceTester {
    public static void main(String[] args) {
        System.out.println("Welcome to the dice simulator.");

        Die d1 = new Die();
        Die d2 = new Die();

        d1.roll();
        d2.roll();

        System.out.println( d1.getFace());
        d1.getFace();


    }
}