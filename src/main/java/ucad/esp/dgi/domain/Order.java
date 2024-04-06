package ucad.esp.dgi.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;



@Entity
@Table(name="Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double total;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="customer_id")
    private Customer customer;

    @OneToMany(cascade=CascadeType.PERSIST, mappedBy="order")
    private List<Item> items;

    

    public Order() {
    }

    public Order(double total, Customer customer) {
        super();
        this.total = total;
        this.customer = customer;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Item> getItem() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}