package fresh.vegetables;

public class cDetailTransaksi { //queue

    cNode front, rear;
    int jumlah;

    cDetailTransaksi() {
        front = rear = null;
        jumlah = 0;
    }

    public void tambahTransaksi(cTransaksi baru) {
        cNode newNode = new cNode(baru);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public void sambungTransaksi(cNode depan, cNode belakang) {
        if (rear == null) {// ini berfungsi jika transaksi toko masih kosong
            front = depan;
            rear = belakang;
        } else {
            rear.next = depan; // berfungsi untuk sambungkan transaksi dan update posisi rear
            rear = belakang;
        }
    }

    public int keranjangpembeli() {
        int i = 1;
        int grandtotal = 0;
        cNode depan = front;
        if (depan == null) { //keranjang kosong
            System.out.println("\n==================================================================");
            System.out.println("              KERANJANG KOSONG, SILAKAN LAKUKAN PEMBELIAN           ");
            System.out.println("==================================================================");
            return i;
        }
        System.out.println("\n==================================================================");
        System.out.println("                      DAFTAR KERANJANG PEMBELI                    ");
        System.out.println("==================================================================");
        System.out.println("kode transaksi : " + depan.data.getKode());
        System.out.println("==================================================================");
        System.out.printf("%-4s %-5s %-25s %-10s %-10s %s\n", "No.","KODE", "NAMA PRODUK", "HARGA", "JUMLAH", "SUBTOTAL");
        for (cNode t = front; t != null; t = t.next) {
            System.out.printf("%-4s %-5s %-25s %-10s %-10s %s\n", i + ".",
                    t.data.getProduk().getKode(),
                    t.data.getProduk().getNama(),
                    t.data.getProduk().getHarga(),
                    t.data.getJumlah(),
                    t.data.getTotal());
            i++;
            grandtotal += t.data.getTotal();
        }
        System.out.println("==================================================================");
        System.out.printf("%53s %s\n", "TOTAL:", grandtotal);
        System.out.println("Note: satuan kode 'sy' adalah 'gram'");
        System.out.println("==================================================================");
        return i;
    }

    public int keranjangmember() {
        int i = 1;
        int grandtotal = 0;
        cNode depan = front;
        if (depan == null) { //keranjang kosong
            System.out.println("\n==================================================================");
            System.out.println("              KERANJANG KOSONG, SILAKAN LAKUKAN PEMBELIAN           ");
            System.out.println("==================================================================");
            return i;
        }
        cTransaksi transaksiPertama = depan.data;
        System.out.println("\n==================================================================");
        System.out.println("                     DAFTAR KERANJANG MEMBER                      ");
        System.out.println("==================================================================");
        System.out.println("kode transaksi : " + transaksiPertama.getKode());
        System.out.println("==================================================================");
        System.out.printf("%-4s %-5s %-25s %-10s %-10s %s\n", "No.","KODE", "NAMA PRODUK", "HARGA", "JUMLAH", "SUBTOTAL");
        for (cNode t = front; t != null; t = t.next) {
            System.out.printf("%-4s %-5s %-25s %-10s %-10s %s\n", i + ".",
                    t.data.getProduk().getKode(),
                    t.data.getProduk().getNama(),
                    t.data.getProduk().getHarga(),
                    t.data.getJumlah(),
                    t.data.getTotal());
            i++;
            grandtotal += t.data.getTotal();
        }
        System.out.println("==================================================================");
        System.out.printf("%53s %s\n", "TOTAL:", grandtotal);
        System.out.println("Note: satuan kode 'sy' adalah 'gram'");
        System.out.println("==================================================================");
        return i;
    }

    public void hapusTransaksi(int nomor) {
        cNode t = front;
        cNode prev = null;
        int i = 1;
        if (nomor == 1) {  // hapus posisi terdepan
            if (t.next == null) {
                front = rear = null;
            } else {
                front = front.next;
                t.next = null;
            }
            System.out.println("[" + t.data.getProduk().getNama() + "] dihapus....");
        } else {
            while (t != null) {
                if (i == nomor) {
                    break;
                }
                i++;
                prev = t;
                t = t.next;
            }
            if (t.next == null) {
                rear = prev;
                rear.next = null;
            } else {
                prev.next = t.next;
                t.next = null;
            }
            System.out.println("[" + t.data.getProduk().getNama() + "] dihapus....");
        }
    }

    public cNode getFront() {
        return front;
    }

    public cNode getRear() {
        return rear;
    }

    public int lihatDiproses() {
        int total = 0;
        for (cNode t = front; t != null; t = t.next) {
            if (t.data.getStatus() == 1) {
                total += t.data.getTotal();
            }
        }
        return total;
    }

    public int lihatBelumDiproses() {
        int total = 0;
        for (cNode t = front; t != null; t = t.next) {
            if (t.data.getStatus() == 0) {
                total += t.data.getTotal();
            }
        }
        return total;
    }
    
    public void transaksiBelumDiproses() {
        System.out.println("==================================================================");
        System.out.println("                         ANTRIAN TRANSAKSI                      ");
        System.out.println("==================================================================");
        System.out.printf("%-4s %-25s %s\n", "No.","KODE TRANSAKSI", "JUMLAH TRANSAKSI");
        System.out.println("==================================================================");
        int i = 1;
        cNode t = front;
        String currentKode = "";
        int quantity = 0;
        while (t!= null) {
            if (t.data.getStatus() == 0) {
                if (!t.data.getKode().equals(currentKode)) {
                    if (!currentKode.isEmpty()) {
                        System.out.printf("%-4d %-25s %d\n", i, currentKode, quantity);
                        i++;
                    }
                    currentKode = t.data.getKode();
                    quantity = 1;
                } else {
                    quantity++;
                }
            }
            t = t.next;
        }

        if (!currentKode.isEmpty()) {
            System.out.printf("%-4d %-25s %d\n", i, currentKode, quantity);
        }
        System.out.println("==================================================================");
    }    
}
