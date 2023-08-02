package com.exampleone.manytomanystronguser.repositories;

import org.springframework.data.repository.CrudRepository;

import com.exampleone.manytomanystronguser.entities.JoinTable;
import com.exampleone.manytomanystronguser.entities.JoinTable.JoinTableId;

public interface JoinTableRepository extends CrudRepository<JoinTable, JoinTableId>{

}
