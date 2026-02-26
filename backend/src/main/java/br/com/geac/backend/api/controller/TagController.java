package br.com.geac.backend.api.controller;

import br.com.geac.backend.aplication.dtos.response.TagResponseDTO;
import br.com.geac.backend.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final TagRepository repository;

    @GetMapping
    public ResponseEntity<List<TagResponseDTO>> getAll() {
        List<TagResponseDTO> list = repository.findAll().stream()
                .map(tag -> new TagResponseDTO(tag.getId(), tag.getName()))
                .toList();
        return ResponseEntity.ok(list);
    }
}