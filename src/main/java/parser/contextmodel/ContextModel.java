package parser.contextmodel;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "context-model")
@XmlType(name = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContextModel {
	
	public static final String CONFIG = "DSOA-INF/context-model.xml";
	
	@XmlElementWrapper(name = "contexts")
	@XmlElement(name = "context")
	private List<Context> contexts;
	
	@XmlElementWrapper(name = "context-mappings")
	@XmlElement(name = "context-mapping")
	private List<ContextMapping> contextMappings;

	public List<Context> getContexts() {
		return contexts;
	}

	public void setContexts(List<Context> contexts) {
		this.contexts = contexts;
	}

	public List<ContextMapping> getContextMappings() {
		return contextMappings;
	}

	public void setContextMappings(List<ContextMapping> contextMappings) {
		this.contextMappings = contextMappings;
	}	

}
