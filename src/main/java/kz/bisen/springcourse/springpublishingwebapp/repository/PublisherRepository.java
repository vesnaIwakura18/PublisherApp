package kz.bisen.springcourse.springpublishingwebapp.repository;

import kz.bisen.springcourse.springpublishingwebapp.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
