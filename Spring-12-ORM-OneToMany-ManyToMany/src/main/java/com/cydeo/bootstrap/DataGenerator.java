package com.cydeo.bootstrap;

import com.cydeo.enums.Status;
import com.cydeo.model.*;
import com.cydeo.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@AllArgsConstructor
public class DataGenerator implements CommandLineRunner {

   private final PaymentRepository paymentRepository;
   private final  MerchantRepository merchantRepository;
   private final CustomerRepository customerRepository;
   private final ItemRepository itemRepository;
   private final CartRepository cartRepository;

    @Override
    public void run(String... args) throws Exception {

        Payment payment1 = new Payment(LocalDate.of(2022,4,19),new BigDecimal("150000"), Status.SUCCESS);
        PaymentDetail paymentDetail1 = new PaymentDetail(new BigDecimal("140000"),new BigDecimal("10000"),LocalDate.of(2022,4,24));

        payment1.setPaymentDetail(paymentDetail1);

        Payment payment2 = new Payment(LocalDate.of(2022,4,25),new BigDecimal("100000"), Status.FAILURE);
        PaymentDetail paymentDetail2 = new PaymentDetail(new BigDecimal("90000"),new BigDecimal("5000"),LocalDate.of(2022,4,29));

        payment2.setPaymentDetail(paymentDetail2);

        Merchant merchant1 = new Merchant("AmazonSubMerchant","M123",new BigDecimal("0.25"),new BigDecimal("3.25"),5);
        Customer customer1 = new Customer("msmith","Mike","Smith","msmith@cydeo.com","VA");


        payment1.setMerchantId(merchant1); //One merchant can do multiple payments
        payment2.setMerchantId(merchant1);

        //we have to save merchant to db before creating payment with merchantid
        merchantRepository.save(merchant1);

        payment1.setCustomer(customer1);
        payment2.setCustomer(customer1);

        customerRepository.save(customer1);


        Item item1 = new Item("Milk","M01");
        Item item2 = new Item("Sugar","S01");
        Item item3 = new Item("Bread","B01");

        Cart cart1 = new Cart();
        Cart cart2 = new Cart();

        itemRepository.saveAll(Arrays.asList(item1,item2,item3));

        cart1.setItems(Arrays.asList(item1,item2,item3));
        cart2.setItems(Arrays.asList(item1,item2));

        cartRepository.saveAll(Arrays.asList(cart1,cart2));

        paymentRepository.save(payment1);
        paymentRepository.save(payment2);

    }


}
