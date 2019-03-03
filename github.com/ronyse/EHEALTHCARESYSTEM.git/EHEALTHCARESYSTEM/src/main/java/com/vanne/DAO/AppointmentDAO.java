package com.vanne.DAO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanne.model.Appointment;

@Repository
public interface AppointmentDAO extends CrudRepository<Appointment, Long> {

}
