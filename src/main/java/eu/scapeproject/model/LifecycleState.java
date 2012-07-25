package eu.scapeproject.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement
public class LifecycleState {
    @XmlValue
    private final String details;
    @XmlAttribute(name="lifecyclestate")
    private final State state;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((details == null) ? 0 : details.hashCode());
        result = prime * result + ((state == null) ? 0 : state.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LifecycleState other = (LifecycleState) obj;
        if (details == null) {
            if (other.details != null)
                return false;
        } else if (!details.equals(other.details))
            return false;
        if (state != other.state)
            return false;
        return true;
    }

    public LifecycleState(String details, State state) {
        super();
        this.details = details;
        this.state = state;
    }
    
    private LifecycleState(){
        this.details=null;
        this.state=null;
    }

    public enum State {
        INGESTED, INGEST_FAILED, OTHER;
    }

    public State getState() {
        return state;
    }

    public String getDetails() {
        return details;
    }
    
}