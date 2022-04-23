package canhnguyen.repository;

import canhnguyen.model.Book;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends PagingAndSortingRepository<Book, Long> {

}
