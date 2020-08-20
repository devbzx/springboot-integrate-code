package com.lhq.elastic.repository;
import com.lhq.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
    public List<Book> findBookByBookNameLike(String name);
}
