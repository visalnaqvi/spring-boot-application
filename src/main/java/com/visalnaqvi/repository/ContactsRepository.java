package com.visalnaqvi.repository;

import com.visalnaqvi.modals.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContactsRepository extends JpaRepository<Contacts, String> {

}
