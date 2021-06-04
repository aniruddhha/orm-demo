package com.ani.orm.query;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void methods() {
//            Book book = bookRepository.findByIsbn("733155263-5");
//        printBook(book);

//        List<Book> books = bookRepository.findByNameContaining("ab").orElseThrow(RuntimeException::new);
//        List<Book> books = bookRepository.findByNameLike("%ab%").orElseThrow(RuntimeException::new);
//        List<Book> books = bookRepository.findByNameStartingWith("a").orElseThrow(RuntimeException::new);
//        List<Book> books = bookRepository.findByNameIgnoreCaseStartingWith("A").orElseThrow(RuntimeException::new);
//        List<Book> books = bookRepository.findByPbDtBetween(
//                LocalDate.of(2020, 8,15),
//                LocalDate.of(2021, 8,15)
//        ).orElseThrow(RuntimeException::new);
//        List<Book> books = bookRepository.findByPageCountGreaterThan(60).orElseThrow(RuntimeException::new);
//        List<Book> books = bookRepository.findTop10ByPageCountLessThanOrderByPageCountDesc(50).orElseThrow(RuntimeException::new);

        List<Book> books = bookRepository.findAll(
                Sort.by(Sort.Direction.DESC, "name" )
        );

        printBooks(books);
    }

    public void query() {
//        List<Book> books = bookRepository.selectIsbn().orElseThrow(RuntimeException::new);

//        List<Book> books = bookRepository.sortJpql(
//                Sort.by(Sort.Direction.DESC, "name" )
//        ).orElseThrow(RuntimeException::new);
//        printBooks(books);

//        System.out.println("Average Page Count --> "+bookRepository.avgPageCount());;

        List<Book> books = bookRepository.selectIsbnNative().orElseThrow(RuntimeException::new);
        printBooks(books);
    }

    private void printBook(Book book) {
        System.out.println(book.toString());
    }

    private void printBooks(List<Book> books) {
        books.forEach(System.out::println);
    }
}
