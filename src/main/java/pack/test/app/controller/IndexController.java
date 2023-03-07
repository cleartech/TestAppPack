package pack.test.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller class for index page
 */
@Controller
public class IndexController {

    /**
     * Get index page
     *
     * @return jsp page view name
     */
    @RequestMapping(value = "/")
    public String getIndex() {

        return "index";
    }
}
