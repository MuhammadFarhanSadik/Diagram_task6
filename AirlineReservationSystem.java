
package farhans.diagram_task2;

import java.util.Scanner;

class Flight {
    private String number;
    private String route;

    public Flight(String number, String route) {
        this.number = number;
        this.route = route;
    }

    public String getNumber() {
        return number;
    }

    public String getRoute() {
        return route;
    }
}

class FlightList {
    private Flight[] flights;

    public FlightList() {
        flights = new Flight[] {
            new Flight("BG101", "Dhaka to Chittagong"),
            new Flight("BG202", "Dhaka to Cox's Bazar"),
            new Flight("BG303", "Dhaka to Sylhet"),
            new Flight("BG404", "Dhaka to Barisal"),
            new Flight("BG505", "Dhaka to Rajshahi")
        };
    }

    public void showFlights() {
        System.out.println("\nAvailable Flights:");
        for (Flight f : flights) {
            System.out.println("- " + f.getNumber() + " : " + f.getRoute());
        }
    }

    public Flight findFlight(String number) {
        for (Flight f : flights) {
            if (f.getNumber().equalsIgnoreCase(number)) {
                return f;
            }
        }
        return null;
    }
}

class Passenger {
    private int id;
    private String name;

    public Passenger(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class Reservation {
    private Passenger passenger;
    private Flight flight;

    public Reservation(Passenger passenger, Flight flight) {
        this.passenger = passenger;
        this.flight = flight;
    }

    public void showTicket() {
        System.out.println("\nReservation Confirmed!");
        System.out.println("Passenger ID: " + passenger.getId());
        System.out.println("Passenger Name: " + passenger.getName());
        System.out.println("Flight Number: " + flight.getNumber());
        System.out.println("Destination: " + flight.getRoute());
    }
}

public class AirlineReservationSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        FlightList flightList = new FlightList();

        System.out.println("=== Airline Reservation System ===");
        flightList.showFlights();

        System.out.print("\nEnter Flight Number: ");
        String flightNumber = input.nextLine();

        Flight selectedFlight = flightList.findFlight(flightNumber);

        if (selectedFlight != null) {
            System.out.print("Enter Passenger ID: ");
            int passengerId = input.nextInt();
            input.nextLine(); // consume leftover newline

            System.out.print("Enter Passenger Name: ");
            String passengerName = input.nextLine();

            Passenger passenger = new Passenger(passengerId, passengerName);
            Reservation reservation = new Reservation(passenger, selectedFlight);

            reservation.showTicket();
        } else {
            System.out.println("❌ Flight not found.");
        }

        input.close();
    }
}

