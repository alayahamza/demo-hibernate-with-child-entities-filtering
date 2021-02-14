package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParentRepository extends JpaRepository<Parent, Long> {

//    Returns all children of parents having under age children
    List<Parent> findByChildrenAgeLessThan(Integer age);

    //    Returns only under age children of parents having under age children
    @Query(value = "select p from parent p inner join fetch p.children c where c.age < :age")
    List<Parent> findOnlyChildrenAgeLessThan(@Param("age") Integer age);
}
