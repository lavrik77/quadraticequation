package ru.lavrinenko.quadraticequation.service;

import org.junit.jupiter.api.Test;
import ru.lavrinenko.quadraticequation.mapper.modelDTO.ResultDTO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ResultServiceTest {

  public ResultDTO getResultDTO(double a, double b, double c) {
    ResultDTO resultDTO = new ResultDTO();
    resultDTO.setParamA(a);
    resultDTO.setParamB(b);
    resultDTO.setParamC(c);
    return resultDTO;
  }

  @Test
  void calc() {
    ResultService resultService = new ResultService();
    try {
      assertEquals("x1= 1.0, x2= -4.0", resultService.calc(getResultDTO(1, 3, -4)).getResult());
      assertEquals("x= 2.0", resultService.calc(getResultDTO(1, -4, 4)).getResult());
      assertEquals("Нет решений!", resultService.calc(getResultDTO(1, -5, 9)).getResult());
    } catch (Exception e) {
      e.printStackTrace();
    }
    Exception exception = assertThrows(Exception.class, () -> resultService.calc(getResultDTO(0,1,1)));
    assertEquals("Коэффициент а = 0. Решение уравнения невозможно!!!", exception.getMessage());

  }
}