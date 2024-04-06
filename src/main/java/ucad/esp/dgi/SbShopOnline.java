package ucad.esp.dgi;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ucad.esp.dgi.domain.*;

@SpringBootApplication
public class SbShopOnline implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(SbShopOnline.class);
	private final CustomerRepository repository;
	private final OrderRepository orepository;
	private final ProductRepository prepository;
	private final ItemRepository irepository;

	public SbShopOnline(CustomerRepository repository, OrderRepository orepository,
	ProductRepository prepository, ItemRepository irepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.prepository = prepository;
		this.irepository = irepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SbShopOnline.class, args);
		logger.info("Online Shop started at http://localhost:8081/");
	}

	@Override
	public void run(String... args) throws Exception {
		Customer c1 = new Customer("Bugs Bunny",59000, "New York");
		Customer c2 = new Customer("Daffy Duck",37000, "Los Angeles");
		Customer c3 = new Customer("Porky Pig",28000, "Miami");
		repository.saveAll(Arrays.asList(c1,c2, c3));
		
		Order o1 = new Order(1200, c1);
		Order o2 = new Order(300, c1);
		Order o3 = new Order(1200, c2);
		Order o4 = new Order(1500, c3);
		orepository.saveAll(Arrays.asList(o1, o2, o3, o4));


		Product p1 = new Product("Shirt", "Long Hands Shirt", "images/shirt.jpg", 300);
		Product p2 = new Product("Shoes", "Shoes Airmax", "images/shoes.jpg", 400);
		Product p3 = new Product("TV", "TV 55 inches", "images/tv.jpg", 800);
		Product p4 = new Product("Phone", "Iphone14", "images/ip14.jpg", 400);

		prepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		Item i1 = new Item(1, 200, o1, p1);
		Item i2 = new Item(2, 200, o2, p1);
		Item i3 = new Item(1, 300, o3, p2);
		Item i4 = new Item(1, 200, o2, p2);
		Item i5 = new Item(1, 100, o3, p4);
		Item i6 = new Item(1, 50, o4, p3);
		Item i7 = new Item(1, 400, o2, p2);
		Item i8 = new Item(1, 90, o4, p4);
		Item i9 = new Item(1, 300, o3, p2);
		irepository.saveAll(Arrays.asList(i1, i2, i3, i4, i5, i6, i7, i8, i9));

	}
}
