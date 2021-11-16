package ru.lavrinenko.quadraticequation.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lavrinenko.quadraticequation.dao.ResultsRepository;
import ru.lavrinenko.quadraticequation.mapper.ResultMapper;
import ru.lavrinenko.quadraticequation.mapper.modelDTO.ResultDTO;

import java.util.List;

@Service
public class ResultService {

  private final Logger log = LoggerFactory.getLogger(ResultService.class);

  private ResultsRepository resultsRepository;

  private ResultMapper resultMapper;

  public ResultService(){}

  @Autowired
  public ResultService(ResultsRepository resultsRepository, ResultMapper resultMapper) {
    this.resultsRepository = resultsRepository;
    this.resultMapper = resultMapper;
  }

  public List<ResultDTO> getResults() {
    return resultMapper.getResultListDTO(resultsRepository.findAll());
  }

  public List<ResultDTO> getResults(ResultDTO resultDTO) {;
    saveResult(resultDTO);
    return resultMapper.getResultListDTO(resultsRepository.findAll());
  }

  private void saveResult(ResultDTO resultDTO){
    try {
      resultsRepository.save(resultMapper.getResult(calc(resultDTO)));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public ResultDTO calc(ResultDTO resultDTO) throws Exception {
    double a = resultDTO.getParamA();
    if (a == 0) {
      log.error("Коэффициент а = 0. Решение уравнения невозможно!!!");
      throw new Exception("Коэффициент а = 0. Решение уравнения невозможно!!!");
    }
    double b = resultDTO.getParamB();
    double c = resultDTO.getParamC();

    double d = b * b - 4 * a * c;
    if (d < 0) {
      resultDTO.setResult("Нет решений!");
    } else if (d == 0) {
      resultDTO.setResult("x= " + ((-b) / (2 * a)));
    } else {
      resultDTO.setResult("x1= " + ((-b + Math.sqrt(d)) / (2 * a)) +
                          ", x2= " + ((-b - Math.sqrt(d)) / (2 * a)));
    }
    return resultDTO;
  }

}
