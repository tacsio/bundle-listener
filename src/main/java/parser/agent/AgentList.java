package parser.agent;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "agents")
@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgentList {

	public static final String CONFIG = "DSOA-INF/agent.xml";
	
	@XmlElement(name = "agent")
	private List<Agent> agents;

	public List<Agent> getAgents() {
		return agents;
	}

	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
}
