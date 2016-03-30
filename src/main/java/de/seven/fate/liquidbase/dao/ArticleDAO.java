package de.seven.fate.liquidbase.dao;

import de.seven.fate.liquidbase.model.Article;
import org.apache.commons.lang3.Validate;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Mario on 26.03.2016.
 */
public class ArticleDAO extends AbstractEntityDAO<Article, Long> {

    @Override
    public void updateProperties(Article recent, Article entity) {
        notNull(recent);
        notNull(entity);

        recent.setName(entity.getName());
        recent.setUrn(entity.getUrn());
        recent.setSaison(entity.getSaison());
        recent.setSize(entity.getSize());
    }
}
