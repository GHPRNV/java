import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CustomerApp {
    public static class Customer {
        private String firstName;
        private String lastName;
        private int id;
        private double balance;
        public Customer(String firstName, String lastName, int id, double balance) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.balance = balance;
        }
        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        @Override
        public String toString() {
            return "Customer [ID=" + id + ", Name=" + firstName + " " + lastName + ", Balance=" + balance + "]";
        }
    }
    public static class CustomerComparator implements Comparator<Customer> {
        @Override
        public int compare(Customer c1, Customer c2) {
            int firstNameCompare = c1.getFirstName().compareTo(c2.getFirstName());
            if (firstNameCompare != 0) return firstNameCompare;
            int lastNameCompare = c1.getLastName().compareTo(c2.getLastName());
            if (lastNameCompare != 0) return lastNameCompare;
            int idCompare = Integer.compare(c1.getId(), c2.getId());
            if (idCompare != 0) return idCompare;
            return Double.compare(c1.getBalance(), c2.getBalance());
        }
    }
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", 102, 500.50));
        customers.add(new Customer("Jane", "Smith", 101, 1500.75));
        customers.add(new Customer("John", "Doe", 100, 1000.00));
        customers.add(new Customer("Alice", "Johnson", 104, 300.00));
        customers.add(new Customer("Bob", "Smith", 103, 750.25));
        System.out.println("Customers before sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
        Collections.sort(customers, new CustomerComparator());
        System.out.println("\nCustomers after sorting:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}