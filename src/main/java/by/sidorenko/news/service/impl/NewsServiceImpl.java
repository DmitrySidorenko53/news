package by.sidorenko.news.service.impl;

import by.sidorenko.news.dao.NewsDAO;
import by.sidorenko.news.model.News;
import by.sidorenko.news.service.NewsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    private NewsDAO newsDAO;

    public NewsServiceImpl(NewsDAO newsDAO) {
        this.newsDAO = newsDAO;
    }

    @Override
    public List<News> getAllNews() {
        return newsDAO.findAll();
    }

    @Override
    public News saveNews(News news) {
        return newsDAO.save(news);
    }

    @Override
    public News getNewsById(Long id) {
        return newsDAO.findById(id).get();
    }

    @Override
    public News updateNews(News news) {
        return newsDAO.save(news);
    }

    @Override
    public void deleteNewsById(Long id) {
        newsDAO.deleteById(id);
    }
}
