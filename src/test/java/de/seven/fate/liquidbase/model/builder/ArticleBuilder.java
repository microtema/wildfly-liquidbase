package de.seven.fate.liquidbase.model.builder;

import de.seven.fate.liquidbase.model.Article;
import de.seven.fate.liquidbase.model.builder.annotations.Model;
import de.seven.fate.liquidbase.model.builder.annotations.Models;
import de.seven.fate.liquidbase.model.builder.enums.CollectionType;
import de.seven.fate.liquidbase.model.builder.enums.ModelType;
import de.seven.fate.model.builder.AbstractModelBuilder;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.List;
import java.util.Set;

/**
 * Created by Mario on 26.03.2016.
 */
public class ArticleBuilder extends AbstractModelBuilder<Article> {

    @Produces
    @Override
    @Model(value = ModelType.MIN)
    public Article min() {
        return super.min();
    }

    @Produces
    @Override
    @Model(value = ModelType.MAX)
    public Article max() {
        return super.max();
    }

    @Override
    @Produces
    @Model(value = ModelType.RANDOM)
    public Article random() {
        return super.random();
    }

    @Produces
    @Models(value = CollectionType.LIST)
    public List<Article> list(InjectionPoint injectionPoint) {
        return super.list(BuilderUtil.getCollectionSize(injectionPoint));
    }

    @Produces
    @Models(value = CollectionType.SET)
    public Set<Article> set(InjectionPoint injectionPoint) {
        return super.set(BuilderUtil.getCollectionSize(injectionPoint));
    }
}
