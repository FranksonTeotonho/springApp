package com.frankson.app;

import com.frankson.app.model.*;
import com.frankson.app.model.enums.ClientType;
import com.frankson.app.model.enums.PaymentStatus;
import com.frankson.app.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Arrays;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private PaymentRepository paymentRepository;

    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category category1 = new Category(null, "Informática");
        Category category2 = new Category(null, "Escritório");

        Item item1 = new Item(null, "Computador", 2000.00);
        Item item2 = new Item(null, "Impressora", 800.00);
        Item item3 = new Item(null, "Mouse", 80.00);

        category1.getItems().addAll(Arrays.asList(item1, item2, item3));
        category2.getItems().add(item2);

        item1.getCategories().add(category1);
        item2.getCategories().addAll(Arrays.asList(category1, category2));
        item3.getCategories().add(category1);

        categoryRepository.saveAll(Arrays.asList(category1, category2));
        itemRepository.saveAll(Arrays.asList(item1, item2, item3));

        State state1 = new State(null, "Minas Gerais");
        State state2 = new State(null, "São Paulo");

        City city1 = new City(null, "Uberlandia", state1);
        City city2 = new City(null, "São Paulo", state2);
        City city3 = new City(null, "Campinas", state2);

        state1.getCities().add(city1);
        state2.getCities().addAll(Arrays.asList(city2, city3));

        stateRepository.saveAll(Arrays.asList(state1, state2));
        cityRepository.saveAll(Arrays.asList(city1, city2, city3));

        Client client1 = new Client(null, "Maria Silva", "maria@gmail.com", "60944720390", ClientType.INDIVIDUAL_ENTITY);
        client1.getPhoneNumbers().addAll(Arrays.asList("1234567","7654321"));

        Address address1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "65915782", client1, city1);
        Address address2 = new Address(null, "Avenida Matos", "105", "Sala 800", "Centro", "65915500", client1, city2);

        client1.getAddresses().addAll(Arrays.asList(address1, address2));

        clientRepository.save(client1);
        addressRepository.saveAll(Arrays.asList(address1, address2));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

        PurchaseOrder purchaseOrder1 = new PurchaseOrder(null, simpleDateFormat.parse("30/09/2017 10:32"), client1, address1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(null, simpleDateFormat.parse("10/10/2017 19:35"), client1, address2);

        Payment payment1 = new PaymentByCreditCard(null, PaymentStatus.CONCLUDED, purchaseOrder1, 6);
        purchaseOrder1.setPayment(payment1);

        Payment payment2 = new PaymentInCash(null, PaymentStatus.PENDENT, purchaseOrder2, simpleDateFormat.parse("20/10/2017 00:00"), null);
        purchaseOrder2.setPayment(payment2);

        client1.getPurchaseOrders().addAll(Arrays.asList(purchaseOrder1, purchaseOrder2));

        purchaseOrderRepository.saveAll(Arrays.asList(purchaseOrder1, purchaseOrder2));
        paymentRepository.saveAll(Arrays.asList(payment1, payment2));
    }
}
