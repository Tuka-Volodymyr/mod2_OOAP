package org.example;

// Інтерфейс для сучасних розеток
interface NewVagonSystem {
  void matchSocket();
}

// Сучасна система вагонів
class ModernVagon implements NewVagonSystem {
  @Override
  public void matchSocket() {
    System.out.println("Connected to the modern socket. Powering device.");
  }
}

// Стара система вагонів
class OldVagonSystem {
  public void thinSocket() {
    System.out.println("Powering device using the old narrow socket.");
  }
}

// Адаптер для старої системи
class OldToNewAdapter implements NewVagonSystem {
  private final OldVagonSystem oldVagon;

  public OldToNewAdapter(OldVagonSystem oldVagon) {
    this.oldVagon = oldVagon;
  }

  @Override
  public void matchSocket() {
    System.out.println("Using adapter to convert old socket to match the new one...");
    oldVagon.thinSocket();
  }
}

// Клас для ноутбука
class Laptop {
  public void charge(NewVagonSystem socket) {
    System.out.println("Laptop is charging...");
    socket.matchSocket();
  }
}

// Головний клас програми
public class Main {
  public static void main(String[] args) {
    Laptop laptop = new Laptop();

    // Сценарій 1: У новому вагоні
    System.out.println("Scenario 1: In a new vagon.");
    NewVagonSystem modernVagon = new ModernVagon();
    laptop.charge(modernVagon);

    // Сценарій 2: У старому вагоні
    System.out.println("\nScenario 2: In an old vagon.");
    OldVagonSystem oldVagon = new OldVagonSystem();
    NewVagonSystem adapter = new OldToNewAdapter(oldVagon);
    laptop.charge(adapter);
  }
}
