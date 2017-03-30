package fr.norsys.pronostic.dao;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Cette classe de test permet de tester si la base de données de test
 * fonctionne correctement
 *
 */

@ContextConfiguration(locations = { "classpath:/dao-test.xml",
		"classpath:/datasource-test.xml" ,})
public class ADaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Test
	public void test() {

	}
}
