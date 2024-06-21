# TUGAS FINAL PROJECT AKHIR SEMESTER
## Nama Anggota Kelompok
1. Afiana Nurani		      (23082010162)
2. Nalendra Pradipta Loka (23082010196)
3. Erwin Gilang Samudra 	(23082010197)
## Deskripsi 
Program ini diasumsikan untuk mengelola data order penjualan secara online di sebuah warung/toko Usaha Mikro Kecil Menengah (UMKM). 
Transaksi penjualan dikelola dengan menggunakan prinsip antrian (queue); dimana secara default, transaksi yang masuk lebih awal akan diproses terlebih dulu. 
Program ini menggunakan tipe data abstrak single Linked List. Data produk yang dijual disimpan di cProduk yang memiliki class anak cSayuran dan cBumbuMasak. 
Untuk objek produknya di deklarasi tanpa menggunakan array di class main AppKasir; 4 produk Sayuran dan 4 produk Bumbu Masakan.
### Fitur
Aplikasi ini memiliki 3 pilihan menu user antara lain:
1. Pembeli : diikuti pengisian data nama disertai alamat. Terdapat menu tambah Produk, Hapus Produk, Lihat Keranjang, dan Selesai
2. Member : diikuti pengecekan ID dan password. Untuk pembeli yang terdaftar sebagai member memiliki hak khusus yaitu, setiap penambahan Produk yang dilakukan user member akan otomatis diberi diskon 5%, serta terdapat menu tambahan yaitu ubah password.
3. Admin : diikuti pengecekan ID dan password. menu ini bertugas untuk memproses satu per satu antrian transaksi yang statusnya masih belum diproses (0); dengan memilih 1 (diproses) atau 2 (keluar dari akun Admin). 
4. Owner : diikuti pengecekan ID dan password. menu bakan menampilkan Total nilai order penjualan yang sudah diproses user admin dan Total nilai order penjualan yang belum diproses user admin.
### Fitur Tambahan
1. Pada menu user Admin, program akan menampilkan seluruh data transaksi yang belum diproses dan menampilkan jumlah transaksi yang dilakukan dalam satu kali transaksi.
2. Pada menu user Owner, terdapat menu Ubah Detail Produk yang dapat digunakan untuk mengubah harga dan stok produk yang dijual.
3. Pada menu user Owner, terdapat menu Total Pendapatan Harian yang akan menampilkan total nilai penjualan masing-masing produk.
4. Pada menu user Owner, terdapat menu Rekapitulasi Belanja Member yang akan menampilkan rekap total biaya belanja untuk pembeli yang terdaftar sebagai member.
5. Pada menu user Owner, terdapat menu Grafik Penjualan yang akan menampilkan grafik penjualan untuk setiap barang dengan skala puluhan ribu (pembulatan ke bawah; grafik diwakili karakter “X” yang akan bertambah ke samping kanan).
