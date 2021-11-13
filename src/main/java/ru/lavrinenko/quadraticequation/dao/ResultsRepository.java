package ru.lavrinenko.quadraticequation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lavrinenko.quadraticequation.model.Result;

@Repository
public interface ResultsRepository extends JpaRepository<Result, Long> {
}
