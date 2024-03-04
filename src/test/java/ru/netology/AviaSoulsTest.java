package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("Москва", "Челябинск", 2000, 17, 19);
    Ticket ticket2 = new Ticket("Москва", "Уфа", 4000, 10, 13);
    Ticket ticket3 = new Ticket("Москва", "Улан-Удэ", 8000, 8, 15);
    Ticket ticket4 = new Ticket("Москва", "Новосибирск", 6000, 11, 17);
    Ticket ticket5 = new Ticket("Москва", "Владивосток", 7500, 10, 18);
    Ticket ticket6 = new Ticket("Москва", "Сочи", 8500, 13, 17);
    Ticket ticket7 = new Ticket("Москва", "Санкт-Петербург", 2000, 19, 20);
    Ticket ticket8 = new Ticket("Москва", "Сочи", 5500, 1, 6);

    @Test
    public void compareToTestFirstBigger() {
        int expected = 1;
        int actual = ticket2.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestFirstLetter() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTestEqual() {
        int expected = 0;
        int actual = ticket1.compareTo(ticket7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchTestMany() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        Ticket[] expected = {ticket8, ticket6};
        Ticket[] actual = tickets.search("Москва", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestNull() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tickets.search("Екатеринбург", "Сочи");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTestOne() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);
        Ticket[] expected = {ticket5};
        Ticket[] actual = tickets.search("Москва", "Владивосток");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketTimeComparatorTestAll() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Arrays.sort(tickets.findAll(), timeComparator);

        Ticket[] expected = {ticket7, ticket1, ticket2, ticket6, ticket8, ticket4, ticket3, ticket5};
        Ticket[] actual = tickets.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortBy() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket6, ticket8};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Сочи", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByNull() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        TicketTimeComparator timeComparator = new TicketTimeComparator();


        Ticket[] expected = new Ticket[0];
        Ticket[] actual = tickets.searchAndSortBy("Новосибирск", "Санкт-Петербург", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchAndSortByOne() {
        AviaSouls tickets = new AviaSouls();
        tickets.add(ticket1);
        tickets.add(ticket2);
        tickets.add(ticket3);
        tickets.add(ticket4);
        tickets.add(ticket5);
        tickets.add(ticket6);
        tickets.add(ticket7);
        tickets.add(ticket8);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket5};
        Ticket[] actual = tickets.searchAndSortBy("Москва", "Владивосток", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}