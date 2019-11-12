package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.PasswordModel;
import apap.tutorial.gopud.model.UserModel;
import apap.tutorial.gopud.service.RoleService;
import apap.tutorial.gopud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user, @ModelAttribute PasswordModel password, Model model, Principal principal) {
        String passwordMessage = "";
        if (userService.getUserByUsername(user.getUsername()) == null) {
            if (user.getPassword().equals(password.getConfirmPassword())) {
                if (userService.validatePasswordDemo(user.getPassword())) {
                    userService.addUser(user);
                    passwordMessage = "User berhasil ditambahkan!";
                    model.addAttribute("success", true);

                } else {
                    passwordMessage = "Password yang dimasukkan harus terdiri atas angka dan huruf serta minimal memiliki 10 karakter!";
                    model.addAttribute("success", false);
                }
            }
            else {
                passwordMessage = "Password yang dimasukkan tidak sesuai dengan konfirmasi password Anda!";
                model.addAttribute("success", false);
            }
        } else{
            passwordMessage = "Username sudah ada!";
            model.addAttribute("success", false);
        }
        model.addAttribute("user", userService.getUserByUsername(principal.getName()).getRole().getRole());
        model.addAttribute("message", passwordMessage);
        model.addAttribute("listRole", roleService.findAll());
        return "home";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String updatePassword(Model model) {
        return "update-password";
    }

    @PostMapping("/updatePassword")
    private String updatePasswordSubmit(@ModelAttribute PasswordModel password, RedirectAttributes redir) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        UserModel user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        String passwordMessage = "";

        if (password.getNewPassword().equals(password.getConfirmPassword())) {
            if (passwordEncoder.matches(password.getOldPassword(), user.getPassword())) {

                if (userService.validatePassword(password.getNewPassword())) {
                    String newPassword = password.getNewPassword();
                    userService.updatePassword(user, newPassword);
                    passwordMessage = "Password Anda berhasil diubah!";
                    redir.addFlashAttribute("success", true);

                } else {
                    passwordMessage = "Password yang dimasukkan harus terdiri atas angka dan huruf serta minimal memiliki 8 karakter!";
                    redir.addFlashAttribute("success", false);
                }

            } else {
                passwordMessage = "Password yang dimasukkan tidak sesuai dengan password lama Anda!";
                redir.addFlashAttribute("success", false);
            }

        } else {
            passwordMessage = "Harap isi konfirmasi password sesuai dengan password baru Anda!";
            redir.addFlashAttribute("success", false);
        }

        redir.addFlashAttribute("passwordMessage", passwordMessage);
        return "redirect:/user/updatePassword";
    }
}
