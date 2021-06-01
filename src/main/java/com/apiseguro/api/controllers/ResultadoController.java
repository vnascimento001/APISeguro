package com.apiseguro.api.controllers;

import com.apiseguro.api.models.Calculo;
import com.apiseguro.api.repository.ResultadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ResultadoController {

    private ResultadoRepository repository;

    @Autowired
    ResultadoController(ResultadoRepository repository)
    {this.repository = repository;}

    @RequestMapping(value = "/calculos/{id}", method = RequestMethod.GET)
    public Calculo getCalculo(@PathVariable("id") Calculo id){
        repository.calc(id);
        return repository.findById(id.getId()).get();
    }

    @RequestMapping(value = "/reprocessar/{id}", method = RequestMethod.GET)
    public Calculo getCalculore(@PathVariable("id") Calculo id){
        repository.calc(id);
        return repository.findById(id.getId()).get();
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.GET)
    public ModelAndView cadastro(){
        ModelAndView cad = new ModelAndView("cadastro");
        cad.addObject("cadastro");
        return cad;
    }

    @RequestMapping(value = "/cadastro", method = RequestMethod.POST)
    public Calculo cadastro(@Valid Calculo calculo){
        repository.calc(calculo);
        repository.save(calculo);
        return repository.findById(calculo.getId()).get();
    }

    @RequestMapping(value = "/reprocessar", method = RequestMethod.GET)
    public ModelAndView reprocessar(){
        ModelAndView rep = new ModelAndView("reprocessar");
        rep.addObject("reprocessar");
        return rep;
    }

}
