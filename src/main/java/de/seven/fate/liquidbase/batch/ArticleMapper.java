package de.seven.fate.liquidbase.batch;

import de.seven.fate.liquidbase.service.ArticleService;

import javax.batch.api.partition.PartitionMapper;
import javax.batch.api.partition.PartitionPlan;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Mario on 02.04.2016.
 */
@Named
public class ArticleMapper implements PartitionMapper {

    private PartitionPlan partitionPlan;

    @Inject
    private ArticleService service;

    @Override
    public PartitionPlan mapPartitions() throws Exception {

        partitionPlan = new ArticlePartitionPlan(service.getArticleCount());

        return partitionPlan;
    }
}
