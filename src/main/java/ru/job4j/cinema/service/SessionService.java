package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.model.Session;
import ru.job4j.cinema.store.SessionStore;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
@Service
public class SessionService {
    private final Map<Integer, Session> session = new ConcurrentHashMap<>();

    public SessionService() {
        session.put(1, new Session(1, "Круиз по джунглям"));
        session.put(2, new Session(2, "Красное уведомление"));
        session.put(3, new Session(3, "Главный герой"));
    }

    public List<Session> getAllSession() {
        return new ArrayList<>(session.values());
    }

    public Session findById(int id) {
        return session.get(id);
    }
}
