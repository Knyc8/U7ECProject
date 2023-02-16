public class ClientRunner {
    public static void main(String[] args) {
        Address add = new Address("1313", "Mockingbird Lane", null, "Springfield", "MO", "65123");
        System.out.println(add);
        Address add2 = new Address(add);
        System.out.println(add2);
        Address add3 = new Address(add2.toString());
        System.out.println(add3);
    }
}
