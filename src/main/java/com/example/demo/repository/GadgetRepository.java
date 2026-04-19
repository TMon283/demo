package com.example.demo.repository;

import com.example.demo.model.Gadget;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GadgetRepository {
    private final Map<Long, Gadget> gadgets = new HashMap<>();
    private Long counter = 1L;

    public List<Gadget> findAll() {
        return new ArrayList<>(gadgets.values());
    }

    public Gadget findById(Long id) {
        return gadgets.get(id);
    }

    public void save(Gadget gadget) {
        if (gadget.getId() == null) {
            gadget.setId(counter++);
        }
        gadgets.put(gadget.getId(), gadget);
    }

    public void delete(Long id) {
        gadgets.remove(id);
    }

    public List<Gadget> search(String keyword) {
        if (keyword == null || keyword.isBlank()) return findAll();
        String lower = keyword.toLowerCase();
        return gadgets.values().stream()
                .filter(g -> g.getProductName().toLowerCase().contains(lower)
                        || g.getBrand().toLowerCase().contains(lower))
                .toList();
    }
}
