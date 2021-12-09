package controllers;

import entities.RealEstateAgent;
import externalinterfaces.Storage;

/**
 * A map of agentId —> RealEstateAgent object.
 */

public class AgentStorageReadWriter extends StorageReadWriter<Integer, RealEstateAgent>{
    public AgentStorageReadWriter(Storage<Integer, RealEstateAgent> storage) {
        super("src/agents.ser", storage);
    }
}

