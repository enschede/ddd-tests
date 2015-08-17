package app.context;

import app.context.Entity;
import app.domainevents.DomainEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marc on 03/08/15.
 */
public class EventSourcingEntity extends Entity {

    private List<DomainEvent> domainEvents = new ArrayList<>();
    
    public void addEvent(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

    @Override
    public String toString() {
        return "EventSourcingEntity{" +
                "domainEvents=" + domainEvents +
                "} " + super.toString();
    }
}
