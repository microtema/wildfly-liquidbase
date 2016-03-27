package de.seven.fate.liquidbase.model.builder;

import de.seven.fate.liquidbase.model.Order;
import de.seven.fate.model.builder.AbstractModelBuilder;

import javax.inject.Inject;

/**
 * Created by Mario on 26.03.2016.
 */
public class OrderBuilder extends AbstractModelBuilder<Order> {

    private final PositionBuilder positionBuilder;

    @Inject
    public OrderBuilder(PositionBuilder positionBuilder) {
        this.positionBuilder = positionBuilder;
    }
}
