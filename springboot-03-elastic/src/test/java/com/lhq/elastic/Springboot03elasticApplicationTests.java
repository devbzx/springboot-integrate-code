package com.lhq.elastic;
import com.lhq.elastic.bean.Book;
import com.lhq.elastic.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class Springboot03elasticApplicationTests {
    @Autowired
    BookRepository bookRepository;
    @Test
    void contextLoads() {
        Book book = new Book();
        book.setBookName("西游记");
        book.setId(1);
        book.setAuthor("吴承恩");
        Book save = bookRepository.index(book);
        System.out.println(save);
    }
}
