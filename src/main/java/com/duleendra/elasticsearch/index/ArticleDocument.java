package com.duleendra.elasticsearch.index;

import com.duleendra.elasticsearch.client.ElasticClient;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.bootstrap.Elasticsearch;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * Created by Duleendra on 9/4/17.
 */
public class ArticleDocument {

    public static void main(String[] args) {

        Client client = ElasticClient.getClient();
        BulkRequestBuilder bulkRequest = client.prepareBulk();
        try {
            bulkRequest.add(client.prepareIndex(Indexer.INDEX[0], Indexer.TYPES[0], "2")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("documentid", "nica_BT_2016_200002")
                            .field("publication", "BT")
                            .field("headline", "Article Road ahead for rule of law in China is long and twisted")
                            .field("author", "James Anthony")
                            .field("published_date", "2016-02-14")
                            .field("language", "en")
                            .field("updated_date", new Date())
                            .field("content", "Singapore's efforts to reduce carbon emissions in the light of the Paris climate pact are to be lauded (Big polluters to face heftier fines; April 4). Combating global warming is everyone's responsibility. As industries contribute about 60 per cent of carbon emissions here, it is a wise move to ")
                            .endObject()));

            bulkRequest.add(client.prepareIndex(Indexer.INDEX[0], Indexer.TYPES[0], "3")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("documentid", "nica_BT_2016_200003")
                            .field("publication", "BT")
                            .field("headline", "Take the twist out of death spiral convertibles")
                            .field("author", "James Anthony")
                            .field("published_date", "2016-02-14")
                            .field("language", "en")
                            .field("updated_date", new Date())
                            .field("content", "HOCK LOCK SIEW THE so-called death spiral convertible bonds that lie at the heart of the proxy battle at Magnus Energy may be a wake-up call for all stakeholders. Regulators must ensure that the holders of such instruments are not skirting rules about control of a company; independent directors")
                            .endObject()));

            bulkRequest.add(client.prepareIndex(Indexer.INDEX[0], Indexer.TYPES[0], "4")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("documentid", "nica_ST_2016_200001")
                            .field("publication", "ST")
                            .field("headline", "New GM for Ang Mo Kio Town Council ")
                            .field("author", "Janne Mark")
                            .field("published_date", "2017-01-14")
                            .field("language", "en")
                            .field("updated_date", new Date())
                            .field("content","Ang Mo Kio Town Council has appointed a new general manager, about five months after its previous one was removed from duty and investigated by the anti-corruption watchdog. Mr Ang Boon Peng took over as secretary and general manager of the town council at the start of this month, according to a")
                            .endObject()));

            bulkRequest.add(client.prepareIndex(Indexer.INDEX[0], Indexer.TYPES[0], "5")
                    .setSource(jsonBuilder()
                            .startObject()
                            .field("documentid", "nica_ST_2016_200002")
                            .field("publication", "ST")
                            .field("headline", "\tJail terms now tied to quantity of drugs")
                            .field("author", "Danial Wong")
                            .field("published_date", "2017-01-14")
                            .field("language", "en")
                            .field("updated_date", new Date())
                            .field("content","Appeals Court directive provides for longer sentences, underlining Parliament's stance K. C. VIJAYAN SENIOR LAW CORRESPONDENT Convicted non-capital drug traffickers will now have their jail terms pegged to the quantum of drugs for which they are charged, instead of serving terms inclining ")
                            .endObject()));

        } catch (IOException e) {
            e.printStackTrace();
        }

        BulkResponse bulkResponse = bulkRequest.get();
        if(bulkResponse.hasFailures()) {
            System.out.println(bulkResponse.buildFailureMessage());
        }else {
            System.out.println("All the records successfully added");
        }

    }

}
