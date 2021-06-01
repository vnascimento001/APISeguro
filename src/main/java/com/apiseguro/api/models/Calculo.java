package com.apiseguro.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "calculo")
public class Calculo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @JsonProperty(value = "Id")
    private int id;

    @JsonIgnore
    @NotBlank(message = "Nome em branco")
    private String nome;

    @JsonIgnore
    @NotBlank(message = "CPF em branco")
    private String cpf;


    @JsonIgnore
    @Pattern(regexp = "[/^M$/|/^F$/]", message = "Digite somente M ou F!")
    private String sexo;


    @JsonIgnore
    @NotBlank(message = "Veículo em branco")
    private String veiculo;

    @JsonIgnore
    @NotNull(message = "Valor em branco")
    private int valor;

    @NotNull(message = "Parcelas em branco")
    @JsonProperty(value = "Quantidade parcelas")
    private int parcelas;


    @JsonIgnore
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate data;

    @Transient
    @JsonProperty(value = "Total")
    private double valortotal;
    @Transient
    @JsonProperty(value = "Valor parcela")
    private double valorparcela;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public double getValorparcela() {
        return valorparcela;
    }

    public void setValorparcela(double valorparcela) {
        this.valorparcela = valorparcela;
    }


}
