package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MenuController {
    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

//    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
//    private String addProductFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
//        MenuModel menu = new MenuModel();
//        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
//        menu.setRestoran(restoran);
//
//        model.addAttribute("menu", menu);
//
//        return "form-add-menu";
//    }

    @RequestMapping(value = "/menu/add/{idRestoran}")
    private String add(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        RestoranModel restoran = new RestoranModel();
        restoran.setListMenu(new ArrayList<MenuModel>());
        restoran.getListMenu().add(new MenuModel());
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"addRow"})
    private String addRow(@PathVariable(value = "idRestoran") Long idRestoran,@ModelAttribute RestoranModel restoran, Model model) {
        MenuModel menu = new MenuModel();
        restoran.getListMenu().add(menu);
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"removeRow"})
    private String removeRow(@PathVariable(value = "idRestoran") Long idRestoran,@ModelAttribute RestoranModel restoran, Model model, HttpServletRequest req) {
        Integer rowId =  Integer.valueOf(req.getParameter("removeRow"));
        restoran.getListMenu().remove(rowId.intValue());
        model.addAttribute("restoran", restoran);
        model.addAttribute("idRestoran", idRestoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params= {"save"})
    private String addMenuSubmit(@PathVariable(value = "idRestoran") Long idRestoran, @ModelAttribute RestoranModel restoran, ModelMap model) {
        RestoranModel oldRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("idRestoran", idRestoran);
        for (MenuModel menu : restoran.getListMenu()) {
            menu.setRestoran(oldRestoran);
            menuService.addMenu(menu);
        }
        model.clear();
        return "add-menu";
    }

//    @RequestMapping(value = "menu/add", method = RequestMethod.POST)
//    private String addProductSubmit(@ModelAttribute MenuModel menu, Model model) {
//        menuService.addMenu(menu);
//
//        model.addAttribute("nama", menu.getNama());
//
//        return "add-menu";
//    }

    // API yang digunakan untuk menuju halaman form change restoran
    @RequestMapping(value = "menu/change/{id}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long id, Model model) {
        // Mengambil existing data restoran
        MenuModel existingMenu = menuService.getMenuById(id).get();
        model.addAttribute("menu", existingMenu);
        return "form-change-menu";
    }

    // API yang digunakan untuk submit form change restotan
    @RequestMapping(value = "menu/change/{id}", method = RequestMethod.POST)
    public String changeMenuFormSubmit(@PathVariable Long id, @ModelAttribute MenuModel menu, Model model) {
        MenuModel newMenuData = menuService.changeMenu(menu);
        model.addAttribute("menu", newMenuData);

        return "change-menu";
    }

    //URL Mapping View
    @RequestMapping(value= "/menu/delete", method = RequestMethod.POST)
    private String delete(@ModelAttribute RestoranModel restoran, Model model) {
        for (MenuModel menu : restoran.getListMenu()) {
            menuService.deleteMenu(menu);
        }
        return "delete";
    }

    // URL mapping view
//    @RequestMapping("/menu/delete/id/{id}")
//    public String hapusMenu (
//            // Path variable untuk dipass
//            @PathVariable Long id, Model model) {
//        MenuModel targetMenu = menuService.getMenuById(id).get();
//        menuService.hapusMenu(targetMenu);
//        return "hapus-menu";
//    }

}
