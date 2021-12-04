package controllers;

import entities.Property;
import entities.Seller;
import externalinterfaces.*;

public class AgentCreator extends Creator {

    public AgentCreator(HashMapUserStorage userStorage,
                        UserStorageReadWriter userStorageReadWriter,
                        HashMapPropertyStorage propertyStorage,
                        PropertyStorageReadWriter propertyStorageReadWriter,
                        HashMapAgentStorage agentStorage,
                        AgentStorageReadWriter agentStorageReadWriter) {
        super(userStorage, userStorageReadWriter, propertyStorage, propertyStorageReadWriter, agentStorage, agentStorageReadWriter);
    }



}
