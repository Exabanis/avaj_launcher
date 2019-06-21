public class Main {
    public static void main(String[] args) {
        Aircraft b1 = new Aircraft("B1", null);
        System.out.println(b1.id + " " +b1.name);
        Aircraft b3 = new Aircraft("B3", null);
        System.out.println(b3.id + " " +b3.name);
        Aircraft b4 = new Aircraft("B4", null);
        System.out.println(b4.id + " " +b4.name);
        Aircraft b2 = new Aircraft("B2", null);
        System.out.println(b2.id + " " +b2.name);
        printf("hello world");
    }

    public static void printf(String mes){
        System.out.println(mes);
        String[] arr = null;
        main(arr);
    }
}
