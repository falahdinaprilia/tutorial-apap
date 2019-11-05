package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import reactor.core.publisher.Mono;

import java.util.List;

public interface MenuRestService {
    MenuModel createMenu(MenuModel menu);
    List<MenuModel> retriveListMenu();
    MenuModel getMenuById(Long menuId);
    MenuModel changeMenu(Long menuId, MenuModel menuUpdate);
    void deleteMenu(Long menuId);

    Mono<String> getStatus(String ingredient);
}
