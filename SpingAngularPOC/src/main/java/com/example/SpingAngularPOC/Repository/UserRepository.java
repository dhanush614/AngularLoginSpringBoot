package com.example.SpingAngularPOC.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpingAngularPOC.Pojo.LoginDetails;

@Repository
public interface UserRepository extends CrudRepository<LoginDetails, String> {

}
