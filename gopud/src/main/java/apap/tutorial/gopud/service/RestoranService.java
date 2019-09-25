package apap.tutorial.gopud.service;


import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;
import java.util.Optional;

public interface RestoranService {
    //Method untuk menambahkan Restoran
    void addRestoran(RestoranModel restoran);

    //Method untuk mendapatkan semua data Restoran yang tersimpan
    List<RestoranModel> getRestoranList();

    //Method untuk mendapatkan data sebuah Restoran berdasarkan idRestoran
    Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran);
    RestoranModel changeRestoran(RestoranModel restoranModel);

    // Method untuk update nomor telepon
    void ubahNomorTelepon(RestoranModel restoran, Integer nomorTeleponBaru);

    //Method untuk menghapus restoran
    void hapusRestoran(RestoranModel restoran);
}
