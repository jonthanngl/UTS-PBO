package jawaban1;

import java.util.ArrayList;

public class Perusahaan {
    private ArrayList<Karyawan> daftarKaryawan;

    public Perusahaan() {
        daftarKaryawan = new ArrayList<>();
    }

    // Menambahkan karyawan baru
    public void tambahKaryawan(Karyawan k) {
        // Validasi agar tidak ada ID karyawan yang duplikat
        for (Karyawan kar : daftarKaryawan) {
            if (kar.getId().equals(k.getId())) {
                System.out.println("Gagal: ID karyawan sudah ada.");
                return;
            }
        }
        // Validasi gaji agar tidak negatif
        if (k.getGaji() < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif.");
            return;
        }
        daftarKaryawan.add(k);
        System.out.println("Karyawan berhasil ditambahkan.");
    }

    // Menghapus karyawan berdasarkan validasi keberadaan
    public void hapusKaryawan(String id) {
        for (int i = 0; i < daftarKaryawan.size(); i++) {
            if (daftarKaryawan.get(i).getId().equals(id)) {
                daftarKaryawan.remove(i);
                System.out.println("Karyawan berhasil dihapus.");
                return;
            }
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
    }

    // Memperbarui posisi
    public void ubahPosisi(String id, String posisiBaru) {
        for (Karyawan kar : daftarKaryawan) {
            if (kar.getId().equals(id)) {
                kar.setPosisi(posisiBaru);
                System.out.println("Posisi berhasil diubah.");
                return;
            }
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
    }

    // Memperbarui gaji
    public void ubahGaji(String id, double gajiBaru) {
        if (gajiBaru < 0) {
            System.out.println("Gagal: Gaji tidak boleh negatif.");
            return;
        }
        for (Karyawan kar : daftarKaryawan) {
            if (kar.getId().equals(id)) {
                kar.setGaji(gajiBaru);
                System.out.println("Gaji berhasil diubah.");
                return;
            }
        }
        System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
    }

    // Menampilkan seluruh data
    public void tampilkanSemua() {
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Belum ada data karyawan.");
            return;
        }
        for (Karyawan kar : daftarKaryawan) {
            System.out.println(kar.toString());
        }
    }
}