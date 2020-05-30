package com.example.SpingAngularPOC.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.SpingAngularPOC.Pojo.RequestDetails;

@Repository
public interface RequestRepository extends CrudRepository<RequestDetails, String> {

}
