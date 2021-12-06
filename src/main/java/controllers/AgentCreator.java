package controllers;

import entities.Property;
import entities.RealEstateAgent;
import entities.Seller;
import externalinterfaces.*;

import java.io.IOException;

public class AgentCreator extends Creator {

    public AgentCreator(HashMapUserStorage userStorage,
                        UserStorageReadWriter userStorageReadWriter,
                        HashMapPropertyStorage propertyStorage,
                        PropertyStorageReadWriter propertyStorageReadWriter,
                        HashMapAgentStorage agentStorage,
                        AgentStorageReadWriter agentStorageReadWriter) {
        super(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
    }

    public void create(Seller client) {
        int agentId = agentStorage.getNewId();
        RealEstateAgent agent = new RealEstateAgent(client, agentId);

        this.agentStorage.add(agent);
        if(Creator.writeToFile) {
            try {
                propertyStorageReadWriter.saveToFile();
                agentStorageReadWriter.saveToFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
