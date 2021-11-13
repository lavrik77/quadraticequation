package ru.lavrinenko.quadraticequation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lavrinenko.quadraticequation.dao.ResultsRepository;
import ru.lavrinenko.quadraticequation.model.Result;
import ru.lavrinenko.quadraticequation.modelDTO.ResultDTO;

import java.util.List;

@Service
public class ResultService {

  private final ResultsRepository resultsRepository;

  private final ResultMapper resultMapper;

  @Autowired
  public ResultService(ResultsRepository resultsRepository, ResultMapper resultMapper) {
    this.resultsRepository = resultsRepository;
    this.resultMapper = resultMapper;
  }

  public List<Result> getResults() {
    return resultsRepository.findAll();
  }

  public List<ResultDTO> getResults(ResultDTO resultDTO) {
    saveResult(resultDTO);
    return resultMapper.getResultListDTO(resultsRepository.findAll());
  }

  private void saveResult(ResultDTO resultDTO){
    resultDTO.setResult(Calc(resultDTO));
    resultsRepository.save(resultMapper.getResult(resultDTO));
  }

  private String Calc(ResultDTO resultDTO) {
    double a = resultDTO.getParamA();
    double b = resultDTO.getParamB();
    double c = resultDTO.getParamC();
    double d = b * b - 4 * a * c;
    if (d < 0) {
      return "Нет решений!";
    } else if (d == 0) {
      return "x= " + ((-b) / (2 * a));
    } else {
      return "x1= " + ((-b + Math.sqrt(d)) / (2 * a)) + ", x2= " + ((-b - Math.sqrt(d)) / (2 * a));
    }
  }

}
