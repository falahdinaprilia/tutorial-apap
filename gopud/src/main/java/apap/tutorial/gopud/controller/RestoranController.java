package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.exceptions.IdRestorantNotFound;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;
    // URL mappinf add
    @RequestMapping("/restoran/add")
    public String add(
            //Request Parameter untuk dipass
            @RequestParam(value = "idRestoran", required = true) String idRestoran,
            @RequestParam(value = "nama", required = true) String nama,
            @RequestParam(value = "alamat", required = true) String alamat,
            @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
            Model model
            ) {
        // Membuat objek RestoranModel
        RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

        // Memanggil service addRestoran
        restoranService.addRestoran(restoran);

        // Add variabel nama restoran ke "namaResto" untuk dirender
        model.addAttribute("namaResto", nama);

        //Return view template
        return "add-restoran";
    }
    // URL mapping view
    @RequestMapping("/restoran/view")
    public String view (
            // request Parameter untuk dipass
            @RequestParam(value = "idRestoran") String idRestoran, Model model) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        // Return view template
        return "view-restoran";
    }
    // URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewall(Model model) {

        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        // Return view template
        return "viewall-restoran";
    }
    // URL mapping view
    @RequestMapping("/restoran/view/id-restoran/{idRestoran}")
    public String viewWithPathVariable (
            // Path variable untuk dipass
            @PathVariable(value = "idRestoran") String idRestoran, Model model) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        // Return view template
        return "view-restoran";
    }

    // URL mapping view
    @RequestMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTeleponBaru}")
    public String ubahNomorTelepon (
            // Path variable untuk dipass
            @PathVariable(value = "idRestoran") String idRestoran,
            @PathVariable(value = "nomorTeleponBaru") Integer nomorTeleponBaru, Model model) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        restoranService.ubahNomorTelepon(restoran, nomorTeleponBaru);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        // Return view template
        return "view-updated";
    }

    // URL mapping view
    @RequestMapping("/restoran/delete/id/{idRestoran}")
    public String hapusRestoran (
            // Path variable untuk dipass
            @PathVariable(value = "idRestoran") String idRestoran, Model model) {
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        restoranService.hapusRestoran(restoran);
        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);
        // Return view template
        return "view-deleted";
    }

    @ExceptionHandler(value = IdRestorantNotFound.class)
    public String idNotFoundHandler() {
        return "view-handler";
    }
}
