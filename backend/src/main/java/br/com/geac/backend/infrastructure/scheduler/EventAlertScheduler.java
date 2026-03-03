package br.com.geac.backend.infrastructure.scheduler;

import br.com.geac.backend.aplication.services.EventService;
import br.com.geac.backend.aplication.services.NotificationService;
import br.com.geac.backend.infrastructure.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class EventAlertScheduler {

    private final EventService eventService;
    private final EventRepository eventRepository;
   // private final RegistrationService registrationService;
    private final NotificationService notificationService;

 // @Scheduled(cron = "0 0 * * * *")
 // public void checkCloseEvents() {
 //     LocalDateTime now = LocalDateTime.now();
 //     LocalDateTime eventTimeCheck = now.plusHours(24);

 //     List<Event> closeEvents = eventService.getEventsBetween(now, eventTimeCheck);

 //     for (Event event : closeEvents) {

 //         var registrationsByEvent = registrationService.getUnotifiedRegistrationsById(event.getId());
 //         if (registrationsByEvent.isEmpty()) {
 //             continue;
 //         }
 //         List<User> users = registrationsByEvent.stream()
 //                 .map(Registration::getUser)
 //                 .toList();

 //         notificationService.notifyAll(users, event);
 //         registrationsByEvent.forEach(registration -> registration.setNotified(true));
 //         registrationService.saveAll(registrationsByEvent);


 //     }


 // }


}
