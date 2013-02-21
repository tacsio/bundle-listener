package parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;

import parser.contextmodel.Context;
import parser.contextmodel.ContextMapping;
import parser.contextmodel.ContextModel;

public class ContextModelParserSpec {
	
	private JAXBContext context;
	private Unmarshaller u;
	
	private ContextModel contextModel;
	
	public void setUp() throws JAXBException, FileNotFoundException {
		context = JAXBContext.newInstance(ContextModel.class);
		u = context.createUnmarshaller();
		this.contextModel = this.geContextModel();
	}
	
	private ContextModel geContextModel() throws FileNotFoundException, JAXBException {
		ContextModel contextmodel = (ContextModel) u.unmarshal(
				new FileInputStream("src/test/resources/context-model.xml"));
		return contextmodel;
	}
	
	@Test
	public void testConfigPath() {
		assertEquals(ContextModel.CONFIG, "DSOA-INF/context-model.xml");
	}
	
	@Test
	public void testContextList() {
		assertNotNull(contextModel.getContexts());
	}
	
	@Test
	public void testContextMapList() {
		assertNotNull(contextModel.getContextMappings());
	}
	
	@Test
	public void testContextCategory() {
		Context c = contextModel.getContexts().get(0);
		assertEquals("", "", c.getCategory());
	}
	
	@Test
	public void testContextMappingCategory() {
		ContextMapping cm = contextModel.getContextMappings().get(0);
		assertEquals("", "", cm.getCategory());
	}
	
	@Test
	public void testContextElements() {
		for (Context c : contextModel.getContexts()) {
			Map<String, String> elements = c.getElements();
			assertNotNull(elements);
		}
	}
	
	@Test
	public void testContextMappingElements() {
		for (ContextMapping ce : contextModel.getContextMappings()) {
			Map<String, String> contextElemts = ce.getContextElements();
			assertNotNull(contextElemts);
		}
	}
	
	@Test
	public void testContextElement() {
		
		Context c = contextModel.getContexts().get(0);
		assertEquals(3, c.getElements().size());
		
		Set<String> set = c.getElements().keySet();
		for(Object id : set) {
			assertNotNull(c.getElements().get(id));
		}
	}
	
	@Test
	public void testContextElementMapping() {
		
		ContextMapping cm = contextModel.getContextMappings().get(0);
		assertEquals(3, cm.getContextElements().size());
		
		Set<String> set = cm.getContextElements().keySet();
		for(Object id : set) {
			assertNotNull(cm.getContextElements().get(id));
		}
	}
	
}
