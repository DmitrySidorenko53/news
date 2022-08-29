package by.sidorenko.news.dao;

import by.sidorenko.news.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsDAO extends JpaRepository<News, Long> {
}
