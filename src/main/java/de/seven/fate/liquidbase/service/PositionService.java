package de.seven.fate.liquidbase.service;

import de.seven.fate.liquidbase.dao.PositionDAO;
import de.seven.fate.liquidbase.model.Position;

import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mario on 01.04.2016.
 */
public class PositionService {

    private final static Logger LOGGER = Logger.getLogger(PositionService.class.getName());

    @Inject
    private PositionDAO dao;

    public void savePosition(List<Position> items) {
        LOGGER.info(String.format("save <%s> positions", items.size()));

        dao.saveOrUpdate(items);
    }
}
