package kz.bisen.springcourse.springpublishingwebapp.repository;

import kz.bisen.springcourse.springpublishingwebapp.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    Optional<Book> findByIsbn(String isbn);

    @Query(value = "SELECT b.scanned_date_time from book_scan b ORDER BY b.scanned_date_time desc",
            nativeQuery = true)
    Optional<LocalDateTime> findLastScanDateTime();

    List<Book> findByScannedDateTimeLessThan(LocalDateTime localDateTime);
}
