package jawaban2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tambahLagi;
        int totalKendaraan = 0;
        double totalSemuaBiaya = 0;

        System.out.println("Welcome to ParkingChan");

        do {
            System.out.print("Enter vehicle type (Motor/Mobil/Truk): ");
            String jenis = scanner.nextLine();

            // Instansiasi objek kendaraan baru
            Kendaraan kendaraan = new Kendaraan(jenis);

            System.out.print("Enter Duration (Manual/Time): ");
            String tipeDurasi = scanner.nextLine();

            // Mengeksekusi method overloading yang sesuai dengan pilihan
            if (tipeDurasi.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour): ");
                int durasi = scanner.nextInt();
                kendaraan.hitungBiaya(durasi);
            } else if (tipeDurasi.equalsIgnoreCase("Time")) {
                System.out.print("Enter entry time: ");
                int jamMasuk = scanner.nextInt();
                System.out.print("Enter exit time : ");
                int jamKeluar = scanner.nextInt();
                kendaraan.hitungBiaya(jamMasuk, jamKeluar);
            }

            // Menampilkan ringkasan per kendaraan
            kendaraan.tampilkanRingkasan();

            // Mencatat rekapitulasi data
            totalKendaraan++;
            totalSemuaBiaya += kendaraan.getTotalBiaya();

            // Membersihkan sisa baris baru di Scanner sebelum membaca string lagi
            scanner.nextLine();
            System.out.print("Add another vehicle? (y/n): ");
            tambahLagi = scanner.nextLine();

        } while (tambahLagi.equalsIgnoreCase("y"));

        // Menampilkan laporan akhir setelah perulangan selesai
        System.out.println("==== FINAL REPORT ====");
        System.out.println("Total Vehicle Final\t\t: " + totalKendaraan);
        System.out.println("Total Parking Fees Final\t: " + totalSemuaBiaya);
        System.out.println("Thank You.....");

        scanner.close();
    }
}