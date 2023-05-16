package sg.edu.nus.iss.ssf_day12_workshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import sg.edu.nus.iss.ssf_day12_workshop.model.Image;
import sg.edu.nus.iss.ssf_day12_workshop.service.RandomNumberService;

// use controller because we want to return html
// controller is optional in this case as we only have one controller 
@Controller
@RequestMapping(path = "/api")
public class RandomNumberGenController {

    // injecting service method
    // many ways to inject but this is generally used for small apps
    @Autowired
    RandomNumberService service;
    
    @GetMapping ("/home")
    public String landingPage(){
        return "home";
    }

    // for get in home.html
    @GetMapping ("/get")
    public String generateRandomNumbers(Model model, HttpServletRequest request){
        
        // fetch input parameter
        int number = Integer.parseInt(request.getParameter("number"));
        System.out.println("input number is: " + number);

        // check condition if no is between 1 - 30
        if(number < 1 || number > 30){
            String errorMessage = "Invalid Number " + number;
            model.addAttribute("errorMessage", errorMessage);
            return "home";
        }
        // calling service method
        List<Integer> randomNumbers = service.generateRandomNumbers(number);

        // populate image objects and create list of image objects
        List<Image> imageList = new ArrayList<Image>();
        for (int randomNumber : randomNumbers){
            imageList.add(new Image(Integer.toString(randomNumber),"/images/"+ Integer.toString(randomNumber) + ".png"));
        }
        System.out.println("image list:" + imageList);

        model.addAttribute(imageList);

        return "display";
    }
}
