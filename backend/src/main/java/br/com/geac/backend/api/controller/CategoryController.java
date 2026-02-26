package br.com.geac.backend.api.controller;

import br.com.geac.backend.aplication.dtos.response.CategoryResponseDTO;
import br.com.geac.backend.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryRepository repository;

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> getAll() {
        List<CategoryResponseDTO> list = repository.findAll().stream()
                .map(c -> new CategoryResponseDTO(c.getId(), c.getName(), c.getDescription()))
                .toList();
        return ResponseEntity.ok(list);
    }
}