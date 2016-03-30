package de.seven.fate.liquidbase.dao;

import de.seven.fate.liquidbase.model.Position;
import org.apache.commons.lang3.Validate;

import javax.inject.Inject;

import static org.apache.commons.lang3.Validate.notNull;

/**
 * Created by Mario on 26.03.2016.
 */
public class PositionDAO extends AbstractEntityDAO<Position, Long> {

    @Inject
    private ArticleDAO articleDAO;

    @Override
    public void save(Position entity) {
        notNull(entity);

        articleDAO.saveOrUpdate(entity.getArticles());

        saveImpl(entity);
    }

    @Override
    public Position saveOrUpdate(Position entity) {
        notNull(entity);

        articleDAO.saveOrUpdate(entity.getArticles());

        return saveOrUpdateImpl(entity);
    }

    @Override
    public void updateProperties(Position recent, Position entity) {
        notNull(recent);
        notNull(entity);

        recent.setArticles(entity.getArticles());
    }

    @Override
    public void remove(Position entity) {
        notNull(entity);

        articleDAO.saveOrUpdate(entity.getArticles());

        removeImpl(entity);
    }
}
