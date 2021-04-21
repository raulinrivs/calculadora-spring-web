package br.edu.usj.ad.pw.calculadora;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Calculadora {
    
    @PostMapping(value = "result")
    public ModelAndView calcular(@RequestParam String campo){
        double resultado = 0;
        if (campo.contains("+") == true){
            String[] valores = campo.split("\\+");
            resultado = Double.parseDouble(valores[0]) + Double.parseDouble(valores[1]);
        }else if  (campo.contains("-") == true){
            String valores[] = campo.split("-");
            resultado = Double.parseDouble(valores[0]) - Double.parseDouble(valores[1]);
        }else if  (campo.contains("*") == true){
            String valores[] = campo.split("\\*");
            resultado = Double.parseDouble(valores[0]) * Double.parseDouble(valores[1]);
        }else if  (campo.contains("/") == true){
            String valores[] = campo.split("/");
            resultado = Double.parseDouble(valores[0]) / Double.parseDouble(valores[1]);
        }     

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("resultado", resultado);

        return modelAndView;
    }
    
}
