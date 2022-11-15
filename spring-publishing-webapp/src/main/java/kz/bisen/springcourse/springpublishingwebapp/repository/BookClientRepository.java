package kz.bisen.springcourse.springpublishingwebapp.repository;

import kz.bisen.springcourse.springpublishingwebapp.entity.BookClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookClientRepository extends JpaRepository<BookClient, Integer> {
}
