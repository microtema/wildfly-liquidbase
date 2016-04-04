package de.seven.fate.liquidbase.batch;

import de.seven.fate.liquidbase.model.Article;
import de.seven.fate.liquidbase.service.ArticleService;
import de.seven.fate.liquidbase.service.PositionService;

import javax.batch.api.BatchProperty;
import javax.batch.api.chunk.AbstractItemReader;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.logging.Logger;

/**
 * Created by Mario on 01.04.2016.
 */
@Named
public class ArticleReader extends AbstractItemReader {

    @Inject
    private Logger logger;

    @Inject
    private ArticleService service;

    @Inject
    private JobContext jobContext;

    @Inject
    @BatchProperty
    private String firstItem;

    @Inject
    @BatchProperty
    private String numItems;

    private Iterator<Article> iterator;

    @Override
    public void open(Serializable checkpoint) throws Exception {
        super.open(checkpoint);

        iterator = service.getArticles(Integer.parseInt(firstItem), Integer.parseInt(numItems)).iterator();
    }

    @Override
    public Object readItem() throws Exception {

        if (iterator.hasNext()) {
            return iterator.next();
        }

        return null;
    }
}
