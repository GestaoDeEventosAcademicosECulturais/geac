package br.com.geac.backend.aplication.mappers;

import br.com.geac.backend.aplication.dtos.response.EventResponseDTO;
import br.com.geac.backend.domain.entities.Event;
import br.com.geac.backend.domain.entities.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring", uses = {LocationMapper.class})
public interface EventMapperr {

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "organizerName", source = "organizer.name")
    @Mapping(target = "organizerEmail", source = "organizer.email")
    @Mapping(target = "reqId", source = "requirement.id")

    @Mapping(target = "requirementDescription", source = "event", qualifiedByName = "mapRequirementDescription")
    @Mapping(target = "speakers", source = "event", qualifiedByName = "mapSpeakers")

    EventResponseDTO toResponseDTO(Event event);

    @Named("mapRequirementDescription")
    default List<String> mapRequirementDescription(Event event) {
        if (event.getRequirement() == null || event.getRequirement().getDescription() == null) {
            return List.of();
        }
        return List.of(event.getRequirement().getDescription());
    }
    @Named("mapSpeakers")
    default List<String> resolveSpeakers(Event event) {
        return List.of("Palestrante 1", "Palestrante 2");
    }
    default List<String> mapTags(Set<Tag> tags) {
        if (tags == null) return List.of();
        return tags.stream().map(Tag::getName).toList();
    }
}