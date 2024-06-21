package fresh.vegetables;

public class cTransaksi {

    private String kode, pembeli, alamat;
    private cProduk produk;
    private cMember member;
    private int jumprd, status, total;
    cTransaksi next;

    cTransaksi(String k, String p, String a, cProduk pr, int j, int t, int s) {
        kode = k;
        this.pembeli = p;
        this.alamat = a;
        produk = pr;
        jumprd = j;
        total = t;
        status = s;
        next = null;
    }

    public String getKode() {
        return kode;
    }
    
    public String getPembeli() {
        return pembeli;
    }
    
    public String getAlamat() {
        return alamat;
    }
    
    public cMember getMember(){
        return member;
    }
    
    public cProduk getProduk() {
        return produk;
    }
    
    public int getJumlah() {
        return jumprd;
    }
    
    public int getTotal() {
        return total;
    }
    
    public int getStatus() {
        return status;
    }
    
    public void setKode(String kode){
        this.kode = kode;
    }
    
    public void setPembeli(String pembeli) {
        this.pembeli = pembeli;
    }
    
    public void setAlamat(String a) {
        alamat = a;
    }
    
    public void setStatus(int s) {
        this.status = s;
    }

}
