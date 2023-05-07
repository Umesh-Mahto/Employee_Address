package com.geekster.Employee.Address.service;

import com.geekster.Employee.Address.model.Address;
import com.geekster.Employee.Address.model.Employee;
import com.geekster.Employee.Address.repository.IAddressRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepository addressRepository;

    public List<Address> getAddress() {
        return addressRepository.getAddressNow();
    }

    public List<Address> getById(Long id) {
        return addressRepository.getByIdNow(id);
    }

    public String saveAddress(Address address) {
        addressRepository.save(address);
        return "Addded SuccessFully";
    }
    @Transactional
    public String updateById(Address address , Long id) {
        addressRepository.update(address.getStreet() , address.getCity() , address.getState() , address.getZipcode() , id);
        return "Updated Successfully!!";
    }
    @Transactional
    public String deleteById(Long id) {
        addressRepository.deleteAddressNow(id);
        return "Address deleted!!";
    }
}
