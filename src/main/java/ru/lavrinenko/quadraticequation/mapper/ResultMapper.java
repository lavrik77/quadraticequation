package ru.lavrinenko.quadraticequation.mapper;

import org.mapstruct.Mapper;
import ru.lavrinenko.quadraticequation.model.Result;
import ru.lavrinenko.quadraticequation.mapper.modelDTO.ResultDTO;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface ResultMapper {

  ResultDTO getResultDTO(Result result);

  List<ResultDTO> getResultListDTO(List<Result> results);

  Result getResult(ResultDTO resultDTO);

  List<Result> getResultList(List<ResultDTO> resultsDTO);
}
