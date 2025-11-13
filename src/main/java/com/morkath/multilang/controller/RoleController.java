package com.morkath.multilang.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.morkath.multilang.core.BaseController;
import com.morkath.multilang.dto.AuthRoleDTO;
import com.morkath.multilang.service.PermissionService;
import com.morkath.multilang.service.RoleService;

@Controller
@RequestMapping("/admin/roles")
public class RoleController extends BaseController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("roles", roleService.getAllRoles());
        model.addAttribute("permissions", permissionService.getAllPermissions());
        model.addAttribute("roleForm", new AuthRoleDTO());
        preparePage(model, "pages/role/index", "Role Management");
        return "layouts/vertical";
    }

    @PreAuthorize("hasAuthority('role:write')")
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("roleForm", new AuthRoleDTO());
        model.addAttribute("permissions", permissionService.getAllPermissions());
        preparePage(model, "pages/role/create", "Create Role");
        return "layouts/vertical";
    }

    @PreAuthorize("hasAuthority('role:write')")
    @PostMapping("/create")
    public String createRole(
            @Valid @ModelAttribute("roleForm") AuthRoleDTO roleForm,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("permissions", permissionService.getAllPermissions());
            preparePage(model, "pages/role/create", "Create Role");
            return "layouts/vertical";
        }
        roleService.createRole(roleForm);
        return "redirect:/admin/roles";
    }
}