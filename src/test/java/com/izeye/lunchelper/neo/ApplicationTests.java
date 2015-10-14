package com.izeye.lunchelper.neo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewInterceptor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

/**
 * Created by izeye on 15. 10. 3..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebAppConfiguration
public class ApplicationTests {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PersistenceExceptionTranslationPostProcessor persistenceExceptionTranslationPostProcessor;
	
	@Autowired
	PlatformTransactionManager transactionManager;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	OpenEntityManagerInViewInterceptor openEntityManagerInViewInterceptor;
	
	@Test
	public void testDataSource() {
		assertThat(this.dataSource, is(not(nullValue())));
	}

	@Test
	public void testPersistenceExceptionTranslationPostProcessor() {
		assertThat(this.persistenceExceptionTranslationPostProcessor, is(not(nullValue())));
	}

	@Test
	public void testTransactionManager() {
		assertThat(this.transactionManager, is(not(nullValue())));
		assertThat(this.transactionManager, is(instanceOf(JpaTransactionManager.class)));
	}
	
	@Test
	public void testEntityManager() {
		assertThat(this.entityManager, is(not(nullValue())));
	}
	
	@Test
	public void testOpenEntityManagerInViewInterceptor() {
		assertThat(this.openEntityManagerInViewInterceptor, is(not(nullValue())));
	}
	
}
