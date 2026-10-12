# Concert Ticket Booking

A small interactive Java CLI that books concert tickets and uses **exceptions** to reject invalid requests, such as overbooking, zero/negative quantities, or non-numeric input

## Features

- Interactive menu: book tickets, cancel tickets, run tests, or exit
- `bookTickets()` / `cancelTickets()` throw `IllegalArgumentException` for invalid requests
- Constructor validation: a `Concert` with an empty name or negative seats can never be created
- `try-catch` keeps the program running after a failed booking or cancellation
- Handles non-numeric input with `NumberFormatException`
- 6 built-in manual tests (PASS/FAIL), runnable from the menu

## Project Structure

```
concert-ticket-booking/
├── .gitignore
├── README.md
└── src/
    ├── Concert.java         # Concert class: seats, booking logic, exceptions
    └── TicketBooking.java   # CLI menu (main) + manual tests
```

## How to Run

Requires Java (JDK 17+)

```bash
javac src/*.java
java -cp src TicketBooking
```

## Example Session

```
Welcome to Summer Jazz Night ticket booking!

Available seats: 5
1. Book tickets
2. Run tests
3. Cancel tickets
0. Exit
Choose an option: 1
How many tickets? 4
Booked 4 ticket(s) successfully!

Available seats: 1
...
Choose an option: 1
How many tickets? abcd
Please enter a whole number.
...
Choose an option: 2

--- Running tests ---
Test 1 PASS: valid booking reduces seats
Test 2 PASS: overbooking throws exception
Test 3 PASS: booking zero tickets throws exception
Test 4 PASS: negative total seats throws exception
Test 5 PASS: cancelling tickets frees up seats
Test 6 PASS: cancelling more than booked throws exception
```

## Complexity

| Operation | Time | Space |
|---|---|---|
| `getAvailableSeats()` | O(1) | O(1) |
| `bookTickets(quantity)` | O(1) | O(1) |
| `cancelTickets(quantity)` | O(1) | O(1) |

Available seats are **computed** (`totalSeats - bookedSeats`) instead of stored, so the two values can never get out of sync

## What I Learned

- **`throw` vs returning `false`:** a boolean return value can be silently ignored by the caller, but an exception cannot — if nobody catches it, the program stops.
- **Reading a stack trace:** Java prints the most recent call **first** (Python prints it last). The first `at ...` line in my own code is where to look
- **`try-catch` with multiple `catch` blocks:** `NumberFormatException` is a subclass of `IllegalArgumentException`, so it must be caught **first** — otherwise the compiler reports an unreachable catch block
- **`nextLine()` + `Integer.parseInt()` instead of `nextInt()`:** avoids the leftover-newline bug that makes the menu skip input.
- **Testing exceptions:** use a boolean flag that is set to `true` inside `catch`; the test passes only if the exception was actually thrown
- **Compare Strings with `.equals()`**, not `==`
- **Fail fast in the constructor:** throwing inside a constructor means an invalid object is never created. `name == null` is checked first because `||` short-circuits, so `.trim()` is never called on `null`.
- **Invariants:** `bookTickets()` and `cancelTickets()` together guarantee `0 ≤ bookedSeats ≤ totalSeats` no matter what the user types