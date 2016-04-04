package de.seven.fate.liquidbase.service;

import de.seven.fate.liquidbase.dao.ArticleDAO;
import de.seven.fate.liquidbase.model.Article;
import de.seven.fate.model.builder.AbstractModelBuilder;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mario on 01.04.2016.
 */
@Singleton
@Startup
public class ArticleService {

    @Inject
    private ArticleDAO dao;

    private ArticleBuilder builder = new ArticleBuilder();

    //@PostConstruct
    private void init() {

        while (dao.count() < 10) {

            System.out.println("count: " + dao.count());
            dao.save(builder.list(1000));
        }

        System.out.println("done...");
    }

    public List<Article> getArticles(int startPosition, int maxResult) {

        return dao.list(startPosition, maxResult);
    }

    public Long getArticleCount() {

        return dao.count();
    }

    class ArticleBuilder extends AbstractModelBuilder<Article> {
        @Override
        public Article min() {

            Article min = super.min();

            min.setId(null);

            return min;
        }
    }
}
