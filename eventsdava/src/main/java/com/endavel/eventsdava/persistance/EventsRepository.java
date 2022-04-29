package com.endavel.eventsdava.persistance;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import com.endavel.eventsdava.domain.Event;

public interface EventsRepository extends CrudRepository<Event, UUID>{

}
