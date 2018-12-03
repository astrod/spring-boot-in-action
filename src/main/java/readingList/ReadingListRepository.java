package readingList;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ReadingListRepository
 *
 * @author jongUn
 * @since 2018. 12. 03.
 */
public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}
