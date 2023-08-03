
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class RecordedSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:1080")
      .inferHtmlResources()
    ;
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_0.put("Accept-Encoding", "gzip, deflate, br");
    headers_0.put("Accept-Language", "ru,ru-RU;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_0.put("Cache-Control", "max-age=0");
    headers_0.put("Origin", "http://localhost:1080");
    headers_0.put("Sec-Fetch-Dest", "frame");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "same-origin");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    headers_0.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
    headers_0.put("sec-ch-ua", "Not_A Brand\";v=\"99\", \"Google Chrome\";v=\"109\", \"Chromium\";v=\"109");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_1 = new HashMap<>();
    headers_1.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_1.put("Accept-Encoding", "gzip, deflate, br");
    headers_1.put("Accept-Language", "ru,ru-RU;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_1.put("Sec-Fetch-Dest", "frame");
    headers_1.put("Sec-Fetch-Mode", "navigate");
    headers_1.put("Sec-Fetch-Site", "same-origin");
    headers_1.put("Upgrade-Insecure-Requests", "1");
    headers_1.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
    headers_1.put("sec-ch-ua", "Not_A Brand\";v=\"99\", \"Google Chrome\";v=\"109\", \"Chromium\";v=\"109");
    headers_1.put("sec-ch-ua-mobile", "?0");
    headers_1.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
    headers_2.put("sec-ch-ua", "Not_A Brand\";v=\"99\", \"Google Chrome\";v=\"109\", \"Chromium\";v=\"109");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "Windows");
    
    Map<CharSequence, String> headers_7 = new HashMap<>();
    headers_7.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_7.put("Accept-Encoding", "gzip, deflate, br");
    headers_7.put("Accept-Language", "ru,ru-RU;q=0.9,en-US;q=0.8,en;q=0.7");
    headers_7.put("Sec-Fetch-Dest", "frame");
    headers_7.put("Sec-Fetch-Mode", "navigate");
    headers_7.put("Sec-Fetch-Site", "same-origin");
    headers_7.put("Sec-Fetch-User", "?1");
    headers_7.put("Upgrade-Insecure-Requests", "1");
    headers_7.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36");
    headers_7.put("sec-ch-ua", "Not_A Brand\";v=\"99\", \"Google Chrome\";v=\"109\", \"Chromium\";v=\"109");
    headers_7.put("sec-ch-ua-mobile", "?0");
    headers_7.put("sec-ch-ua-platform", "Windows");


    ScenarioBuilder scn = scenario("RecordedSimulation")
      .exec(
        http("request_0")
          .post("/cgi-bin/login.pl")
          .headers(headers_0)
          .formParam("userSession", "136979.676873228HAtfiQcpVcQVzzzHtccHfpDfcHHf")
          .formParam("username", "jojo")
          .formParam("password", "bean")
          .formParam("login.x", "41")
          .formParam("login.y", "8")
          .formParam("JSFormSubmit", "off")
          .resources(
            http("request_1")
              .get("/cgi-bin/nav.pl?page=menu&in=home")
              .headers(headers_1),
            http("request_2")
              .get("/WebTours/images/flights.gif")
              .headers(headers_2),
            http("request_3")
              .get("/WebTours/images/itinerary.gif")
              .headers(headers_2),
            http("request_4")
              .get("/WebTours/images/in_home.gif")
              .headers(headers_2),
            http("request_5")
              .get("/WebTours/images/signoff.gif")
              .headers(headers_2),
            http("request_6")
              .get("/cgi-bin/login.pl?intro=true")
              .headers(headers_1)
          )
      )
      .pause(6)
      .exec(
        http("request_7")
          .get("/cgi-bin/welcome.pl?page=search")
          .headers(headers_7)
          .resources(
            http("request_8")
              .get("/cgi-bin/nav.pl?page=menu&in=flights")
              .headers(headers_1),
            http("request_9")
              .get("/WebTours/images/itinerary.gif")
              .headers(headers_2),
            http("request_10")
              .get("/WebTours/images/signoff.gif")
              .headers(headers_2),
            http("request_11")
              .get("/WebTours/images/in_flights.gif"),
            http("request_12")
              .get("/WebTours/images/home.gif"),
            http("request_13")
              .get("/cgi-bin/reservations.pl?page=welcome")
              .headers(headers_1),
            http("request_14")
              .get("/WebTours/images/button_next.gif")
          )
      )
      .pause(20)
      .exec(
        http("request_15")
          .post("/cgi-bin/reservations.pl")
          .headers(headers_0)
          .formParam("advanceDiscount", "0")
          .formParam("depart", "London")
          .formParam("departDate", "08/08/2023")
          .formParam("arrive", "Paris")
          .formParam("returnDate", "08/10/2023")
          .formParam("numPassengers", "1")
          .formParam("seatPref", "Window")
          .formParam("seatType", "First")
          .formParam("findFlights.x", "42")
          .formParam("findFlights.y", "5")
          .formParam(".cgifields", "roundtrip")
          .formParam(".cgifields", "seatType")
          .formParam(".cgifields", "seatPref")
      )
      .pause(14)
      .exec(
        http("request_16")
          .post("/cgi-bin/reservations.pl")
          .headers(headers_0)
          .formParam("outboundFlight", "241;181;08/08/2023")
          .formParam("numPassengers", "1")
          .formParam("advanceDiscount", "0")
          .formParam("seatType", "First")
          .formParam("seatPref", "Window")
          .formParam("reserveFlights.x", "38")
          .formParam("reserveFlights.y", "7")
      )
      .pause(56)
      .exec(
        http("request_17")
          .post("/cgi-bin/reservations.pl")
          .headers(headers_0)
          .formParam("firstName", "Jojo")
          .formParam("lastName", "Bean")
          .formParam("address1", "Vinnitskaya")
          .formParam("address2", "Sevastopol")
          .formParam("pass1", "Jojo Bean")
          .formParam("creditCard", "123456789098")
          .formParam("expDate", "12.26")
          .formParam("oldCCOption", "")
          .formParam("numPassengers", "1")
          .formParam("seatType", "First")
          .formParam("seatPref", "Window")
          .formParam("outboundFlight", "241;181;08/08/2023")
          .formParam("advanceDiscount", "0")
          .formParam("returnFlight", "")
          .formParam("JSFormSubmit", "off")
          .formParam("buyFlights.x", "59")
          .formParam("buyFlights.y", "7")
          .formParam(".cgifields", "saveCC")
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}
