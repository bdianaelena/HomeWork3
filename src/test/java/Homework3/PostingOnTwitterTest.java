package Homework3;

import com.endava.utils.EnvReader;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class PostingOnTwitterTest {

    @Test
    public void createTest() {

        given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .contentType(ContentType.JSON)
                .auth()
                .oauth(EnvReader.getApiKey(),
                        EnvReader.getApiKeySecret(),
                        EnvReader.getAccessToken(),
                        EnvReader.getAccessTokenSecret())
                .queryParam("status","Diana Badita: Posting on Twitter")
                .header("Content-Type", "application/json")
                .when().log().all()
                .post("https://api.twitter.com/1.1/statuses/update.json").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void getTest() {

        given().baseUri(EnvReader.getBaseUri())
                .basePath(EnvReader.getBasePath())
                .contentType(ContentType.JSON)
                .auth()
                .oauth(EnvReader.getApiKey(),
                        EnvReader.getApiKeySecret(),
                        EnvReader.getAccessToken(),
                        EnvReader.getAccessTokenSecret())
                .queryParam("id","1554884560613154817")
                .when().log().all()
                .get("https://api.twitter.com/1.1/statuses/user_timeline.json").prettyPeek()
                .then()
                .statusCode(HttpStatus.SC_OK);
    }

}
