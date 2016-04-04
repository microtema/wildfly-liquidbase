package de.seven.fate.liquidbase.batch;

import javax.batch.api.partition.PartitionPlan;
import java.util.Properties;

/**
 * Created by Mario on 02.04.2016.
 */
public class ArticlePartitionPlan implements PartitionPlan {

    private final Long articleCount;

    private final Properties[] props;

    public ArticlePartitionPlan(Long articleCount) {
        this.articleCount = articleCount;

        long partItems = this.articleCount / getPartitions();
        long remItems = this.articleCount % getPartitions();

        props = new Properties[getPartitions()];

        for (int i = 0; i < getPartitions(); i++) {
            props[i] = new Properties();
            props[i].setProperty("firstItem", String.valueOf(i * partItems));
            if (i == getPartitions() - 1) {
                props[i].setProperty("numItems", String.valueOf(partItems + remItems));
            } else {
                props[i].setProperty("numItems", String.valueOf(partItems));
            }
        }
    }

    @Override
    public void setPartitions(int count) {

    }

    @Override
    public void setPartitionsOverride(boolean override) {

    }

    @Override
    public boolean getPartitionsOverride() {
        return false;
    }

    @Override
    public void setThreads(int count) {

    }

    @Override
    public void setPartitionProperties(Properties[] props) {

    }

    @Override
    public int getPartitions() {
        return (int) (this.articleCount / 100);
    }

    @Override
    public int getThreads() {
        return 1;
    }

    @Override
    public Properties[] getPartitionProperties() {
        return props;
    }
}
