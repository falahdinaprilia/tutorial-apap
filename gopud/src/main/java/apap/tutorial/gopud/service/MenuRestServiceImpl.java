package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;
import apap.tutorial.gopud.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    private final WebClient webClient;

    @Autowired
    private MenuDB menuDB;
    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDB.save(menu);
    }

    @Override
    public List<MenuModel> retriveListMenu() {
        return menuDB.findAll();
    }

    @Override
    public MenuModel getMenuById(Long menuId) {
        return menuDB.findById(menuId).get();
    }

    @Override
    public MenuModel changeMenu(Long menuId, MenuModel menuUpdate) {
        MenuModel menu = getMenuById(menuId);
        menu.setNama(menuUpdate.getNama());
        menu.setHarga(menuUpdate.getHarga());
        menu.setDurasiMasak(menuUpdate.getDurasiMasak());
        menu.setDeskripsi(menuUpdate.getDeskripsi());
        return menuDB.save(menu);
    }

    @Override
    public void deleteMenu(Long menuId) {
        MenuModel menu = getMenuById(menuId);
        menuDB.delete(menu);
    }

    @Override
    public Mono<String> getStatus(String ingredients) {
        return this.webClient.get().uri("https://api.spoonacular.com/recipes/search?excludeIngredients=" + ingredients + "&apiKey=284b6b4b234843caa32353fc67dcbb00")
                .retrieve().bodyToMono(String.class);
    }

    public MenuRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.recipeUrl).build();
    }
}
