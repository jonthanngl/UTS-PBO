package jawaban3;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LotreBoard game = new LotreBoard();

        System.out.println("Welcome to E-Lottery Gosok");
        game.displayBoard();

        boolean playing = true;

        while (playing) {
            System.out.print("Masukkan tebakan anda (baris dan kolom): ");
            int r = scanner.nextInt();
            int c = scanner.nextInt();

            // Memproses tebakan
            playing = game.guess(r, c);

            // Mengecek kondisi lanjutan
            if (playing) {
                if (game.isGameOver()) {
                    System.out.println("Selamat anda menang");
                    game.revealAll();
                    game.displayBoard();
                    playing = false; // Menghentikan perulangan karena menang
                } else {
                    game.displayBoard();
                }
            } else {
                // Kondisi jika terkena bom (playing menjadi false)
                game.revealAll();
                game.displayBoard();
            }
        }

        scanner.close();
    }
}