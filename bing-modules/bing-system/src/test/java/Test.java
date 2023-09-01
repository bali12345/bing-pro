import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;

import java.util.Date;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        /*ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("hello-world");
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.addAddress("192.168.43.136:5701");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);
        IMap<String,String> map = client.getMap("my-distributed-map");


        map.put("1", "John");
        map.put("2", "Mary");
        map.put("3", "Jane");*/
        getCatch();
    }



    public static void getCatch(){
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("hello-world");

        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig.addAddress("192.168.43.136:5701");

        HazelcastInstance client = HazelcastClient.newHazelcastClient(clientConfig);


        IMap <String,String> map = client.getMap("MY-DISTRIBUTED-MAP");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        client.shutdown();
    }
}
