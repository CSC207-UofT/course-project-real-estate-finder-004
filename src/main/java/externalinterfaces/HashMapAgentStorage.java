package externalinterfaces;

import java.io.IOException;

public class HashMapAgentStorage {
    public static void main(String[] args) {
        HashMapAgentStorage agentStorage = new HahMapAgentStorage();
        AgentStorageReadWriter agentStorageReadWriter = new AgentStorageReadWriter(agentStorage);
        try {
            agentStorageReadWriter.saveToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
