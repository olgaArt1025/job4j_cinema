package ru.job4j.cinema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.job4j.cinema.model.Ticket;
import ru.job4j.cinema.model.User;
import ru.job4j.cinema.service.SessionService;
import ru.job4j.cinema.service.TicketService;

import javax.servlet.http.HttpSession;

@Controller
public class TicketController {

    private final TicketService service;
    private final SessionService sessionService;

    public TicketController(TicketService service, SessionService sessionService) {
        this.service = service;
        this.sessionService = sessionService;
    }

    @GetMapping("/tickets")
    public String tickets(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setUsername("Гость");
        }
        model.addAttribute("user", user);
        model.addAttribute("tickets", service.findAll());
        return "tickets";
    }

    @GetMapping("/addTicket")
    public String addTicket(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setUsername("Гость");
        }
        model.addAttribute("user", user);
       model.addAttribute("session", sessionService.getAllSession());
        return "addTicket";
    }

    @PostMapping("/createTicket")
    public String createTicket(@ModelAttribute Ticket ticket) {
        service.add(ticket);
        return "redirect:/tickets";
    }
}
