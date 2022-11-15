package kz.bisen.springcourse.springpublishingwebapp.repository;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
