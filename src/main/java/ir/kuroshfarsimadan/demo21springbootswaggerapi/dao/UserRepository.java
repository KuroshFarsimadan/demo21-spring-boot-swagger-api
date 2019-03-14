package ir.kuroshfarsimadan.demo21springbootswaggerapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ir.kuroshfarsimadan.demo21springbootswaggerapi.bean.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}