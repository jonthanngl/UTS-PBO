package jawaban1;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Perusahaan perusahaan = new Perusahaan();
        int pilihan = 0;

        while (pilihan != 6) {
            System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
            System.out.println("1. Tambah Karyawan");
            System.out.println("2. Hapus Karyawan");
            System.out.println("3. Ubah Posisi");
            System.out.println("4. Ubah Gaji");
            System.out.println("5. Tampilkan Semua Karyawan");
            System.out.println("6. Keluar");
            System.out.print("Masukkan pilihan: ");

            pilihan = scanner.nextInt();
            scanner.nextLine(); // Konsumsi sisa line (enter)

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Posisi: ");
                    String posisi = scanner.nextLine();
                    System.out.print("Masukkan Gaji: ");
                    double gaji = scanner.nextDouble();
                    perusahaan.tambahKaryawan(new Karyawan(id, nama, posisi, gaji));
                    break;
                case 2:
                    System.out.print("Masukkan ID karyawan yang akan dihapus: ");
                    String idHapus = scanner.nextLine();
                    perusahaan.hapusKaryawan(idHapus);
                    break;
                case 3:
                    System.out.print("Masukkan ID karyawan: ");
                    String idPosisi = scanner.nextLine();
                    System.out.print("Masukkan posisi baru: ");
                    String posisiBaru = scanner.nextLine();
                    perusahaan.ubahPosisi(idPosisi, posisiBaru);
                    break;
                case 4:
                    System.out.print("Masukkan ID karyawan: ");
                    String idGaji = scanner.nextLine();
                    System.out.print("Masukkan gaji baru: ");
                    double gajiBaru = scanner.nextDouble();
                    perusahaan.ubahGaji(idGaji, gajiBaru);
                    break;
                case 5:
                    perusahaan.tampilkanSemua();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }
}