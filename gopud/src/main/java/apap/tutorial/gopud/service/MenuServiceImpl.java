package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDB menuDB;

    @Override
    public void addMenu(MenuModel menu) {
        menuDB.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(Long idRestoran) {
        return menuDB.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public Optional<MenuModel> getMenuById(Long id) {
        return menuDB.findById(id);
    }

    @Override
    public MenuModel changeMenu(MenuModel menuModel) {
        // Mengambil object restoran yang ingin diubah
        MenuModel targetMenu = menuDB.findById(menuModel.getId()).get();

        try{
            targetMenu.setNama(menuModel.getNama());
            targetMenu.setHarga(menuModel.getHarga());
            targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
            targetMenu.setDeskripsi(menuModel.getDeskripsi());
            menuDB.save(targetMenu);
            return targetMenu;
        } catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public void deleteMenu(MenuModel menu) {
        menuDB.delete(menu);
    }

    @Override
    public List<MenuModel> getListMenuOrderByHargaAsc(Long idRestoran) {
        return menuDB.findByRestoranIdRestoranOrderByHargaAsc(idRestoran);
    }
}
