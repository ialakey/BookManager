package com.alakey.bookmanager.service;

import com.alakey.bookmanager.model.Book;
import com.alakey.bookmanager.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Page<Book> findBooks(String title, String brand, Integer year, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        if (year != null) {
            return repository.findByTitleContainingAndBrandContainingAndYear(title, brand, year, pageable);
        } else {
            return repository.findByTitleContainingIgnoreCaseAndBrandContainingIgnoreCase(title, brand, pageable);
        }
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book save(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

