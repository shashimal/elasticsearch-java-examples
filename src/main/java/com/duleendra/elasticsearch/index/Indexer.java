package com.duleendra.elasticsearch.index;

import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

/**
 * Created by Duleendra on 8/4/17.
 */
public class Indexer {
    public static String INDEX[] = {"newslink"};
    public static String TYPES[] = {"article","image"};

    public  IndexResponse indexDocument(Client client, String index, String type, String builder ) {
        IndexResponse response = client.prepareIndex(index, type)
                .setSource(builder)
                .get();
        return response;
    }


}
