package dk.kea.htmlformdat23b.controller;

import dk.kea.htmlformdat23b.service.BMICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BMIController {

    private final BMICalculatorService bmiCalculatorService;

    @Autowired
    public BMIController (BMICalculatorService bmiCalculatorService){
        this.bmiCalculatorService = bmiCalculatorService;
    }

    @GetMapping("/bmicalculator")
    public String bmiCalculator(){
        return "bmicalculator";
    }

    @PostMapping("/bmicalculator")
    public String calculateBMI(@RequestParam("height") double height,
                               @RequestParam("weight") double weight,
                               RedirectAttributes redirectAttributes) {
        double bmi = bmiCalculatorService.calculateBMI(height, weight);
        redirectAttributes.addAttribute("bmi", bmi);
        return "redirect:/bmiresult";
    }

    @GetMapping("/bmiresult")
    public String showResult(@RequestParam("bmi") double bmi, Model model) {
        if (bmi == 0.0) {
            // Handle the case where there's no BMI value in the model
            // Redirect to the form page or show an error message
            return "redirect:/bmicalculator"; // Redirect back to the form page
        }
        
        model.addAttribute("bmi", bmi);
        return "bmiresult";
    }

}
