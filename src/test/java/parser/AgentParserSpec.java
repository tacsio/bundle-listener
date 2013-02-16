package parser;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Before;
import org.junit.Test;

import parser.agent.Agent;
import parser.agent.AgentList;
import parser.agent.Transformer;

public class AgentParserSpec {

	private JAXBContext context;
	private Unmarshaller u;
	
	private AgentList list;
	
	@Before
	public void setUp() throws JAXBException, FileNotFoundException{
		context = JAXBContext.newInstance(AgentList.class);
		u = context.createUnmarshaller();
		this.list = this.getList();
	}
	
	private AgentList getList() throws FileNotFoundException, JAXBException {
		AgentList list = (AgentList) u.unmarshal(new FileInputStream(
				"src/test/resources/agents.xml"));
		return list;
	}
	
	@Test
	public void testConfigPath() {
		assertEquals(AgentList.CONFIG, "/DSOA-INF/agents.xml");
	}
	
	@Test
	public void testAgentList() throws FileNotFoundException, JAXBException {
		assertNotNull(list.getAgents());
	}
	
	@Test
	public void testAgentName() {
		String name = "ResponseTime";
		assertEquals("Xml has modified", name, list.getAgents().get(0).getName());
	}
	
	@Test
	public void testAgentDescription() {
		String desc = "Response time from invocation";
		assertEquals("Xml has modified", desc, list.getAgents().get(0).getDescription());
	}
	
	@Test
	public void testAgentTransformer(){
		for(Agent a : list.getAgents()){
			assertNotNull(a.getTransformer());
		}
	}
	
	@Test
	public void testTransformerType() {
		List<String> types = new ArrayList<String>(Arrays.asList(Transformer.TYPES)) ;
		for(Agent a : list.getAgents()){
			assertTrue(types.contains(a.getTransformer().getType()));
		}
	}
	
	@Test
	public void testTransormerInpuEvent() {
		String inputEvent = "InvocationEvent";
		String outputEvent = "ResponseTimeEvent";
		
		Transformer t = list.getAgents().get(0).getTransformer(); 
		
		String input = t.getInputEvent().getType();
		String output = t.getOutputEvent().getType();
		
		assertEquals("Xml has modified", inputEvent, input);
		assertEquals("Xml has modified", outputEvent, output);
	}
	
	@Test
	public void testTransformerMapping() {
		Transformer t = list.getAgents().get(0).getTransformer();
		assertNotNull(t.getMapping());
	}
	
	@Test
	public void testTransformerMappingProperties() {
		Transformer t = list.getAgents().get(0).getTransformer();
		Set<String> set = t.getMapping().keySet(); 
		
		for(Object id : set){
			assertNotNull(t.getMapping().get(id));
		}
	}

}
