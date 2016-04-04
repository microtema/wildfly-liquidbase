package de.seven.fate.liquidbase.batch;

import de.seven.fate.liquidbase.service.PositionService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * Created by Mario on 01.04.2016.
 */
@Singleton
@Startup
public class ArticleBatchOperator {

    private static final String JOB_NAME = "article-batch-job";

    @Inject
    private Logger logger;

    private long pid;

    private JobOperator jobOperator;

    @PostConstruct
    private void start() {

        logger.info("start job: " + JOB_NAME);

        jobOperator = BatchRuntime.getJobOperator();

        pid = jobOperator.start(JOB_NAME, null);
    }

    @PreDestroy
    private void stop() {

        logger.info("stop job: " + JOB_NAME);

        jobOperator.stop(pid);
    }
}
