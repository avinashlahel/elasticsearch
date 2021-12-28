package elastic.index;

import elastic.client.ElasticClient;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

public class IndexDocuments {

    final static RestHighLevelClient client = ElasticClient.getClient();


    public static void indexDocument(RestHighLevelClient client) {

        IndexRequest request = new IndexRequest("posts");

//        Map<String, Object> jsonMap = new HashMap<>();
//        jsonMap.put("user", "kimchy");
//        jsonMap.put("postDate", LocalDate.now());
//        jsonMap.put("message", "trying out Elasticsearch");
//
//        request.id("1").source(jsonMap);
//
//        try {
//            final IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
//            final String index = indexResponse.getIndex();
//            final String id = indexResponse.getId();
//            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
//                System.out.println("Document Created");
//            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
//                System.out.println("Document Updated");
//            }
//
//        } catch (IOException e) {
//
//        }
    }

    public static void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("posts");
        client.indices().delete(request, RequestOptions.DEFAULT);
    }

    public static void main(String[] args) throws IOException {
        final RestHighLevelClient client = ElasticClient.getClient();
        deleteIndex();
        client.close();

    }
}
