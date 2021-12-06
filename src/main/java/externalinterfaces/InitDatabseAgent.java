package externalinterfaces;

import controllers.AgentStorageReadWriter;

import java.io.IOException;

public class InitDatabseAgent {
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
