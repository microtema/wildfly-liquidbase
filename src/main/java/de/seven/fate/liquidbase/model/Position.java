package de.seven.fate.liquidbase.model;

import de.seven.fate.liquidbase.dao.IdAble;
import de.seven.fate.liquidbase.model.Article;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Created by Mario on 26.03.2016.
 */
@Entity
public class Position implements IdAble<Long> {

    @Id
    private Long id;

    @OneToMany
    private List<Article> articles;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
