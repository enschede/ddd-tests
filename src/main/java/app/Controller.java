package app;

import app.context.order.Order;
import app.context.order.OrderService;
import app.domainevents.offer.Offer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OrderService orderService;
    
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    @ResponseBody
    public Order createOrderFromOffer(@RequestBody Offer offer) {

        Order order = orderService.createOrderFromOffer(offer);
        
        return order;
    }

}
