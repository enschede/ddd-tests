package app;

import app.context.order.Order;
import app.domainevents.offer.Offer;
import app.infra.repository.OrderRepositoryImpl;
import com.google.gson.Gson;
import junit.framework.TestCase;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

/**
 * Created by marc on 03/08/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = App.class)
public class ControllerTest extends TestCase {

    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private Controller controller;
    @Autowired
    private OrderRepositoryImpl orderRepository;

    @Test
    public void shouldContainWebApplicationContext() {
        assertNotNull(wac);
    }

    @Test
    public void shouldCreateOrderFromOffer() {
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

        Order order = controller.createOrderFromOffer(offer);

        assertThat(order, notNullValue());
        assertThat(orderRepository.findAll().size(), equalTo(1));
    }

    @Test
    public void shouldCreateOrderFromOfferUsingMvc() throws Exception {
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

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        Gson gson = new Gson();
        String json = gson.toJson(offer);

        MvcResult mvcResult =
                mockMvc.perform(post("/createOrder").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();

        String result =
                mvcResult.getResponse().getContentAsString();
        
        assertThat(result, Matchers.containsString("\"name\":\"Enschede\""));
    }


}