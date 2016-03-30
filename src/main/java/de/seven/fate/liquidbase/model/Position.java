package de.seven.fate.liquidbase.model;

import de.seven.fate.liquidbase.dao.IdAble;
import de.seven.fate.liquidbase.model.Article;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;

        if (CollectionUtils.isEmpty(articles)) {
            return CollectionUtils.isEmpty(position.articles);
        }

        if (CollectionUtils.isEmpty(position.articles)) {
            return CollectionUtils.isEmpty(articles);
        }

        if (articles.size() != position.articles.size()) {
            return false;
        }

        for (int index = 0; index < articles.size(); index++) {
            if (!Objects.equals(articles.get(index), position.articles.get(index))) {
                return false;
            }
        }

        return true;
        // return Objects.equals(articles, position.articles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articles);
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", articles=" + articles +
                '}';
    }
}
