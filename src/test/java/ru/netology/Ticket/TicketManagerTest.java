package ru.netology.Ticket;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class TicketManagerTest {

    @Test
    public void sortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "NNov", 300, 9, 13);
        Ticket ticket2 = new Ticket("SPB", "NNov", 100, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 400, 13, 15);
        Ticket ticket4 = new Ticket("SPB", "NNov", 200, 15, 20);
        Ticket ticket5 = new Ticket("SPB", "NNov", 500, 12, 13);
        Ticket ticket6 = new Ticket("SPB", "NNov", 250, 18, 21);
        Ticket ticket7 = new Ticket("UFA", "NNov", 350, 14, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 300, 9, 10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("SPB", "NNov");
        Ticket[] expected = {ticket2, ticket4, ticket6, ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "NNov", 300, 9, 13);
        Ticket ticket2 = new Ticket("SPB", "NNov", 100, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 400, 13, 15);
        Ticket ticket4 = new Ticket("SPB", "NNov", 200, 15, 20);
        Ticket ticket5 = new Ticket("SPB", "NNov", 500, 12, 13);
        Ticket ticket6 = new Ticket("SPB", "NNov", 250, 18, 21);
        Ticket ticket7 = new Ticket("UFA", "NNov", 350, 14, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 300, 9, 10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("UFA", "NNov");
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortNullTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "NNov", 300, 9, 13);
        Ticket ticket2 = new Ticket("SPB", "NNov", 100, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 400, 13, 15);
        Ticket ticket4 = new Ticket("SPB", "NNov", 200, 15, 20);
        Ticket ticket5 = new Ticket("SPB", "NNov", 500, 12, 13);
        Ticket ticket6 = new Ticket("SPB", "NNov", 250, 18, 21);
        Ticket ticket7 = new Ticket("UFA", "NNov", 350, 14, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 300, 9, 10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "FRA");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsWitchCorporator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "NNov", 300, 9, 13);
        Ticket ticket2 = new Ticket("SPB", "NNov", 100, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 400, 13, 15);
        Ticket ticket4 = new Ticket("SPB", "NNov", 200, 15, 20);
        Ticket ticket5 = new Ticket("SPB", "NNov", 500, 12, 13);
        Ticket ticket6 = new Ticket("SPB", "NNov", 250, 18, 21);
        Ticket ticket7 = new Ticket("UFA", "NNov", 350, 14, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 300, 9, 10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("SPB", "NNov", comparator);
        Ticket[] expected = {ticket5, ticket2, ticket6, ticket1, ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsWithNullCorporator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "NNov", 300, 9, 13);
        Ticket ticket2 = new Ticket("SPB", "NNov", 100, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 400, 13, 15);
        Ticket ticket4 = new Ticket("SPB", "NNov", 200, 15, 20);
        Ticket ticket5 = new Ticket("SPB", "NNov", 500, 12, 13);
        Ticket ticket6 = new Ticket("SPB", "NNov", 250, 18, 21);
        Ticket ticket7 = new Ticket("UFA", "NNov", 350, 14, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 300, 9, 10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "FRA", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortTicketsWitchOneCorporator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("SPB", "NNov", 300, 9, 13);
        Ticket ticket2 = new Ticket("SPB", "NNov", 100, 10, 12);
        Ticket ticket3 = new Ticket("SPB", "MSK", 400, 13, 15);
        Ticket ticket4 = new Ticket("SPB", "NNov", 200, 15, 20);
        Ticket ticket5 = new Ticket("SPB", "NNov", 500, 12, 13);
        Ticket ticket6 = new Ticket("SPB", "NNov", 250, 18, 21);
        Ticket ticket7 = new Ticket("UFA", "NNov", 350, 14, 15);
        Ticket ticket8 = new Ticket("MSK", "SPB", 300, 9, 10);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("UFA", "NNov", comparator);
        Ticket[] expected = {ticket7};

        Assertions.assertArrayEquals(expected, actual);
    }
}
