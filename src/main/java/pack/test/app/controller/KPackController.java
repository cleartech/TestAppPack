package pack.test.app.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pack.test.app.dao.KPackService;
import pack.test.app.model.KPack;

import java.sql.Date;
import java.util.List;

/**
 * Controller class for KPack entity
 */
@Controller
public class KPackController {

    @Autowired
    private KPackService kPackService;

    Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy").create();

    /**
     * Getting all K-Packs and view page
     *
     * @param model - holder for both Model and View in the web MVC framework
     * @return holder with required data
     */
    @RequestMapping(value = "/pack/all")
    public ModelAndView getAll(ModelAndView model) {

        List<KPack> kPacks = kPackService.getAll();

        model.addObject("gson", gson.toJson(kPacks));
        model.setViewName("packs");

        return model;
    }

    /**
     * Getting form for adding new entity
     *
     * @return jsp page view name
     */
    @RequestMapping(value = "/pack_add_form")
    public String getPackAddForm() {
        return "pack_add_form";
    }

    /**
     * Adding new K-Pack entity
     *
     * @param title       - title of entity
     * @param description - description for entity.
     *                    The value for the creationDate field is determined
     *                    by the system date at the time of creation
     * @return redirect to all K-Pack list view method
     */
    @RequestMapping(value = "/pack/add", method = RequestMethod.POST)
    public String addPack(@RequestParam String title, @RequestParam String description) {

        KPack kPack = new KPack();
        kPack.setTitle(title);
        kPack.setDescription(description);
        kPack.setCreationDate(new Date(System.currentTimeMillis()));

        kPackService.save(kPack);

        return "redirect:/pack/all";
    }

    /**
     * Deleting K-Pack entity with given id
     *
     * @param id - id of entity to delete
     * @return redirect to all K-Pack list view method
     */
    @RequestMapping(value = "/pack/delete/{id}")
    public String deletePack(@PathVariable(value = "id") int id) {
        kPackService.delete(id);

        return "redirect:/pack/all";
    }
}
