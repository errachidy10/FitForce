package org.example.sport.repositories;



import org.example.sport.entite.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact,Long>{
        }