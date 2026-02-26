package br.com.geac.backend.repositories;

import br.com.geac.backend.domain.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {

    boolean existsByZipCodeAndNumber(String zipCode, String number);

    List<Location> findByNameContainingIgnoreCaseOrCityContainingIgnoreCase(String name, String city);
}