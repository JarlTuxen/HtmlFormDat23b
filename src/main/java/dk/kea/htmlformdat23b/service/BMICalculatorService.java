package dk.kea.htmlformdat23b.service;

import org.springframework.stereotype.Service;

@Service
public class BMICalculatorService {

    public double calculateBMI(double height, double weight) {
        // Perform the BMI calculation
        return weight / ((height / 100) * (height / 100));
    }
}
