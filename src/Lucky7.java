public class Lucky7 {
    public static void main(String[] args) {
        System.out.println("Tervetuloa Lucky7-peliin!");

        int money = 5;

        while (money > 0) {
            money--;

            int n1 = (int)(Math.random() * 10) + 1;
            int n2 = (int)(Math.random() * 10) + 1;
            int n3 = (int)(Math.random() * 10) + 1;

            System.out.println("\nArvotut numerot: " + n1 + ", " + n2 + ", " + n3);

            int sevens = 0;
            if (n1 == 7) sevens++;
            if (n2 == 7) sevens++;
            if (n3 == 7) sevens++;

            if (sevens == 3) {
                System.out.println("Kaikki kolme seiskaa! Saat +10 rahaa!");
                money += 10;
            } else if (sevens == 2) {
                System.out.println("Kaksi seiskaa! Saat +5 rahaa!");
                money += 5;
            } else if (sevens == 1) {
                System.out.println("Yksi seiska! Saat +3 rahaa!");
                money += 3;
            } else {
                System.out.println("Ei yhtään seiskaa. Hävisit tämän kierroksen.");
            }

            System.out.println("Rahaa jäljellä: " + money);
        }

        System.out.println("Rahat loppuivat. Peli päättyy.");
    }
}

