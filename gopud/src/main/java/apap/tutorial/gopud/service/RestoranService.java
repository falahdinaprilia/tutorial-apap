package apap.tutorial.gopud.service;


import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;

public interface RestoranService {
    //Method untuk menambahkan Restoran
    void addRestoran(RestoranModel restoran);

    //Method untuk mendapatkan semua data Restoran yang tersimpan
    List<RestoranModel> getRestoranList();

    //Method untuk mendapatkan data sebuah Restoran berdasarkan idRestoran
    RestoranModel getRestoranByIdRestoran(String idRestoran);

    // Method untuk update nomor telepon
    void ubahNomorTelepon(RestoranModel restoran, Integer nomorTeleponBaru);

    //Method untuk menghapus restoran
    void hapusRestoran(RestoranModel restoran);
}
