package app;

import app.context.order.Order;
import app.domainevents.offer.Offer;
import app.infra.repository.OrderRepositoryImpl;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by marc on 03/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = App.class)
public class ControllerTest extends TestCase {

    @Autowired
    private Controller controller;
    @Autowired
    private OrderRepositoryImpl orderRepository;
    
    @Test
    public void test01() {
        Offer offer = OfferBuilder.newInstance()
                .setMetLaadstation(true)
                .setType("STD+8")
                .setKleur("9001")
                .setInstalliewerk(true)
                .setNaam("Enschede")
                .setAdres("MdR")
                .setPostcode("1234AA")
                .setPlaats("Eanske")
                .build();
        
        Order order =  controller.createOrderFromOffer(offer);
        
        assertThat(order, notNullValue());
        assertThat(orderRepository.findAll().size(), equalTo(1));
    }
    
}