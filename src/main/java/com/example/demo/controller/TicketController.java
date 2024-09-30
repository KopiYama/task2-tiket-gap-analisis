package com.example.demo.controller;

import com.example.demo.dto.MessagesResponse;
import com.example.demo.model.Ticket;
import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<MessagesResponse> getAllTickets() {
        List<Ticket> tickets = ticketService.getAllTickets();
        return new ResponseEntity<>(
                new MessagesResponse("Tickets retrieved successfully", 200, "SUCCESS", tickets),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<MessagesResponse> createTicket(@RequestBody Ticket ticket) {
        Ticket newTicket = ticketService.createTicket(ticket);
        return new ResponseEntity<>(
                new MessagesResponse("Ticket created successfully", 201, "SUCCESS", newTicket),
                HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessagesResponse> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return new ResponseEntity<>(
                new MessagesResponse("Ticket deleted successfully", 200, "SUCCESS"),
                HttpStatus.OK
        );
    }
}
