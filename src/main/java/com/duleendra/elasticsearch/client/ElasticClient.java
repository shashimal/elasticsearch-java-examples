package com.duleendra.elasticsearch.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by Duleendra on 5/4/17.
 */
public class ElasticClient {

    private final static String ES_HOSTS[] = {"localhost"};
    private final static int PORT = 9300;

    private static Client client;

    public static Client getClient() {
        try {
            client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ES_HOSTS[0]), PORT));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return client;
    }
}
