package com.indusnet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.indusnet.model.WhatsAppModel;

@Repository
public interface IWhatsAppRepository extends JpaRepository<WhatsAppModel, Integer> {
}
