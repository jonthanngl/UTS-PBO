package jawaban3;


import java.util.Random;

public class LotreBoard {
    private char[][] board;
    private boolean[][] revealed;
    private int[][] data;
    private int safeCount;

    public LotreBoard() {
        board = new char[4][5];
        revealed = new boolean[4][5];
        data = new int[4][5];
        safeCount = 0;
        generateBoard();
    }

    // Menghasilkan papan dengan 2 bom di posisi acak
    public void generateBoard() {
        // Inisialisasi papan default (semua aman)
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '*';
                revealed[i][j] = false;
                data[i][j] = 0; // 0 merepresentasikan kotak aman
            }
        }

        // Meletakkan 2 bom secara acak
        Random rand = new Random();
        int bombsPlaced = 0;
        while (bombsPlaced < 2) {
            int r = rand.nextInt(4);
            int c = rand.nextInt(5);
            // Pastikan tidak menaruh bom di tempat yang sudah ada bomnya
            if (data[r][c] == 0) {
                data[r][c] = 1; // 1 merepresentasikan bom
                bombsPlaced++;
            }
        }
    }

    // Menampilkan papan saat ini ke layar
    public void displayBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                if (!revealed[i][j]) {
                    System.out.print("* ");
                } else {
                    if (data[i][j] == 1) {
                        System.out.print("X ");
                    } else {
                        System.out.print("0 ");
                    }
                }
            }
            System.out.println();
        }
    }

    // Memproses tebakan pemain
    public boolean guess(int row, int col) {
        // Mencegah error jika input di luar ukuran papan
        if (row < 0 || row >= 4 || col < 0 || col >= 5) {
            System.out.println("Input tidak valid! Papan hanya berukuran 4x5.");
            return true;
        }

        // Jika kotak sudah pernah ditebak
        if (revealed[row][col]) {
            System.out.println("Kotak telah dibuka sebelumnya!");
            return true;
        }

        revealed[row][col] = true;

        // Jika menebak bom
        if (data[row][col] == 1) {
            System.out.println("BOOM! Anda menemukan bom! Permainan berakhir.");
            return false;
        } else {
            System.out.println("Kotak Aman");
            safeCount++;
            return true;
        }
    }

    // Mengecek apakah pemain berhasil membuka 18 kotak aman
    public boolean isGameOver() {
        return safeCount == 18;
    }

    // Membuka semua papan (biasanya dipanggil saat game berakhir)
    public void revealAll() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                revealed[i][j] = true;
            }
        }
    }
}