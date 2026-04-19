package com.example.demo.controller;

import com.example.demo.dto.GadgetDto;
import com.example.demo.model.Gadget;
import com.example.demo.repository.GadgetRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/gadgets")
public class GadgetController {

    private final GadgetRepository repository;

    public GadgetController(GadgetRepository repository) {
        this.repository = repository;
    }

    // Danh sách + tìm kiếm
    @GetMapping
    public String list(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        var gadgets = repository.search(keyword);
        model.addAttribute("gadgets", gadgets);
        model.addAttribute("keyword", keyword);
        return "gadget-list";
    }

    // Form thêm mới
    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("gadget", new GadgetDto());
        return "gadget-form";
    }

    // Lưu (thêm mới hoặc cập nhật)
    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("gadget") GadgetDto gadgetDto,
                       BindingResult result) {
        if (result.hasErrors()) {
            return "gadget-form";
        }
        Gadget gadget = new Gadget(
                gadgetDto.getId(),
                gadgetDto.getProductName(),
                gadgetDto.getBrand(),
                gadgetDto.getStockQuantity(),
                gadgetDto.getProductImage()
        );
        repository.save(gadget);
        return "redirect:/gadgets";
    }

    // Form chỉnh sửa
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        Gadget gadget = repository.findById(id);
        if (gadget == null) {
            return "redirect:/gadgets";
        }
        GadgetDto dto = new GadgetDto(
                gadget.getId(),
                gadget.getProductName(),
                gadget.getBrand(),
                gadget.getStockQuantity(),
                gadget.getProductImage()
        );
        model.addAttribute("gadget", dto);
        return "gadget-form";
    }

    // Xóa
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.delete(id);
        return "redirect:/gadgets";
    }
}