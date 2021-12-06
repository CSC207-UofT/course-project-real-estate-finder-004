package externalinterfaces;

import entities.RealEstateAgent;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;

public class HashMapAgentStorage implements Storage<Integer, RealEstateAgent>, Serializable {
    private static final long serialVersionUID = 7853553001351490713L;

    private final HashMap<Integer, RealEstateAgent> agents = new HashMap<>();

    @Override
    public void add(RealEstateAgent agent) {
        agents.put(agent.getAgentId(), agent);
    }

    @Override
    public RealEstateAgent get(Integer agentId) {
        return agents.get(agentId);
    }

    @Override
    public void remove(Integer agentId) {
        agents.remove(agentId);
    }

    @Override
    public String toString() {
        return "externalinterfaces.HashMapAgentStorage{" +
                "agents=" + agents.toString() +
                '}';
    }

    public HashMap<Integer, RealEstateAgent> getAgents() {
        return agents;
    }

    public Integer getNewId() {
        if (this.agents.isEmpty()) {
            return 1;
        }
        return Collections.max(this.agents.keySet()) + 1;
    }
}
