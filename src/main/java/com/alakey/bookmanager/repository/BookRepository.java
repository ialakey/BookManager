package com.alakey.bookmanager.repository;

import com.alakey.bookmanager.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    Page<Book> findByTitleContainingAndBrandContainingAndYear(
            String title, String brand, int year, Pageable pageable
    );

    Page<Book> findByTitleContainingIgnoreCaseAndBrandContainingIgnoreCase(
            String title, String brand, Pageable pageable
    );
}