package ru.lavrinenko.quadraticequation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Result {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Double paramA;
  private Double paramB;
  private Double paramC;
  private String result;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getParamA() {
    return paramA;
  }

  public void setParamA(Double paramA) {
    this.paramA = paramA;
  }

  public Double getParamB() {
    return paramB;
  }

  public void setParamB(Double paramB) {
    this.paramB = paramB;
  }

  public Double getParamC() {
    return paramC;
  }

  public void setParamC(Double paramC) {
    this.paramC = paramC;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

}
