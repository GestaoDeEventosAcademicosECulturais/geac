package br.com.geac.backend.Infrastructure.Repositories;

import br.com.geac.backend.Aplication.DTOs.Reponse.OrganizerResponseDTO;
import br.com.geac.backend.Domain.Entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer, UUID> {
    boolean existsByName(String name);

    List<Organizer> findAllByIdIn(Collection<UUID> ids);
}