package com.geekster.Employee.Address.repository;

import com.geekster.Employee.Address.model.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAddressRepository extends CrudRepository<Address , Long> {
    @Query(value = "select * from address_table" , nativeQuery = true)
   public List<Address> getAddressNow();

    @Query(value = "select * from address_table where id = :id" , nativeQuery = true)
   public List<Address> getByIdNow(Long id);
    @Modifying
    @Query(value = "update address_table set street = :street , city = :city , state = :state , zipcode = :zipcode where id = :id" , nativeQuery = true)
    public void update(String street, String city, String state, String zipcode, Long id);
    @Modifying
    @Query(value = "delete from address_table where id = :id" , nativeQuery = true)
    public void deleteAddressNow(Long id);
}