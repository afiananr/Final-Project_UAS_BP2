package fresh.vegetables;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppKasir {
    
    public static final String bgWhite = "\u001B[47m";
    public static final String gYellow = "\u001B[33;43m";
    public static final String gGreen = "\u001B[32;42m"; 
    public static final String reset = "\u001B[0m";
    static Scanner sc = new Scanner(System.in);
    static cUser owner1, owner2, owner3, admin1, admin2, admin3;
    static cMember member1, member2, member3;
    static cSayuran sy1, sy2, sy3, sy4;
    static cBumbuMasak bm1, bm2, bm3, bm4;
    static int nomor = 0;
    static LocalDateTime currentDateTime = LocalDateTime.now();
    static cDetailTransaksi detail = new cDetailTransaksi();
    static int sy1revenue = 0, sy2revenue = 0, sy3revenue =0, sy4revenue=0;
    static int bm1revenue = 0, bm2revenue = 0, bm3revenue =0, bm4revenue=0;
    static int totalRevenue = 0;
    static int rekapm1 = 0, rekapm2 = 0, rekapm3 = 0;
    static int rekapNonMember = 0;

    public static void main(String[] args) {
        // init produk
        sy1 = new cSayuran("sy01", "Bayam", 8000, 2000);
        sy2 = new cSayuran("sy02", "Kol", 6100, 10000);
        sy3 = new cSayuran("sy03", "Cabai Kriting", 10400, 5000);
        sy4 = new cSayuran("sy04", "Bawang Bombay", 15600, 20000);
        bm1 = new cBumbuMasak("bm01", "Sasa Tepung 210gr", 6500, 50);
        bm2 = new cBumbuMasak("bm02", "Masako Sapi 11gr", 500, 60);
        bm3 = new cBumbuMasak("bm03", "Kecap Bango 60ml", 4000, 50);
        bm4 = new cBumbuMasak("bm04", "Santen Kara 65ml", 5500, 60);
        // init id password
        owner1 = new cUser("162", "anaowner");
        owner2 = new cUser("197", "gilangowner");
        owner3 = new cUser("196", "paculowner");
        admin1 = new cUser("162", "anaadmin");
        admin2 = new cUser("197", "gilangadmin");
        admin3 = new cUser("196", "paculadmin");
        // init member
        member1 = new cMember("24162", "anamember", "Afiana Nurani", "Surabaya");
        member2 = new cMember("24197", "gilangmember", "Erwin Gilang Samudra", "Surabaya");
        member3 = new cMember("24196", "paculmember", "Nalendra Pradipta Loka", "Sidoarjo");
        // ke menu user
        menuuser();
    }

    public static void menuuser() {
        int pilih = 0;
        do {
            System.out.println("=================================================================");
            System.out.println("                         FRESH  VEGETABLES                         ");
            System.out.println("                          Premium Organic                          ");
            System.out.println("==================================================================");
            System.out.println("1. Pembeli\n2. Member\n3. Admin\n4. Owner\n5. Keluar");
            System.out.println("==================================================================");
            System.out.print("Pilih disini (1-5) : ");
            pilih = sc.nextInt();
            System.out.println("==================================================================");
            sc.nextLine();//new line
            switch (pilih) {
                case 1:
                    System.out.println("(ketik '-' untuk kembali)");
                    System.out.print("Nama Anda: ");
                    String nama = sc.nextLine();
                    if (!nama.equals("-")) {
                        System.out.print("Alamat Tujuan: ");
                        String alamat = sc.nextLine();
                        if (!alamat.equals("-")) {
                            pembeli(nama, alamat);
                        }
                    }
                    break;
                case 2:
                    boolean valid0 = false;
                    while (!valid0) {
                        System.out.println("(ketik '-' untuk kembali)");
                        System.out.print("ID Member: ");
                        String id = sc.next();
                        if (!id.equals("-")) {
                            System.out.print("Password: ");
                            String pw = sc.next();
                            if (pw.equals("-")) break;
                            if (id.equals(member1.getId()) && pw.equals(member1.getPassword())) {
                                member(member1);
                                valid0 = true;
                            } else if (id.equals(member2.getId()) && pw.equals(member2.getPassword())) {
                                member(member2);
                                valid0 = true;
                            } else if (id.equals(member3.getId()) && pw.equals(member3.getPassword())) {
                                member(member3);
                                valid0 = true;
                            } else {
                                System.out.println("ERROR! ID/Password Salah");
                            }
                        } else break;
                    }
                    break;
                case 3:
                    boolean valid = false;
                    while (!valid) {
                        System.out.println("(ketik '-' untuk kembali)");
                        System.out.print("ID Admin: ");
                        String id = sc.next();
                        if (!id.equals("-")) {
                            System.out.print("Password: ");
                            String pw = sc.next();
                            if (pw.equals("-")) break;
                            if ((id.equals(admin1.getId()) && pw.equals(admin1.getPassword())) || (id.equals(admin2.getId()) && pw.equals(admin2.getPassword())) || (id.equals(admin3.getId()) && pw.equals(admin3.getPassword()))) {
                                valid = true;
                                admin();
                            } else System.out.println("ERROR! ID/Password Salah");
                        } else break;
                    }
                    break;
                case 4:
                    boolean valid1 = false;
                    while (!valid1) {
                        System.out.println("(ketik '-' untuk kembali)");
                        System.out.print("ID Owner: ");
                        String id = sc.next();
                        if (!id.equals("-")) {
                            System.out.print("Password: ");
                            String pw = sc.next();
                            if (pw.equals("-")) break;
                            if ((id.equals(owner1.getId()) && pw.equals(owner1.getPassword())) || (id.equals(owner2.getId()) && pw.equals(owner2.getPassword()))|| (id.equals(owner3.getId()) && pw.equals(owner3.getPassword()))) {
                                valid1 = true;
                                owner();
                            } else System.out.println("ERROR! ID/Password Salah");
                        } else  break;
                    }
                    break;
                case 5:
                    System.out.println("==================================================================");
                    System.out.println("                    TERIMAKASIH TELAH BERKUNJUNG              ");
                    System.out.println("==================================================================");
                    break;
                default:
                    System.out.println("ERROR! Pilihan Tidak Valid");
            }
        } while (pilih != 5);
    }

    public static void pembeli(String nama, String alamat) {
        nomor++;
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MMdd");
        String datepart = currentDateTime.format(dateformatter); // format kode transaksi bagian bulan dan tanggal
        String numberpart = String.format("%03d", nomor); // format kode transaksi bagian nomor urut
        String k_tran = "TR" + datepart + numberpart;
        int pilih = 0;
        cDetailTransaksi belanja = new cDetailTransaksi(); // untuk keranjang belanja
        do {
            System.out.println("\n==================================================================");
            System.out.println("                            MENU PEMBELI                          ");
            System.out.println("==================================================================");
            System.out.println("Nama: " + nama + "\nAlamat Tujuan: " + alamat);
            System.out.println("\n1. Tambah Produk\n2. Hapus Produk\n3. Lihat Keranjang\n4. Selesai");
            System.out.println("==================================================================");
            System.out.print("Pilih disini (1-4) : ");
            pilih = sc.nextInt();
            sc.nextLine(); // newline
            switch (pilih) {
                case 1:
                    String k_prd = null;
                    do {
                        cTransaksi baru = null;
                        daftarsayuran();
                        daftarbumbumasak();
                        System.out.println("Ketik '0' untuk Kembali/Selesai");
                        System.out.println("Ketik 'v' untuk Lihat Keranjang.");
                        System.out.print("Masukkan Kode Produk: ");
                        k_prd = sc.next();
                        if (k_prd.equals("0")) break;
                        else if (k_prd.equals("v")) {
                            belanja.keranjangpembeli();
                            continue;
                        } else {
                            baru = createTransaksiPembeli(k_prd, nama, alamat, k_tran);
                            if (baru != null)  belanja.tambahTransaksi(baru);
                            else System.out.println("ERROR! Kode Tidak Valid");
                        }
                    } while (true);
                    break;
                case 2:
                    do {
                        int banyak = belanja.keranjangpembeli();
                        System.out.println("Ketik '0' untuk Kembali/Selesai");
                        System.out.print("Nomor Produk yang Akan Dihapus: ");
                        int produk_hapus = sc.nextInt();
                        if (produk_hapus == 0) break;
                        else if (produk_hapus >= banyak) {
                            System.out.println("ERROR! Pilihan Tidak Valid");
                        }
                        else belanja.hapusTransaksi(produk_hapus);
                    } while (true);
                    break;
                case 3:
                    belanja.keranjangpembeli();
                    break;
                case 4:
                    System.out.println("\n==================================================================");
                    System.out.println("               TRANSAKSI SEDANG DIPROSES, TERIMAKASIH               ");
                    System.out.println("==================================================================");
                    detail.sambungTransaksi(belanja.getFront(), belanja.getRear()); // Memasukkan transaksi ke detail transaksi utama toko
                default:
                    System.out.println("ERROR! Pilihan Tidak Valid");
            }
        } while (pilih != 4);
    }

    public static cTransaksi createTransaksiPembeli(String k_prd, String nama, String alamat, String k_tran) {
        int jumlah = 0, total = 0;
        if (k_prd.equals(sy1.getKode()) || k_prd.equals(sy2.getKode()) || k_prd.equals(sy3.getKode()) || k_prd.equals(sy4.getKode())) {
            System.out.print("Jumlah (gram) = ");
            jumlah = sc.nextInt();
            cProduk sayur = null;
            if (k_prd.equals(sy1.getKode())) {
                sayur = sy1;
            } else if (k_prd.equals(sy2.getKode())) {
                sayur = sy2;
            } else if (k_prd.equals(sy3.getKode())) {
                sayur = sy3;
            } else if (k_prd.equals(sy4.getKode())) {
                sayur = sy4;
            }
            if (sayur != null) {
                if (jumlah > sayur.getStok()) {
                    System.out.println("Maaf, Stok Tidak Tersedia");
                    return null;
                }
                total = (jumlah * sayur.getHarga()) / 250; // harga total per gram
                sayur.setStok(sayur.getStok() - jumlah); // update stok
                return new cTransaksi(k_tran, nama, alamat, sayur, jumlah, total, 0);
            }
        } else if (k_prd.equals(bm1.getKode()) || k_prd.equals(bm2.getKode()) || k_prd.equals(bm3.getKode()) || k_prd.equals(bm4.getKode())) {
            System.out.print("Jumlah = ");
            jumlah = sc.nextInt();
            cProduk bumbu = null;
            if (k_prd.equals(bm1.getKode())) {
                bumbu = bm1;
            } else if (k_prd.equals(bm2.getKode())) {
                bumbu = bm2;
            } else if (k_prd.equals(bm3.getKode())) {
                bumbu = bm3;
            } else if (k_prd.equals(bm4.getKode())) {
                bumbu = bm4;
            }
            if (bumbu != null) {
                if (jumlah > bumbu.getStok()) {
                    System.out.println("Maaf, Stok Tidak Tersedia");
                    return null;
                }
                total = jumlah * bumbu.getHarga();
                bumbu.setStok(bumbu.getStok() - jumlah); // update stok
                return new cTransaksi(k_tran, nama, alamat, bumbu, jumlah, total, 0);
            }
        }
        return null;
    }

    public static void member(cMember member) {
        nomor++;
        DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MMdd");
        String datepart = currentDateTime.format(dateformatter); // format kode transaksi bagian bulan dan tanggal
        String numberpart = String.format("%03d", nomor); // format kode transaksi bagian nomor urut
        String k_tran = "TR" + datepart + numberpart;
        int pilih = 0;
        cDetailTransaksi belanja = new cDetailTransaksi(); // Instance baru untuk keranjang belanja
        do {
            System.out.println("\n==================================================================");
            System.out.println("                            MENU MEMBER                           ");
            System.out.println("==================================================================");
            System.out.println("Nama: " + member.getNama() + "\nAlamat Tujuan: " + member.getAlamat());
            System.out.println("\n1. Tambah Produk\n2. Hapus Produk\n3. Lihat Keranjang\n4. Ubah Password\n5. Selesai");
            System.out.println("==================================================================");
            System.out.print("Pilih disini (1-5) : ");
            pilih = sc.nextInt();
            sc.nextLine(); // newline
            switch (pilih) {
                case 1:
                    String k_prd = null;
                    do {
                        cTransaksi baru = null;
                        daftarsayuran();
                        daftarbumbumasak();
                        System.out.println("Ketik '0' untuk Kembali/Selesai");
                        System.out.println("Ketik 'v' untuk Lihat Keranjang.");
                        System.out.print("Masukkan Kode Produk: ");
                        k_prd = sc.next();
                        if (k_prd.equals("0"))  break;
                        else if (k_prd.equals("v")) {
                            belanja.keranjangmember();
                            continue;
                        } else {
                            baru = createTransaksiMember(k_prd, member.getId(),member.getAlamat(), k_tran);
                            if (baru != null)  belanja.tambahTransaksi(baru);
                            else System.out.println("ERROR! Kode Tidak Valid");
                        }
                    } while (true);
                    break;
                case 2:
                    do {
                        int banyak = belanja.keranjangmember();
                        System.out.println("Ketik '0' untuk Kembali/Selesai");
                        System.out.print("Nomor Produk yang Akan Dihapus: ");
                        int produk_hapus = sc.nextInt();
                        if (produk_hapus == 0) break;
                        else if (produk_hapus >= banyak) {
                            System.out.println("ERROR! Pilihan Tidak Valid");
                        }
                        else belanja.hapusTransaksi(produk_hapus);
                    } while (true);
                    break;
                case 3:
                    belanja.keranjangmember();
                    break;
                case 4:
                    boolean valid = false;
                    while (!valid) {
                        System.out.println("\n==================================================================");
                        System.out.println("                            UBAH PASSWORD                         ");
                        System.out.println("==================================================================");
                        System.out.println("(ketik '-' untuk kembali)");
                        System.out.print("ID Member: ");
                        String id = sc.next();
                        if (!id.equals("-")) {
                            System.out.print("Pasword lama: ");
                            String pw = sc.next();
                            if (pw.equals("-")) break;
                            if (id.equals(member.getId()) && pw.equals(member.getPassword())) {
                                boolean berhasil =false;
                                while (!berhasil){
                                    System.out.print("Pasword baru: ");
                                    String pw_baru = sc.next();
                                    if (pw_baru.equals("-")) break;
                                    System.out.print("Konfirmasi Pasword baru: ");
                                    String pw_konvirmasi = sc.next();
                                    if (pw_konvirmasi.equals("-")) break;
                                    if (pw_baru.equals(pw_konvirmasi)){
                                        System.out.println("Ubah Password Berhasil");
                                        member.setPassword(pw_baru);
                                        berhasil = true;
                                    } else System.out.println("ERROR! Ubah Password Gagal");
                                }
                                valid = true;
                            }
                            else System.out.println("ERROR! Username/Password Salah");
                        } else break;
                    }
                    break;
                case 5:
                    System.out.println("\n==================================================================");
                    System.out.println("               TRANSAKSI SEDANG DIPROSES, TERIMAKASIH               ");
                    System.out.println("==================================================================");
                    detail.sambungTransaksi(belanja.getFront(), belanja.getRear()); // Memasukkan transaksi ke detail transaksi utama toko
                default:
                    System.out.println("ERROR! Pilihan Tidak Valid");
            }
        } while (pilih != 5);
    }

    public static cTransaksi createTransaksiMember(String k_prd, String id, String alamat, String k_tran) {
        int jumlah = 0, total = 0;
        double discount = 0.05; // diskon 5%
        if (k_prd.equals(sy1.getKode()) || k_prd.equals(sy2.getKode()) || k_prd.equals(sy3.getKode()) || k_prd.equals(sy4.getKode())) {
            System.out.print("Jumlah (gram) = ");
            jumlah = sc.nextInt();
            cProduk sayur = null;
            if (k_prd.equals(sy1.getKode())) {
                sayur = sy1;
            } else if (k_prd.equals(sy2.getKode())) {
                sayur = sy2;
            } else if (k_prd.equals(sy3.getKode())) {
                sayur = sy3;
            } else if (k_prd.equals(sy4.getKode())) {
                sayur = sy4;
            }
            if (sayur != null) {
                if (jumlah > sayur.getStok()) {
                    System.out.println("Maaf, Stok Tidak Tersedia");
                    return null;
                }
                total = (jumlah * sayur.getHarga()) / 250; // harga total per produk
                int after_disc = (int) (total - (total * discount));
                sayur.setStok(sayur.getStok() - jumlah); // update stok
                return new cTransaksi(k_tran, id, alamat, sayur, jumlah, after_disc, 0);
            }
        } else if (k_prd.equals(bm1.getKode()) || k_prd.equals(bm2.getKode()) || k_prd.equals(bm3.getKode()) || k_prd.equals(bm4.getKode())) {
            System.out.print("Jumlah = ");
            jumlah = sc.nextInt();
            cProduk bumbu = null;
            if (k_prd.equals(bm1.getKode())) {
                bumbu = bm1;
            } else if (k_prd.equals(bm2.getKode())) {
                bumbu = bm2;
            } else if (k_prd.equals(bm3.getKode())) {
                bumbu = bm3;
            } else if (k_prd.equals(bm4.getKode())) {
                bumbu = bm4;
            }
            if (bumbu != null) {
                if (jumlah > bumbu.getStok()) {
                    System.out.println("Maaf, Stok Tidak Tersedia");
                    return null;
                }
                total = jumlah * bumbu.getHarga();
                int after_disc = (int) (total - (total * discount));
                bumbu.setStok(bumbu.getStok() - jumlah); // update stok
                return new cTransaksi(k_tran, id, alamat, bumbu, jumlah, after_disc, 0);
            }
        }
        return null;
    }
    
    public static void admin() {
        System.out.println("\n==================================================================");
        System.out.println("                               ADMIN                                ");
        System.out.println("==================================================================");
        cNode t = detail.getFront(); // Mengambil node terdepan dari antrian transaksi
        if (t == null) {
            System.out.println("Belum Ada Transaksi Dalam Antrian atau Keluar Dari Mode Admin");
            return;
        }
        int aksi;
        while (t != null) {
            detail.transaksiBelumDiproses();
            System.out.println("\n==================================================================");
            System.out.println("                         MENUNGGU DIPROSES                      ");
            System.out.println("==================================================================");
            if (t.data.getStatus() == 0) {
                System.out.println("Kode    : " + t.data.getKode());
                System.out.println("Pembeli : " + (t.data.getPembeli() != null ? t.data.getPembeli() : t.data.getMember().getId()));
                System.out.println("Produk  : " + t.data.getProduk().getNama());
                System.out.println("Jumlah  : " + t.data.getJumlah());
                System.out.println("Harga   : " + t.data.getTotal());
                System.out.println("==================================================================");
                System.out.println("1. Diproses");
                System.out.println("2. Kembali ke Menu User");
                System.out.print("Pilih Aksi (1/2): ");
                aksi = sc.nextInt();
                boolean validInput = false;
                while (!validInput) {
                    if (aksi == 1) {
                        t.data.setStatus(1); // Mengubah status transaksi menjadi diproses
                        System.out.println("==================================================================");
                        System.out.println("                         BERHASIL DIPROSES                        ");
                        System.out.println("==================================================================");
                        if (t.data.getMember()!= null) { // ini member
                            String member = t.data.getMember().getId();
                            if (member.equals("24162")) {
                                AppKasir.rekapm1 += t.data.getTotal();
                            } else if (member.equals("24197")) {
                                AppKasir.rekapm2 += t.data.getTotal();
                            } else if (member.equals("24196")) {
                                AppKasir.rekapm3 += t.data.getTotal();
                            }
                        } else { // bukan member
                            AppKasir.rekapNonMember += t.data.getTotal();
                        }
                        if (t.data.getProduk().getKode().equals("sy01")) {
                            AppKasir.sy1revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("sy02")) {
                            AppKasir.sy2revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("sy03")) {
                            AppKasir.sy3revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("sy04")) {
                            AppKasir.sy4revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("bm01")) {
                            AppKasir.bm1revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("bm02")) {
                            AppKasir.bm2revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("bm03")) {
                            AppKasir.bm3revenue += t.data.getTotal();
                        } else if (t.data.getProduk().getKode().equals("bm04")) {
                            AppKasir.bm4revenue += t.data.getTotal();
                        } validInput = true;
                    } else if (aksi==2){
                        validInput = true;break;
                    }else {
                        System.out.println("ERROR! Pilihan Tidak Valid");
                    }
                }
            }
            t = t.next;
            if (t == null) break;
        }
        System.out.println("Semua transaksi telah diproses atau keluar dari mode admin.");
    }

    public static void owner() {
        int pilih = 0;
        do {
            System.out.println("\n==================================================================");
            System.out.println("                             MENU OWNER                          ");
            System.out.println("==================================================================");
            System.out.println("Total Nilai Order Penjualan yang Sudah Diproses: " + detail.lihatDiproses());
            System.out.println("Total Nilai Order Penjualan yang Belum Diproses: " + detail.lihatBelumDiproses());
            System.out.println("\n1. Ubah Harga dan Stok\n2. Total Nilai Penjualan Harian Tiap jenis Barang\n3. Rekapitulasi Belanja Member\n4. Grafik Penjualan\n5. Kembali");
            System.out.println("==================================================================");
            System.out.print("Pilih disini (1-5) : ");
            pilih = sc.nextInt();
            sc.nextLine();//new line
            switch (pilih) {
                case 1:
                    do {
                        System.out.println("\n==================================================================");
                        System.out.println("                         UBAH DETAIL PRODUK                       ");
                        System.out.println("==================================================================");
                        daftarsayuran();
                        daftarbumbumasak();
                        System.out.println("ketik '-' untuk kembali");
                        System.out.print("Masukkan kode produk yang ingin diubah : ");
                        String k_prd = sc.next();
                        if (k_prd.equals("-"))break;
                        if (k_prd.equals(sy1.getKode()) || k_prd.equals(sy2.getKode()) || k_prd.equals(sy3.getKode()) || k_prd.equals(sy4.getKode()) || k_prd.equals(bm1.getKode()) || k_prd.equals(bm2.getKode()) || k_prd.equals(bm3.getKode()) || k_prd.equals(bm4.getKode())) {
                            System.out.println("Ketik '0' untuk Jika Tidak Ingin Mengubah");
                            System.out.print("Harga baru : Rp. ");
                            int h_baru = sc.nextInt();
                            System.out.print("Stok baru : ");
                            int s_baru = sc.nextInt();
                            if (k_prd.equals(sy1.getKode())) {
                                if (h_baru!= 0) sy1.setHarga(h_baru);
                                if (s_baru!= 0) sy1.setStok(s_baru);
                            } else if (k_prd.equals(sy2.getKode())) {
                                if (h_baru!= 0) sy2.setHarga(h_baru);
                                if (s_baru!= 0) sy2.setStok(s_baru);
                            } else if (k_prd.equals(sy3.getKode())) {
                                if (h_baru!= 0) sy3.setHarga(h_baru);
                                if (s_baru!= 0) sy3.setStok(s_baru);
                            } else if (k_prd.equals(sy4.getKode())) {
                                if (h_baru!= 0) sy4.setHarga(h_baru);
                                if (s_baru!= 0) sy4.setStok(s_baru);
                            } else if (k_prd.equals(bm1.getKode())) {
                                if (h_baru!= 0) bm1.setHarga(h_baru);
                                if (s_baru!= 0) bm1.setStok(s_baru);
                            } else if (k_prd.equals(bm2.getKode())) {
                                if (h_baru!= 0) bm2.setHarga(h_baru);
                                if (s_baru!= 0) bm2.setStok(s_baru);
                            } else if (k_prd.equals(bm3.getKode())) {
                                if (h_baru!= 0) bm3.setHarga(h_baru);
                                if (s_baru!= 0) bm3.setStok(s_baru);
                            } else if (k_prd.equals(bm4.getKode())) {
                                if (h_baru!= 0) bm4.setHarga(h_baru);
                                if (s_baru!= 0) bm4.setStok(s_baru);
                            }
                        } else {
                            System.out.println("ERROR! Produk Tidak Ditemukan");
                        }
                    } while (true); 
                    break;
                case 2 :
                    totalRevenue = sy1revenue+sy2revenue+sy3revenue+sy4revenue+bm1revenue+bm2revenue+bm3revenue+bm4revenue;
                    System.out.println("===================================================================");
                    System.out.println("                     LAPORAN PENJUALAN HARIAN                     ");
                    System.out.println("===================================================================");
                    System.out.println("#  Total Pendapatan: "+ totalRevenue);
                    System.out.println("1. "+sy1.getNama() +": "+ sy1revenue);
                    System.out.println("2. "+sy2.getNama() +": "+ sy2revenue);
                    System.out.println("3. "+sy3.getNama() +": "+ sy3revenue);
                    System.out.println("4. "+sy4.getNama() +": "+ sy4revenue);
                    System.out.println("5. "+bm1.getNama() +": "+ bm1revenue);
                    System.out.println("2. "+bm2.getNama() +": "+ bm2revenue);
                    System.out.println("3. "+bm3.getNama() +": "+ bm3revenue);
                    System.out.println("4. "+sy4.getNama() +": "+ bm4revenue);
                    break;
                case 3 :
                    System.out.println("==================================================================");
                    System.out.println("                    REKAPITULASI BELANJA MEMBER                   ");
                    System.out.println("==================================================================");
                    System.out.println("#  Rekap Non Member: "+ rekapNonMember);
                    System.out.println("1. "+member1.getNama() +": "+ rekapm1);
                    System.out.println("2. "+member2.getNama() +": "+ rekapm2);
                    System.out.println("3. "+member3.getNama() +": "+ rekapm3);
                    break;
                case 4 :
                    System.out.println("==================================================================");
                    System.out.println("                      GRAFIK PENJUALAN BARANG                     ");
                    System.out.println("==================================================================");
                    int sy1X = (int) Math.floor(sy1revenue / 10000);
                    int sy2X = (int) Math.floor(sy2revenue / 10000);
                    int sy3X = (int) Math.floor(sy3revenue / 10000);
                    int sy4X = (int) Math.floor(sy4revenue / 10000);
                    int bm1X = (int) Math.floor(bm1revenue / 10000);
                    int bm2X = (int) Math.floor(bm2revenue / 10000);
                    int bm3X = (int) Math.floor(bm3revenue / 10000);
                    int bm4X = (int) Math.floor(bm4revenue / 10000);
                    System.out.println("1. "+sy1.getNama() +": "+gYellow+ repeatString("X", sy1X) +reset+ " " + (sy1X * 10000));
                    System.out.println("1. "+sy2.getNama() +": "+gGreen+ repeatString("X", sy2X) +reset+ " " + (sy2X * 10000));
                    System.out.println("1. "+sy3.getNama() +": "+gYellow+ repeatString("X", sy3X) +reset+ " " + (sy3X * 10000));
                    System.out.println("3. "+sy4.getNama() +": "+gGreen+ repeatString("X", sy4X) +reset+ " " + (sy4X * 10000));
                    System.out.println("4. "+bm1.getNama() +": "+gYellow+ repeatString("X", bm1X)+reset + " " + (bm1X * 10000));
                    System.out.println("5. "+bm2.getNama() +": "+gGreen+ repeatString("X", bm2X) +reset+ " " + (bm2X * 10000));
                    System.out.println("6. "+bm3.getNama() +": "+gYellow+ repeatString("X", bm3X)+reset + " " + (bm3X * 10000));
                    System.out.println("7. "+bm4.getNama() +": "+gGreen+ repeatString("X", bm4X) +reset+ " " + (bm4X * 10000));
                    break;
                case 5 :
                    System.out.println("==================================================================");
                    System.out.println("                           TERIMA KASIH                           ");
                    System.out.println("==================================================================");
                    break;
                default :
                    System.out.println("ERROR! Pilihan Tidak Valid");
            }
        }while (pilih!=5);
    }

    public static void daftarsayuran() {
        System.out.println("\n==================================================================");
        System.out.println("                      DAFTAR PRODUK (SAYURAN)                 ");
        System.out.println("==================================================================");
        System.out.printf("%-14s %-20s %-18s %s\n", "KODE PRODUK", "NAMA PRODUK", "HARGA (per 250gr)", "STOK(gram)");
        System.out.printf("%-14s %-20s %-18s %s\n", sy1.getKode(), sy1.getNama(), sy1.getHarga(), sy1.getStok());
        System.out.printf("%-14s %-20s %-18s %s\n", sy2.getKode(), sy2.getNama(), sy2.getHarga(), sy2.getStok());
        System.out.printf("%-14s %-20s %-18s %s\n", sy3.getKode(), sy3.getNama(), sy3.getHarga(), sy3.getStok());
        System.out.printf("%-14s %-20s %-18s %s\n", sy4.getKode(), sy4.getNama(), sy4.getHarga(), sy4.getStok());
        System.out.println("==================================================================");
    }

    public static void daftarbumbumasak() {
        System.out.println("==================================================================");
        System.out.println("                   DAFTAR PRODUK (BUMBU MASAK)                    ");
        System.out.println("==================================================================");
        System.out.printf("%-14s %-20s %-18s %s\n", "KODE PRODUK", "NAMA PRODUK", "HARGA PRODUK", "STOK");
        System.out.printf("%-14s %-20s %-18s %s\n", bm1.getKode(), bm1.getNama(), bm1.getHarga(), bm1.getStok());
        System.out.printf("%-14s %-20s %-18s %s\n", bm2.getKode(), bm2.getNama(), bm2.getHarga(), bm2.getStok());
        System.out.printf("%-14s %-20s %-18s %s\n", bm3.getKode(), bm3.getNama(), bm3.getHarga(), bm3.getStok());
        System.out.printf("%-14s %-20s %-18s %s\n", bm4.getKode(), bm4.getNama(), bm4.getHarga(), bm4.getStok());
        System.out.println("==================================================================");
    }
    
    public static String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
