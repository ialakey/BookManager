package com.alakey.bookmanager.controller;

import com.alakey.bookmanager.model.Book;
import com.alakey.bookmanager.repository.BookRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookRestController {

    private final BookRepository bookRepository;

    @GetMapping
    public Page<Book> getBooks(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "") String brand,
            @RequestParam(required = false) Integer year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("title").ascending());

        Specification<Book> spec = (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!title.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("title")), "%" + title.toLowerCase() + "%"));
            }
            if (!brand.isEmpty()) {
                predicates.add(cb.like(cb.lower(root.get("brand")), "%" + brand.toLowerCase() + "%"));
            }
            if (year != null) {
                predicates.add(cb.equal(root.get("year"), year));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };

        return bookRepository.findAll(spec, pageable);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        return bookRepository.findById(id).map(book -> {
            book.setVendorCode(updatedBook.getVendorCode());
            book.setTitle(updatedBook.getTitle());
            book.setYear(updatedBook.getYear());
            book.setBrand(updatedBook.getBrand());
            book.setStock(updatedBook.getStock());
            book.setPrice(updatedBook.getPrice());
            return bookRepository.save(book);
        }).orElseThrow(() -> new RuntimeException("Книга не найдена"));
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
