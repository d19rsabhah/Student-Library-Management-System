package com.example.student_library_management_system.repository;

import com.example.student_library_management_system.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //writing the own customized methods for performing database queries using field / attributes of model class
    public Book findByTitle(String title);

    public Book findByTitleAndQuantity(String title, int quantity);

    //option "and" , "or"
    //writing the own customized methods for performing database queries using our own customized queries
    //SELECT COUNT(*) AS total_books FROM Book;
    @Query(nativeQuery = true,value = "SELECT * FROM Book WHERE BOOK_GENRE = :inputGenre")
    public List<Book> findBooksByGenre(String inputGenre);

//    @Query(value = "SELECT * FROM book " +
//            "WHERE (genre = :genre AND pages > :minPages) " +
//            "OR quantity = :quantity",
//            nativeQuery = true)
//    List<Book> findBooksByGenreAndPagesOrQuantity(
//            @Param("genre") String genre,
//            @Param("minPages") int minPages,
//            @Param("quantity") int quantity
//    );

}
