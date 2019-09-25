package apap.tutorial.gopud.service;

import apap.tutorial.gopud.exceptions.IdRestorantNotFound;
import apap.tutorial.gopud.model.RestoranModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        return null;
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        RestoranModel resto = null;
        for (RestoranModel restoran : listRestoran) {
            Long id = restoran.getIdRestoran();
            if (id.equals(idRestoran)) {
                resto = restoran;
            }
        }
        if (resto == null) {
            throw new IdRestorantNotFound("Restoran tidak ditemukan.");
        }
        return null;
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
