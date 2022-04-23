package canhnguyen.service;

import canhnguyen.model.Book;

import canhnguyen.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;



    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }
}
