package za.ac.cput.cuanlee.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CuanL on 23/08/2016.
 */
@RestController
public class HomeController {
    @RequestMapping("/hello")
    public String getValue(){
        return "Welcome To My PC STORE";
    }
}
