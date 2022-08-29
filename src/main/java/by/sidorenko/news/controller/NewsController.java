package by.sidorenko.news.controller;

import by.sidorenko.news.model.News;
import by.sidorenko.news.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {
    private NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/all_news")
    public String listNews(Model model) {
        model.addAttribute("all_news", newsService.getAllNews());
        return "news";
    }

    @GetMapping("/all_news/create")
    public String createNewsForm(Model model) {
        News news = new News();
        model.addAttribute("news", news);
        return "create_news";
    }

    @PostMapping("/all_news")
    public String saveNews(@ModelAttribute("news") News news) {
        newsService.saveNews(news);
        return "redirect:/all_news";
    }

    @GetMapping("/all_news/edit/{id}")
    public String editNewsForm(@PathVariable Long id,
                               Model model) {
        model.addAttribute("news", newsService.getNewsById(id));
        return "edit_news";
    }

    @PostMapping("/all_news/{id}")
    public String updateNews(@PathVariable Long id,
                             @ModelAttribute("news") News news,
                             Model model) {
        News existingNews = newsService.getNewsById(id);
        existingNews.setTitle(news.getTitle());
        existingNews.setBrief(news.getBrief());
        existingNews.setDate(news.getDate());
        existingNews.setContent(news.getContent());

        newsService.updateNews(existingNews);
        return "redirect:/all_news";
    }

    @GetMapping("/all_news/{id}")
    public String deleteNews(@PathVariable Long id) {
        newsService.deleteNewsById(id);
        return "redirect:/all_news";
    }
}
