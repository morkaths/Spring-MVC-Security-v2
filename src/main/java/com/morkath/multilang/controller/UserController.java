package com.morkath.multilang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.dto.AuthUserDTO;
import com.morkath.multilang.service.RoleService;
import com.morkath.multilang.service.UserService;

@Controller
@RequestMapping("/admin/users")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String index(HttpServletRequest request, Model model) {
        model.addAttribute("users", userService.getAllUsers());
        preparePage(model, "pages/user/index", "User Management");
        return "layouts/vertical";
    }

    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("userForm", new AuthUserDTO());
        model.addAttribute("roles", roleService.getAllRoles());
        preparePage(model, "pages/user/create", "Create User");
        return "layouts/vertical";
    }

    @PreAuthorize("hasAuthority('user:write')")
    @PostMapping("/create")
    public String createUser(
            @Valid @ModelAttribute("userForm") AuthUserDTO userForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            preparePage(model, "pages/user/create", "Create User");
            model.addAttribute("roles", roleService.getAllRoles());
            model.addAttribute("userForm", userForm);
            return "layouts/vertical"; // Return to form with errors
        }

        AuthUserDTO user = userService.createUser(userForm);
        if (user == null) {
            bindingResult.rejectValue("username", "error.userForm", "Không thể tạo người dùng");
            preparePage(model, "pages/user/create", "Create User");
            model.addAttribute("roles", roleService.getAllRoles());
            model.addAttribute("userForm", userForm);
            return "layouts/vertical";
        }

        return "redirect:/admin/users";
    }

    @PreAuthorize("hasAuthority('user:write')")
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        AuthUserDTO userForm = userService.getUserById(id);
        if (userForm == null) {
            return "redirect:/admin/users";
        }
        model.addAttribute("userForm", userForm);
        model.addAttribute("roles", roleService.getAllRoles());
        preparePage(model, "pages/user/edit", "Edit User");
        return "layouts/vertical";
    }

    @PreAuthorize("hasAuthority('user:write')")
    @PostMapping("/edit")
    public String editUser(
            @Valid @ModelAttribute("userForm") AuthUserDTO userForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("roles", roleService.getAllRoles());
            preparePage(model, "pages/user/edit", "Edit User");
            return "layouts/vertical";
        }
        AuthUserDTO user = userService.updateUser(userForm);
        if (user == null) {
            bindingResult.rejectValue("username", "error.userForm", "Không thể cập nhật người dùng");
            model.addAttribute("roles", roleService.getAllRoles());
            preparePage(model, "pages/user/edit", "Edit User");
            return "layouts/vertical";
        }
        return "redirect:/admin/users";
    }

    @PreAuthorize("hasAuthority('user:delete')")
    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }
}
