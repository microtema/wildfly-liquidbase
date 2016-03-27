package de.seven.fate.liquidbase.model.builder;

import de.seven.fate.liquidbase.model.Position;
import de.seven.fate.model.builder.AbstractModelBuilder;

import javax.inject.Inject;

/**
 * Created by Mario on 26.03.2016.
 */
public class PositionBuilder extends AbstractModelBuilder<Position> {

    private final ArticleBuilder articleBuilder;

    @Inject
    public PositionBuilder(ArticleBuilder articleBuilder) {
        this.articleBuilder = articleBuilder;
    }
}
