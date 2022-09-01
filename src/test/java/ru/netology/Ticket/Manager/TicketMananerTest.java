package ru.netology.Ticket.Manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.Ticket.Repository.TicketRepository;
import ru.netology.Ticket.Ticket;
import ru.netology.Ticket.TicketByPriceAscComparator;

public class TicketMananerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketByPriceAscComparator priceComparator = new TicketByPriceAscComparator();

    Ticket ticket1 = new Ticket(1, 200, "MSK", "SPB");
    Ticket ticket2 = new Ticket(2, 100, "MSK", "SPB");
    Ticket ticket3 = new Ticket(3, 300, "MSK", "SPB");
    Ticket ticket4 = new Ticket(4, 100, "MSK", "SPB");
    Ticket ticket5 = new Ticket(5, 350, "MSK", "SPB");
    Ticket ticket6 = new Ticket(6, 250, "MSK", "SPB");
    Ticket ticket7 = new Ticket(7, 400, "SPB", "MSK");

    @Test
    public void shouldFindTicket () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket [] expected = {ticket2, ticket4,ticket1,ticket6,ticket3,ticket5};
        Ticket [] actual = manager.searchBy("MSK", "SPB", priceComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldFindOneTicket () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket [] expected = {ticket7};
        Ticket [] actual = manager.searchBy("SPB", "MSK", priceComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindTicket () {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Ticket [] expected = { };
        Ticket [] actual = manager.searchBy("SPB", "SPB", priceComparator);
        Assertions.assertArrayEquals(expected, actual);
    }
}
