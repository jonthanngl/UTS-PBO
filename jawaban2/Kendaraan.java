package jawaban2;
public class Kendaraan {
    private String jenisKendaraan;
    private int durasiParkir;
    private double totalBiaya;

    // Constructor menerima jenis kendaraan
    public Kendaraan(String jenisKendaraan) {
        this.jenisKendaraan = jenisKendaraan;
    }

    // Method Overloading 1: Input durasi manual
    public void hitungBiaya(int durasi) {
        this.durasiParkir = durasi;
        kalkulasiBiaya();
    }

    // Method Overloading 2: Input jam masuk dan jam keluar
    public void hitungBiaya(int jamMasuk, int jamKeluar) {
        if (jamKeluar < jamMasuk) {
            // Kondisi jika parkir melewati tengah malam (berganti hari)
            this.durasiParkir = (jamKeluar + 24) - jamMasuk;
        } else {
            // Kondisi normal di hari yang sama
            this.durasiParkir = jamKeluar - jamMasuk;
        }
        kalkulasiBiaya();
    }

    // Fungsi internal untuk menghitung tarif dan diskon
    private void kalkulasiBiaya() {
        int tarifPerJam = 0;

        // Penentuan tarif berdasarkan contoh output di soal
        if (jenisKendaraan.equalsIgnoreCase("Motor")) {
            tarifPerJam = 2000;
        } else if (jenisKendaraan.equalsIgnoreCase("Mobil")) {
            tarifPerJam = 5000;
        } else if (jenisKendaraan.equalsIgnoreCase("Truk")) {
            tarifPerJam = 10000;
        }

        double biayaSementara = durasiParkir * tarifPerJam;

        // Diskon 10% jika durasi parkir lebih dari 5 jam
        if (durasiParkir > 5) {
            totalBiaya = biayaSementara - (biayaSementara * 0.10);
        } else {
            totalBiaya = biayaSementara;
        }
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public void tampilkanRingkasan() {
        System.out.println("---- PARKING SUMMARY");
        System.out.println("Vehicle Type\t: " + jenisKendaraan);
        System.out.println("Parking Time\t: " + durasiParkir + " hour(s)");
        System.out.println("Total Fee\t: Rp" + totalBiaya);
    }
}