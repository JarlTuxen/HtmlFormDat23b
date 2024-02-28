package dk.kea.htmlformdat23b.controller;

import dk.kea.htmlformdat23b.service.DayCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DayOfWeekController {

    private final DayCalculatorService dayCalculatorService;

    @Autowired
    public DayOfWeekController(DayCalculatorService dayCalculatorService) {
        this.dayCalculatorService = dayCalculatorService;
    }

    @RequestMapping("/isitdayoftheweek")
    public String index() {
        return "isitdayoftheweek";
    }

    @PostMapping("/isitdayoftheweek")
    public String isItDayOfTheWeek(@RequestParam("dayOfWeek") int dayOfWeek, RedirectAttributes redirectAttributes) {
        boolean isDayOfWeek = dayCalculatorService.isDayOfWeek(dayOfWeek);
        redirectAttributes.addAttribute("isDayOfWeek", isDayOfWeek);
        String sDayOfWeek = "";
        switch (dayOfWeek){
            case 1: sDayOfWeek = "Monday"; break;
            case 2: sDayOfWeek = "Tuesday"; break;
            case 3: sDayOfWeek = "Wednesday"; break;
            case 4: sDayOfWeek = "Thursday"; break;
            case 5: sDayOfWeek = "Friday"; break;
            case 6: sDayOfWeek = "Saturday"; break;
            case 7: sDayOfWeek = "Sunday"; break;
        }
        redirectAttributes.addAttribute("sDayOfWeek", sDayOfWeek);
        return "redirect:/dayresult";
    }

    @RequestMapping("/dayresult")
    public String result(@RequestParam("isDayOfWeek") boolean isDayOfWeek, @RequestParam("sDayOfWeek") String dayOfWeek, Model model) {
        model.addAttribute("isDayOfWeek", isDayOfWeek);
        model.addAttribute("dayOfWeek", dayOfWeek);
        return "dayresult";
    }
}
