package com.pv.reopsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pv.entity.Todo;


@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
