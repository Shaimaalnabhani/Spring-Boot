package com.codeline.Springboot.Services;

import com.codeline.Springboot.Entities.Address;
import com.codeline.Springboot.Entities.Student;
import com.codeline.Springboot.repositories.AddressRepository;
import com.codeline.Springboot.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AddressService {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    StudentRepository studentRepository;

//    public Address updateAddress(Address address) throws Exception {
//        Address existingAddress = addressRepository.findById(address.getId()).get();
//        if (existingAddress != null && existingAddress.getIsActive()) {
//            address.setUpdatedDate(new Date());
//            return addressRepository.save(address);
//        } else {
//            throw new Exception("BAD REQUEST");
//        }
//    }

    public Address updateAddress(Integer studentId, Address input) throws Exception {
        Student student = studentRepository.getStudentById(studentId);
        if (student == null) {
            throw new Exception("Student not found with ID = " + studentId);
        }
        Address existingAddress = student.getAddress();
        if (existingAddress == null) {
            throw new Exception("Address not found for this student");
        }

        existingAddress.setCity(input.getCity());
        existingAddress.setStreet(input.getStreet());
        existingAddress.setCountry(input.getCountry());
        existingAddress.setUpdatedDate(new Date());

        return addressRepository.save(existingAddress);
    }
}
