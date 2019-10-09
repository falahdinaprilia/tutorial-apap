package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.exceptions.IdRestorantNotFound;
import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    // URL mapping yang digunakan untuk mengakses halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {

        // Membuat objek RestoranModel
        RestoranModel newRestoran = new RestoranModel();

        // Add variabel nama restoran ke "restoran" untuk dirender
        model.addAttribute("restoran", newRestoran);

        //Return view template
        return "form-add-restoran";
    }

    // URL mapping yang digunaka untuk submit form yang telah anda masukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    // URL mapping view
    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
            // request Parameter untuk dipass
            @RequestParam(value = "idRestoran") Long idRestoran, Model model) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

        List<MenuModel> menuList = menuService.getListMenuOrderByHargaAsc(restoran.getIdRestoran());
        restoran.setListMenu(menuList);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);
        model.addAttribute("listMenu", menuList);

        // Return view template
        return "view-restoran";
    }

    // API yang digunakan untuk menuju halaman form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        // Mengambil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        return "form-change-restoran";
    }

    // API yang digunakan untuk submit form change restotan
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);

        return "change-restoran";
    }

    // URL mapping viewAll
    @RequestMapping(value = "/restoran/viewall", method = RequestMethod.GET)
    public String viewall(Model model) {

        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();
        Collections.sort(listRestoran);
        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        // Return view template
        return "viewall-restoran";
    }
    // URL mapping view
    @RequestMapping("/restoran/delete/id/{idRestoran}")
    public String hapusRestoran (
        // Path variable untuk dipass
        @PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        // Mengambil objek RestoranModel yang dituju
        List<RestoranModel> listRestoran = restoranService.getRestoranList();
        boolean gaadaMenu = false;

        for (RestoranModel resto : listRestoran) {
            if (resto.getListMenu().isEmpty()) {
                gaadaMenu = true;
                restoranService.hapusRestoran(resto);
            }
        }
        if (gaadaMenu == true) {
            return "view-deleted";
        } else {
            return "peringatan-hapus-restoran";
        }
    }

    @ExceptionHandler(value = IdRestorantNotFound.class)
    public String idNotFoundHandler() {
        return "view-handler";
    }
}
//    // URL mapping view
//    @RequestMapping("/restoran/view/id-restoran/{idRestoran}")
//    public String viewWithPathVariable (
//            // Path variable untuk dipass
//            @PathVariable(value = "idRestoran") String idRestoran, Model model) {
//        // Mengambil objek RestoranModel yang dituju
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//
//        // Add model restoran ke "resto" untuk dirender
//        model.addAttribute("resto", restoran);
//
//        // Return view template
//        return "view-restoran";
//    }
//
//    // URL mapping view
//    @RequestMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTeleponBaru}")
//    public String ubahNomorTelepon (
//            // Path variable untuk dipass
//            @PathVariable(value = "idRestoran") String idRestoran,
//            @PathVariable(value = "nomorTeleponBaru") Integer nomorTeleponBaru, Model model) {
//        // Mengambil objek RestoranModel yang dituju
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
//        restoranService.ubahNomorTelepon(restoran, nomorTeleponBaru);
//
//        // Add model restoran ke "resto" untuk dirender
//        model.addAttribute("resto", restoran);
//
//        // Return view template
//        return "view-updated";
//    }
//

//
//}
