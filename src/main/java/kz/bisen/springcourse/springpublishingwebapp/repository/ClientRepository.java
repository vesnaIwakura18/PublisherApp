package kz.bisen.springcourse.springpublishingwebapp.repository;

import kz.bisen.springcourse.springpublishingwebapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
