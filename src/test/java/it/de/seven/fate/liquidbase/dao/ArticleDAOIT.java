package it.de.seven.fate.liquidbase.dao;

import de.seven.fate.liquidbase.dao.ArticleDAO;
import de.seven.fate.liquidbase.dao.PositionDAO;
import de.seven.fate.liquidbase.model.Article;
import de.seven.fate.liquidbase.model.builder.ArticleBuilder;
import de.seven.fate.liquidbase.model.builder.annotations.Models;
import de.seven.fate.liquidbase.model.builder.enums.CollectionType;
import de.seven.fate.model.util.CollectionUtil;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Mario on 26.03.2016.
 */
@RunWith(Arquillian.class)
public class ArticleDAOIT {

    @Inject
    ArticleDAO sut;

    @Inject
    ArticleBuilder builder;

    @Inject
    @Models
    List<Article> models;

    @PersistenceContext
    EntityManager em;

    @Inject
    private UserTransaction transaction;

    @Deployment
    public static WebArchive createDeployment() {
        return DeploymentUtil.createDeployment();
    }

    @Before
    public void setUp() throws Exception {
        transactional(() -> sut.save(models));
    }

    @After
    public void tearDown() throws Exception {
        transactional(() -> sut.removeAll());
    }

    @Test
    public void save() throws Exception {
        transactional(() -> {
                    Article model = builder.random();
                    sut.save(model);
                    assertNotNull(model.getId());
                }
        );
    }

    @Test
    public void saveOrUpdate() throws Exception {
        transactional(() -> {
                    Article model = builder.random();
                    model.setId(CollectionUtil.random(models).getId());
                    sut.saveOrUpdate(model);
                    assertEquals(model, sut.get(model));
                }
        );
    }

    @Test
    public void get() throws Exception {
        transactional(() -> {
                    Article model = CollectionUtil.random(models);
                    assertEquals(model, sut.get(model));
                }
        );
    }

    @Test
    public void getById() throws Exception {

        transactional(() -> {
            Article model = CollectionUtil.random(models);
            assertEquals(model, sut.get(model.getId()));
        });
    }

    @Test
    public void remove() throws Exception {

        transactional(() -> {
            Article model = CollectionUtil.random(models);

            sut.remove(model);

            assertNull(sut.get(model.getId()));
        });
    }

    @Test
    public void count() throws Exception {

        transactional(() -> {
            assertEquals(models.size(), sut.count().intValue());
        });
    }

    @Test
    public void list() throws Exception {

        transactional(() -> {
            assertEquals(models, sut.list());
        });
    }

    private void transactional(Runnable runnable) throws Exception {
        transaction.begin();
        em.joinTransaction();

        runnable.run();

        transaction.commit();
    }
}
