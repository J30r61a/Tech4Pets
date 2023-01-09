package br.com.tech4me.tech4pets.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Pets")
public class Pet {
   @Id
   private String id;
   private String nome;
   private String raca;
   private int anoNascimento; 
   private boolean vacinado;
   private List<String> procedimentos;
   private double valor;

   public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getRaca() {
    return raca;
}
public void setRaca(String raca) {
    this.raca = raca;
}
public int getAnoNascimento() {
    return anoNascimento;
}
public void setAnoNascimento(int anoNascimento) {
    this.anoNascimento = anoNascimento;
}
public boolean isVacinado() {
    return vacinado;
}
public void setVacinado(boolean vacinado) {
    this.vacinado = vacinado;
}
public List<String> getProcedimentos() {
    return procedimentos;
}
public void setProcedimentos(List<String> procedimentos) {
    this.procedimentos = procedimentos;
}
public double getValor() {
    return valor;
}
public void setValor(double valor) {
    this.valor = valor;
}
   
}
