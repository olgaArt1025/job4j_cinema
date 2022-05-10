package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.store.TicketStore;

import java.util.Collection;


@ThreadSafe
@Service
public class TicketService {
    private final TicketStore store;

    public TicketService(TicketStore store) {
        this.store = store;
    }

    public Collection<Ticket> findAll() {
        return store.findAll();
    }

    public Ticket add(Ticket ticket) {
        return store.add(ticket);
    }
}
