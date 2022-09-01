package ru.netology.Ticket.Repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket.Ticket;

public class TicketRepositoryTest {

    TicketRepository repo = new TicketRepository();


    Ticket ticket1 = new Ticket(1, 200, "MSK", "SPB");
    Ticket ticket2 = new Ticket(2, 100, "MSK", "SPB");
    Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB");
    Ticket ticket4 = new Ticket(4, 100, "MSK", "SPB");
    Ticket ticket5 = new Ticket(5, 350, "SPB", "MSK");

    @Test
    public void shouldRemoveById() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.save(ticket4);
        repo.save(ticket5);
        repo.removeById(ticket2.getId());
        Ticket[] expected = {ticket4, ticket1, ticket3, ticket5};
        Ticket[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}
