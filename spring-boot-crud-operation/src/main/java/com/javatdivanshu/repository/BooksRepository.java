package com.javatdivanshu.repository;
import org.springframework.data.repository.CrudRepository;

import com.javatdivanshu.model.Books;

public interface BooksRepository extends CrudRepository<Books, Integer>
{
}
