package br.com.geac.backend.aplication.mappers;

import br.com.geac.backend.aplication.dtos.response.LocationResponseDTO;
import br.com.geac.backend.domain.Entities.Location;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LocationMapper {
    LocationResponseDTO toDto (Location location);

}
