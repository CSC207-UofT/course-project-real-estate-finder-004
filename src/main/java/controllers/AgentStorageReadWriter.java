package controllers;

import entities.RealEstateAgent;
import externalinterfaces.Storage;

public class AgentStorageReadWriter extends StorageReadWriter<Integer, RealEstateAgent>{
    public AgentStorageReadWriter(Storage<Integer, RealEstateAgent> storage) {
        super("src/agents.ser", storage);
    }
}

