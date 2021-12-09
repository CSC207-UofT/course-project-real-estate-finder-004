package externalinterfaces;

import entities.RealEstateAgent;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class HashMapAgentStorage implements Storage<Integer, RealEstateAgent>, Serializable {
    private static final long serialVersionUID = 7853553001351490713L;
    /**
     * Creates a new HashMap where the keys are unique integers and the values are agents.
     */
    private final HashMap<Integer, RealEstateAgent> agents = new HashMap<>();
    /**
     * Adds an agent to the agents HashMap.
     * @param agent  agent to be stored in agents
     */
    @Override
    public void add(RealEstateAgent agent) {
        agents.put(agent.getAgentId(), agent);
    }
    /**
     * Returns the agent associated with a given agentId.
     * @param agentId    an integer which is the key of an agent
     * @return  an agent stored in agents
     */
    @Override
    public RealEstateAgent get(Integer agentId) {
        return agents.get(agentId);
    }

    /**
     * @return  the keys in the agents HashMap
     */
    @Override
    public Set<Integer> keySet() {
        return agents.keySet();
    }

    /**
     * Removes an agentId and its associated agent from the agents HashMap.
     * @param agentId    an integer which is the key of an agent
     */
    @Override
    public void remove(Integer agentId) {
        agents.remove(agentId);
    }

    /**
     * @return a String representation of the properties HashMap.
     */
    @Override
    public String toString() {
        return "externalinterfaces.HashMapAgentStorage{" +
                "agents=" + agents.toString() +
                '}';
    }
    /**
     * @return  the agents HashMap
     */
    public HashMap<Integer, RealEstateAgent> getAgents() {
        return agents;
    }

    /**
     * @return  a new unique agentId
     */
    public Integer getNewId() {
        if (this.agents.isEmpty()) {
            return 1;
        }
        return Collections.max(this.agents.keySet()) + 1;
    }
}
