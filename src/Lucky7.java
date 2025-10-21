import java.util.Scanner;
import java.text.Normalizer;
import java.util.Locale;

public class Lucky7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tervetuloa Lucky7-peliin!");

        int money = 0;
        while (true) {
            System.out.print("Paljonko rahaa haluat käyttää? ");
            String line = scanner.nextLine().trim();
            try {
                money = Integer.parseInt(line);
                if (money > 0) break;
                System.out.println("Anna positiivinen kokonaisluku.");
            } catch (NumberFormatException e) {
                System.out.println("Anna kokonaisluku (esim. 5).");
            }
        }

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

            if (money <= 0) {
                System.out.println("Rahat loppuivat. Peli päättyy.");
                break;
            }

            String vastausNormalized;
            while (true) {
                System.out.print("Haluatko pelata uudestaan? (Jos kyllä kirjoita 'k', jos ei kirjoita 'e'): ");
                String raw = scanner.nextLine().trim();
                String normalized = Normalizer.normalize(raw, Normalizer.Form.NFD)
                                             .replaceAll("\\p{M}", "")
                                             .toLowerCase(Locale.ROOT);

                if (normalized.equals("kylla") || normalized.equals("k")) {
                    vastausNormalized = "kylla";
                    break;
                } else if (normalized.equals("ei") || normalized.equals("e")) {
                    vastausNormalized = "ei";
                    break;
                } else {
                    System.out.println("Syötä vain 'kyllä' tai 'ei'.");
                }
            }

            if (vastausNormalized.equals("ei")) {
                System.out.println("Peli loppui. Kiitos pelaamisesta!");
                break;
            }
        }

        System.out.println("Kiitos pelaamisesta! Lopullinen rahamäärä: " + money);
        scanner.close();
    }
}
