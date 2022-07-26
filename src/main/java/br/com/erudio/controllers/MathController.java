package br.com.erudio.controllers;

import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.services.MathServices;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
    throws Exception {
        if (!MathServices.isNumericString(numberOne) || !MathServices.isNumericString(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double numberOneDouble = MathServices.convertToDouble(numberOne);
        Double numberOTwoDouble = MathServices.convertToDouble(numberTwo);

        return MathServices.sum(numberOneDouble, numberOTwoDouble);
    }

    @RequestMapping(value = "/substract/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double substract(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
    throws Exception {
        if (!MathServices.isNumericString(numberOne) || !MathServices.isNumericString(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double numberOneDouble = MathServices.convertToDouble(numberOne);
        Double numberOTwoDouble = MathServices.convertToDouble(numberTwo);

        return MathServices.substraction(numberOneDouble, numberOTwoDouble);
    }

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {
        if (!MathServices.isNumericString(numberOne) || !MathServices.isNumericString(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        Double secondNumber = MathServices.convertToDouble(numberTwo);
        if(secondNumber <= 0D){
            throw new UnsupportedMathOperationException("Not divisible to zero! Set the second value more than zero");
        }

        Double numberOneDouble = MathServices.convertToDouble(numberOne);
        Double numberOTwoDouble = MathServices.convertToDouble(numberTwo);


        return MathServices.division(numberOneDouble, numberOTwoDouble);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
            throws Exception {
        if (!MathServices.isNumericString(numberOne) || !MathServices.isNumericString(numberTwo)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double numberOneDouble = MathServices.convertToDouble(numberOne);
        Double numberOTwoDouble = MathServices.convertToDouble(numberTwo);

        return MathServices.multiplication(numberOneDouble, numberOTwoDouble);
    }

    @RequestMapping(value = "/squareroot/{numberOne}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable(value = "numberOne") String number)
            throws Exception {
        if (!MathServices.isNumericString(number)){
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double numberDouble = MathServices.convertToDouble(number);

        return MathServices.squareRoot(numberDouble);
    }
}
