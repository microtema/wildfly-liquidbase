package de.seven.fate.liquidbase.batch;

import de.seven.fate.liquidbase.model.Article;
import de.seven.fate.liquidbase.model.Position;
import de.seven.fate.liquidbase.service.PositionService;

import javax.batch.api.chunk.AbstractItemWriter;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mario on 01.04.2016.
 */
@Named
public class PositionWriter extends AbstractItemWriter {

    @Inject
    private Logger logger;

    @Inject
    private PositionService service;

    @Override
    public void writeItems(List items) throws Exception {

        List<Position> positions = new ArrayList<>();

        Position position = new Position();
        position.setArticles((List<Article>) items);

        positions.add(position);

        service.savePosition(positions);
    }
}
