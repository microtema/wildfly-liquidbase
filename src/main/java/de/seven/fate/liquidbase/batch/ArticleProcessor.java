package de.seven.fate.liquidbase.batch;

import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.api.chunk.ItemProcessor;
import javax.batch.api.chunk.listener.AbstractItemProcessListener;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.logging.Logger;

/**
 * Created by Mario on 01.04.2016.
 */
@Named
public class ArticleProcessor implements ItemProcessor{

    @Inject
    private Logger logger;

    @Override
    public Object processItem(Object item) throws Exception {
        return item;
    }
}
