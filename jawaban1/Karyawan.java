package jawaban1;

public class Karyawan {
    private String id;
    private String nama;
    private String posisi;
    private double gaji;

    // Constructor untuk menginstansiasi objek karyawan
    public Karyawan(String id, String nama, String posisi, double gaji) {
        this.id = id;
        this.nama = nama;
        this.posisi = posisi;
        this.gaji = gaji;
    }

    public String getId() { return id; }
    public void setPosisi(String posisi) { this.posisi = posisi; }

    public double getGaji() { return gaji; }
    public void setGaji(double gaji) { this.gaji = gaji; }

    @Override
    public String toString() {
        return "ID: " + id + ", Nama: " + nama + ", Posisi: " + posisi + ", Gaji: Rp" + gaji;
    }
}