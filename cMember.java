package fresh.vegetables;

public class cMember {

    private String id, password, nama, alamat;
    private double rekapPembelian;

    cMember(String id, String p, String n, String al) {
        this.id = id;
        password = p;
        nama = n;
        alamat = al;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public double getRekapPembelian() {
        return rekapPembelian;
    }

    public void setPassword(String p) {
        this.password = p;
    }

    public void setNama(String n) {
        this.nama = n;
    }

    public void setAlamat(String al) {
        this.alamat = al;
    }

    public void setRekapPembelian(double rekapPembelian) {
        this.rekapPembelian = rekapPembelian;
    }

    public String ToString() {
        return "ID Member: " + id + "\nNama: " + nama + "\nAlamat: " + this.alamat;
    }
}
