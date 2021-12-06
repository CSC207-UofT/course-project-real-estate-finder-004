package controllers;

import externalinterfaces.HashMapPropertyStorage;
import externalinterfaces.HashMapUserStorage;
import externalinterfaces.HashMapAgentStorage;

public class Creator {
    HashMapUserStorage userStorage;
    UserStorageReadWriter userStorageReadWriter;
    HashMapPropertyStorage propertyStorage;
    PropertyStorageReadWriter propertyStorageReadWriter;
    HashMapAgentStorage agentStorage;
    AgentStorageReadWriter agentStorageReadWriter;
    final static boolean writeToFile = true;

    public Creator(HashMapUserStorage userStorage,
                   UserStorageReadWriter userStorageReadWriter,
                   HashMapPropertyStorage propertyStorage,
                   PropertyStorageReadWriter propertyStorageReadWriter,
                   HashMapAgentStorage agentStorage,
                   AgentStorageReadWriter agentStorageReadWriter){
        this.userStorage = userStorage;
        this.userStorageReadWriter = userStorageReadWriter;
        this.propertyStorage = propertyStorage;
        this.propertyStorageReadWriter = propertyStorageReadWriter;
        this.agentStorage = agentStorage;
        this.agentStorageReadWriter = agentStorageReadWriter;
    }
}
