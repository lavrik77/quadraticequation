package ru.lavrinenko.quadraticequation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.lavrinenko.quadraticequation.mapper.modelDTO.ResultDTO;
import ru.lavrinenko.quadraticequation.service.ResultService;

@Controller
public class ResultController {

  @Autowired
  ResultService resultService;

  @GetMapping("/results")
  public String startPage(ResultDTO resultDTO, Model model) {
    model.addAttribute("results", resultService.getResults());
    return "results";
  }

  @PostMapping("/results")
  public String results(ResultDTO resultDTO, Model model) {
      model.addAttribute("results", resultService.getResults(resultDTO));
    return "results";
  }
}
