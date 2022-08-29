package by.sidorenko.news.service;

import by.sidorenko.news.model.News;

import java.util.List;

public interface NewsService {
    List<News> getAllNews();

    News saveNews(News news);

    News getNewsById(Long id);

    News updateNews(News news);

    void deleteNewsById(Long id);
}
