public class Lucky7 {
    public static void main(String[] args) {
        System.out.println("Tervetuloa Lucky7-peliin!");

        int n1 = (int)(Math.random() * 10) + 1;
        int n2 = (int)(Math.random() * 10) + 1;
        int n3 = (int)(Math.random() * 10) + 1;

        System.out.println("\nArvotut numerot: " + n1 + ", " + n2 + ", " + n3);
    }
}
