package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.awt.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {

    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDB menuDB;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setId(1L);
        newMenu.setNama("ayamgoreng");
        newMenu.setHarga(BigInteger.valueOf(15000));
        newMenu.setDurasiMasak(15);
        newMenu.setDeskripsi("ya dimasak");
        menuService.addMenu(newMenu);
        verify(menuDB, times(1)).save(newMenu);
    }

    @Test
    public void whenGetMenuListCalledItShouldReturnAllMenu() {
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when (menuService.findAllMenuByIdRestoran(1L)).thenReturn(allMenuInDatabase);
        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDB, times(1)).findByRestoranIdRestoran(1L);
    }

    @Test
    public void whenGetMenuByIdCalledByExistingDataItShouldReturnCorrectData() {
        MenuModel returnedData = new MenuModel();
        returnedData.setId(1L);
        returnedData.setNama("ikan");
        returnedData.setHarga(BigInteger.valueOf(10000));
        returnedData.setDurasiMasak(10);
        returnedData.setDeskripsi("ini tuh ikan");

        when(menuService.getMenuById(1L)).thenReturn(Optional.of(returnedData));
        Optional<MenuModel> dataFromServiceCall = menuService.getMenuById(1L);
        verify(menuDB, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());
        MenuModel dataFromOptional = dataFromServiceCall.get();
        assertEquals("ikan", dataFromOptional.getNama());
        assertEquals(BigInteger.valueOf(10000), dataFromOptional.getHarga());
        assertEquals(Integer.valueOf(10), dataFromOptional.getDurasiMasak());
        assertEquals("ini tuh ikan", dataFromOptional.getDeskripsi());
    }

    @Test
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updateData = new MenuModel();
        updateData.setId(1L);
        updateData.setNama("sapi");
        updateData.setHarga(BigInteger.valueOf(12000));
        updateData.setDurasiMasak(10);
        updateData.setDeskripsi("ini sapi enak");
        when(menuDB.findById(1L)).thenReturn(Optional.of(updateData));
        when(menuService.changeMenu(updateData)).thenReturn(updateData);
        MenuModel dataFromServiceCall = menuService.changeMenu(updateData);
        assertEquals(Long.valueOf(1L), dataFromServiceCall.getId());
        assertEquals("sapi", dataFromServiceCall.getNama());
        assertEquals(BigInteger.valueOf(12000), dataFromServiceCall.getHarga());
        assertEquals(Integer.valueOf(10), dataFromServiceCall.getDurasiMasak());
        assertEquals("ini sapi enak", dataFromServiceCall.getDeskripsi());
    }

    @Test
    public void whenChangeMenuCalledbutMenuNotFound() {
        MenuModel updateData = new MenuModel();
        updateData.setId(1L);
        when(menuDB.findById(1L)).thenReturn(Optional.of(updateData));
        when(menuService.changeMenu(updateData)).thenThrow(new NullPointerException());
        assertNull(menuService.changeMenu(updateData));
    }

    @Test
    public void whenDeleteMenuCalledItShouldDeleteMenuData() {
        MenuModel newMenu = new MenuModel();
        newMenu.setId(1L);
        newMenu.setNama("ayamgoreng");
        newMenu.setHarga(BigInteger.valueOf(15000));
        newMenu.setDurasiMasak(15);
        newMenu.setDeskripsi("ya dimasak");
        menuService.deleteMenu(newMenu);
        verify(menuDB, times(1)).delete(newMenu);
    }

    @Test
    public void whenGetListMenuOrderByHargaAscItShouldReturnAllMenuOrderByHargaAsc() {
        List<MenuModel> allMenuInDatabase = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            allMenuInDatabase.add(new MenuModel());
        }
        when (menuService.getListMenuOrderByHargaAsc(1L)).thenReturn(allMenuInDatabase);
        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(1L);
        assertEquals(3, dataFromServiceCall.size());
        verify(menuDB, times(1)).findByRestoranIdRestoranOrderByHargaAsc(1L);
    }
}
