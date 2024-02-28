package dk.kea.htmlformdat23b.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayCalculator {

    //FridayCalculator branch
    public String erdetfredag(){
        LocalDate today = LocalDate.now();
        int q = today.getDayOfMonth(); //day of the month (1-31)
        int m = today.getMonthValue(); //the month (1-12)


        //month 1 and 2 count as month 13 and 14 the previous year
        int y = today.getYear(); //the year
        if (m<3){
            m+=12; //convert to month 13 or 14
            y--; //convert to previous year
        }

        int j = y / 100; //the century
        int k = y % 100; //the year of the century

        int h = (int) ((q + Math.floor(13 * (m+1)/5) + k + Math.floor(k/4) + Math.floor(j/4) - 2 * j) % 7);

        int d = ((h + 5) % 7) + 1; //day of the week

        //ternary operator: expression ? true value : false value
        //return d == 5 ? "Yes!":"No!";
        if (d==5){
            return "Yes!";
        }else{
            return "No!";
        }
    }

    public boolean isDayOfWeek(int x){
        LocalDate today = LocalDate.now();
        int q = today.getDayOfMonth(); //day of the month (1-31)
        int m = today.getMonthValue(); //the month (1-12)


        //month 1 and 2 count as month 13 and 14 the previous year
        int y = today.getYear(); //the year
        if (m<3){
            m+=12; //convert to month 13 or 14
            y--; //convert to previous year
        }

        int j = y / 100; //the century
        int k = y % 100; //the year of the century

        int h = (int) ((q + Math.floor(13 * (m+1)/5) + k + Math.floor(k/4) + Math.floor(j/4) - 2 * j) % 7);

        int d = ((h + 5) % 7) + 1; //day of the week

        //ternary operator: expression ? true value : false value
        //return d == 5 ? "Yes!":"No!";
        return d == x;
    }

}
