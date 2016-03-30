package de.seven.fate.liquidbase.model.builder;

import de.seven.fate.liquidbase.model.Article;
import de.seven.fate.liquidbase.model.Position;
import de.seven.fate.liquidbase.model.builder.annotations.Model;
import de.seven.fate.liquidbase.model.builder.annotations.Models;
import de.seven.fate.liquidbase.model.builder.enums.CollectionType;
import de.seven.fate.liquidbase.model.builder.enums.ModelType;
import de.seven.fate.model.builder.AbstractModelBuilder;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;

/**
 * Created by Mario on 26.03.2016.
 */
public class PositionBuilder extends AbstractModelBuilder<Position> {

    private final ArticleBuilder articleBuilder;

    @Inject
    public PositionBuilder(ArticleBuilder articleBuilder) {
        this.articleBuilder = articleBuilder;
    }

    @Produces
    @Override
    @Model(value = ModelType.MIN)
    public Position min() {

        Position min = super.min();

        min.setArticles(articleBuilder.list());

        return min;
    }

    @Produces
    @Override
    @Model(value = ModelType.MAX)
    public Position max() {
        return super.max();
    }

    @Override
    @Produces
    @Model(value = ModelType.RANDOM)
    public Position random() {
        return super.random();
    }

    @Produces
    @Models(value = CollectionType.LIST)
    public List<Position> list(InjectionPoint injectionPoint) {
        return super.list(BuilderUtil.getCollectionSize(injectionPoint));
    }

    @Produces
    @Models(value = CollectionType.SET)
    public Set<Position> set(InjectionPoint injectionPoint) {
        return super.set(BuilderUtil.getCollectionSize(injectionPoint));
    }
}
