package pack.test.app.controller;

import com.google.gson.Gson;
import pack.test.app.dao.KPackService;
import pack.test.app.dao.KPackSetService;
import pack.test.app.model.KPack;
import pack.test.app.model.KPackSet;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Controller class for KPackSet entity
 */
@Controller
public class KPackSetController {

    @Autowired
    private KPackSetService kPackSetService;

    @Autowired
    private KPackService kPackService;

    private final Gson gson = new Gson();

    private final Logger logger = Logger.getLogger(KPackSetController.class);

    /**
     * Getting all K-Pack Sets and view page
     *
     * @param model - holder for both Model and View in the web MVC framework
     * @return holder with required data
     */
    @RequestMapping(value = "/set/all")
    public ModelAndView getAll(ModelAndView model) {

        List<KPackSet> kPacksSets = kPackSetService.getAll();

        model.addObject("gson", gson.toJson(kPacksSets));
        model.setViewName("sets");

        return model;
    }

    /**
     * Getting form for adding new K-Pac Set entity
     *
     * @param model - holder for both Model and View in the web MVC framework
     * @return holder with required data
     */
    @RequestMapping(value = "/set_add_form")
    public ModelAndView getSetAddForm(ModelAndView model) {
        model.addObject("kpacks", kPackService.getAll());
        model.setViewName("set_add_form");

        return model;
    }

    /**
     * Adding new Set entity
     *
     * @param selectedKPacks - list of selected K-Pack entities for K-Pac Set
     * @param title          - title for K-Pac Set
     * @return redirect to all K-Pack Set list view method
     */
    @RequestMapping(value = "/set/add")
    public String addSet(@RequestParam(value = "selectedKPacks", required = false) int[] selectedKPacks,
                         @RequestParam(value = "title") String title) {

        KPackSet kPackSet = new KPackSet(title);

        if (selectedKPacks != null) {
            for (int kPack : selectedKPacks) {
                kPackSet.addKPack(kPackService.get(kPack));
            }
        }
        kPackSetService.save(kPackSet);

        return "redirect:/set/all";
    }

    /**
     * Deleting K-Pack Set entity with given id
     *
     * @param id - id of entity to delete
     * @return redirect to all K-Pack Set list view method
     */
    @RequestMapping(value = "/set/delete/{id}")
    public String deleteSet(@PathVariable(value = "id") int id) {

        kPackSetService.delete(id);

        return "redirect:/set/all";
    }

    /**
     * K-Pac Set view
     *
     * @param id    - id of entity to view
     * @param model - holder with required data
     * @return holder with data
     */
    @RequestMapping(value = "/set/{id}")
    public ModelAndView viewSet(@PathVariable(value = "id") int id,
                                ModelAndView model) {

        KPackSet set = kPackSetService.get(id);

        model.addObject("set", set);
        model.addObject("kpacks", gson.toJson(set.getkPacks()));
        model.setViewName("set");

        for (KPack pack : set.getkPacks()) {
            logger.debug("pack is: " + pack.getId() + " - " + pack.getTitle());
        }

        return model;
    }
}
