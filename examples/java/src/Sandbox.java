public class Sandbox {
    public static void main(String[] args) {
        int number = 12345;
        int number2 = 432;
        System.out.println(fun1(number, number2));
        if (fun2()) {
            number = 40;
        } else {
            number = 50;
        }
        System.out.println(number);
    }

    private static int fun1(int number, int number2) {
        return number + 98765 / number2;
    }

    private static boolean fun2() {
        int n = 20;
        return 4 > n;
    }
}
