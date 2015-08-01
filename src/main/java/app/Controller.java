package app;

import app.domain.order.Klant;
import app.domain.order.Order;
import app.domain.order.OrderService;
import app.domain.order.Telefoonnummer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private OrderService orderService;
    
    @RequestMapping("/json")
    @ResponseBody
    public Greeting greeting() {
        return new Greeting(10L, "Hallo!");
    }

    @RequestMapping("/test")
    @ResponseBody
    public String test() {

        Order order = orderService.maakOrder(new Klant("Marc", "MdR", "1234AA", "Enschede", new Telefoonnummer("06")));
        
        Order order2 = orderService.toonOrder(order.getUuid());

        return order2.toString();
    }

    class Greeting {

        private final long id;
        private final String content;

        public Greeting(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }

}
