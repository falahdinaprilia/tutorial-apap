package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuRestService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class MenuRestController {
    @Autowired
    private MenuRestService menuRestService;

    @PostMapping(value = "/menu")
    private MenuModel createMenu(@Valid @RequestBody MenuModel menu, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else {
            return
                    menuRestService.createMenu(menu);
        }
    }

    @GetMapping(value = "/menu/{menuId}")
    private MenuModel retriveMenu(@PathVariable("menuId") Long menuId) {
        try {
            return  menuRestService.getMenuById(menuId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Menu " + String.valueOf(menuId) + " Not Found");
        }
    }

    @DeleteMapping(value = "/menu/{menuId}")
    private ResponseEntity<String> deleteMenu(@PathVariable("menuId") Long menuId) {
        try {
            menuRestService.deleteMenu(menuId);
            return ResponseEntity.ok("Menu with ID " + String.valueOf(menuId) + " Deleted!");
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Menu with ID " + String.valueOf(menuId) + " Not Found!");
        }
    }

    @PutMapping(value = "/menu/{menuId}")
    private MenuModel updateMenu(
            @PathVariable (value = "menuId") Long menuId,
            @RequestBody MenuModel menu
    ) {
        try {
            return menuRestService.changeMenu(menuId, menu);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Menu with ID " + String.valueOf(menuId) + " Not Found!");
        }
    }

    @GetMapping(value = "/menus")
    private List<MenuModel> retriveListMenu() {
        return menuRestService.retriveListMenu();
    }

    @GetMapping(value = "/recipe/excludeIngredients={ingredient}")
    private Mono<String> getStatus(@PathVariable String ingredient) {
        return menuRestService.getStatus(ingredient);
    }

}
