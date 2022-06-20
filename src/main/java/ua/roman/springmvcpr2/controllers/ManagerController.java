package ua.roman.springmvcpr2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.roman.springmvcpr2.dao.CurrencyDAO;
import ua.roman.springmvcpr2.models.Currency;

import javax.validation.Valid;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    private final CurrencyDAO currencyDAO;

    @Autowired
    public ManagerController(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("currency", currencyDAO.index());
        return "manager/index";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("currency", currencyDAO.show(id));
        return "manager/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("currency") @Valid Currency currency, BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) return "manager/edit";
        currencyDAO.change(id, currency);
        return "redirect:/manager";
    }

}
