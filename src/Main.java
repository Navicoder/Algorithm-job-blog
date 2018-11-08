public class Main {

    public static void main(String[] args) {
        int a = 9;
        int aa = add(a);

        System.out.println(a);
        System.out.println(aa);


    }

    private static int add(int a) {
        a+=100;
        return a;
    }
}
