package ua.roman.springmvcpr2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.roman.springmvcpr2.dao.AvtoDAO;
import ua.roman.springmvcpr2.models.Avto;

import javax.validation.Valid;

@Controller
@RequestMapping("/seller")
public class SellerControler {
    private final AvtoDAO avtoDAO;

    @Autowired
    public SellerControler(AvtoDAO avtoDAO) {
        this.avtoDAO = avtoDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("avto", avtoDAO.index());
        return "seller/interface";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("avto", avtoDAO.show(id));
        return "seller/show";
    }

    @GetMapping("/new")
    public String newAvto(@ModelAttribute("avto") Avto avto) {
        return "seller/add";
    }

    @PostMapping()
    public String add(@ModelAttribute("avto") @Valid Avto avto,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "seller/add";
        avtoDAO.add(avto);
        return "redirect:/seller";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("avto", avtoDAO.show(id));
        return "seller/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("avto") @Valid Avto avto, BindingResult bindingResult, @PathVariable("id") int id) {
        if(bindingResult.hasErrors()) return "seller/edit";
        avtoDAO.change(id, avto);
        return "redirect:/seller";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        avtoDAO.delete(id);
        return "redirect:/seller";
    }
}
