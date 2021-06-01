package com.apiseguro.api.repository;

import com.apiseguro.api.models.Calculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Repository
public interface ResultadoRepository extends JpaRepository<Calculo, Integer> {

    default void calc(Calculo calculo){

        double base = (calculo.getValor() * 0.03);

        double taxam = 0;
        if (Objects.equals(calculo.getSexo(), "M")){
            taxam =  base * 0.1;
        }

        LocalDate currentDate = LocalDate.now();
        LocalDate birthDate = calculo.getData();

        int ano;
        if ((birthDate != null)) {
            ano = Period.between(birthDate, currentDate).getYears();
        } else {
            ano = 0;
        }

        double taxaidade = 0;
        if (ano >= 18 && ano <= 25) {
            taxaidade = base * 0.1;
        }
        if (ano >= 26 && ano <= 30) {
            taxaidade = base * 0.05;
        }
        if (ano >= 31 && ano <= 35) {
            taxaidade = base * 0.02;
        }
        calculo.setValortotal(base + taxaidade + taxam);

        double taxaparcela= 0;

        if(calculo.getParcelas() >= 6 && calculo.getParcelas() <= 9 ){
            taxaparcela = calculo.getValortotal() * 0.03;
        }if(calculo.getParcelas() >= 10){
            taxaparcela = calculo.getValortotal() * 0.05;
        }

        calculo.setValortotal(calculo.getValortotal() + taxaparcela);

        calculo.setValorparcela(calculo.getValortotal() / calculo.getParcelas());
    }
}

