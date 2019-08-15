package org.launchcode.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
@RequestMapping("cheese") // this is the default request path: /cheese instead of just / or root
public class CheeseController {

     //static  ArrayList<String> cheeses = new ArrayList<>(); // allows the list to accessible from anywhere in the code.

    //add a hashmap to this code
    HashMap<String, String> cheeseDescription = new HashMap<>();

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("cheeseDescription", cheeseDescription);
        model.addAttribute("title", "My Cheeses"); // the title 'My Cheeses' goes into the ${title} in the html template(s)

        return "cheese/index"; // this is just the template name we made index.html with no extension
    }   // it must return the request path: /cheese/+' whatever'

    @RequestMapping(value = "add", method = RequestMethod.GET) // displays form
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese"); //"Add Cheese is the value in the 'add' template
        return "cheese/add"; //the template in templates.cheese > add.hmtl

    }

    @RequestMapping(value = "add", method = RequestMethod.POST) //submit form
    public String processAddCheeseForm(@RequestParam String aboutCheese, String cheeseName) {
        cheeseDescription.put(cheeseName, aboutCheese);
        return "redirect:"; //redirect to /cheese normally but since it is empty it redirects to index or value=""
    }
}

