package externalinterfaces;

import controllers.AgentStorageReadWriter;

import java.io.IOException;

public class InitDatabaseAgent {
    /**
     * Initializes the agent database by creating a new HashMapAgentStorage
     * and a new AgentStorageReadWriter.
     */
    public static void main(String[] args) {
        HashMapAgentStorage agentStorage = new HashMapAgentStorage();
        AgentStorageReadWriter agentStorageReadWriter = new AgentStorageReadWriter(agentStorage);
        try {
            agentStorageReadWriter.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
