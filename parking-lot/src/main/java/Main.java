public class Main {
    public static void main(String[] args) {
        String a = "5";
        int x = Integer.valueOf(a);
        System.out.println(((Object)x).getClass().getSimpleName());
    }
}