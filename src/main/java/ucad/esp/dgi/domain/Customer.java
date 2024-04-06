package ucad.esp.dgi.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;



@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String fullname, city;
    private double balance;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="customer")
    private List<Order> orders;

    public Customer() {}
    public Customer(String fullname, double balance, String city) {
        super();
        this.fullname = fullname;
        this.balance = balance;
        this.city = city;
    }
    public Long getId() {
        return id;
    }
    public String getFullname() {
        return fullname;
    }
    public double getBalance() {
        return balance;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public List<Order> getOrders() {
        return orders;
    }
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}