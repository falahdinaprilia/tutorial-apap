package apap.tutorial.gopud.service;

import apap.tutorial.gopud.exceptions.IdRestorantNotFound;
import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    //Constructor
    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

    @Override
    public void addRestoran(RestoranModel restoran) {
        listRestoran.add(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return listRestoran;
    }

    @Override
    public RestoranModel getRestoranByIdRestoran(String idRestoran) {
        RestoranModel resto = null;
        for (RestoranModel restoran : listRestoran) {
            String id = restoran.getIdRestoran();
            if (id.equals(idRestoran)) {
                resto = restoran;
            }
        }
        if (resto == null) {
            throw new IdRestorantNotFound("Restoran tidak ditemukan.");
        }
        return resto;
    }

    @Override
    public void ubahNomorTelepon(RestoranModel restoran, Integer nomorTeleponBaru) {
        restoran.setNomorTelepon(nomorTeleponBaru);
    }

    @Override
    public void hapusRestoran(RestoranModel restoran) {
        listRestoran.remove(restoran);
    }
}
