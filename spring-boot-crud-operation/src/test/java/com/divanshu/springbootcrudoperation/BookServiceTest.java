package com.divanshu.springbootcrudoperation;

import com.javatdivanshu.model.Books;
import com.javatdivanshu.repository.BooksRepository;
import com.javatdivanshu.service.BooksService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTest {
    @Test
    public void getAllBooksTest() {
        BooksRepository booksRepository = mock(BooksRepository.class);

        List<Books> mockBooks = new ArrayList<Books>();
        Books book1 = new Books();
        book1.setBookName("And then there were none");
        book1.setAuthor("Agatha Christie");
        book1.setBookId(1);

        Books book2 = new Books();
        book2.setBookName("Secrets to happy life");
        book2.setAuthor("Chris");
        book2.setBookId(2);

        mockBooks.add(book1);
        mockBooks.add(book2);

        when(booksRepository.findAll()).thenReturn(mockBooks);

        BooksService booksService = new BooksService();
        booksService.setBooksRepository(booksRepository);

        List<Books> result = booksService.getAllBooks();

        verify(booksRepository, times(1)).findAll();
        assertEquals(mockBooks, result);

    }


}
