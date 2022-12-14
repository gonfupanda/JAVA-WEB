package com.ipartek.formacion.Stripe;

import static spark.Spark.*;

import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;

public class StripeServer {
  private static Gson gson = new Gson();

  static class CreatePayment {
    @SerializedName("items")
    Object[] items;

    public Object[] getItems() {
      return items;
    }
  }

  static class CreatePaymentResponse {
    private String clientSecret;
    public CreatePaymentResponse(String clientSecret) {
      this.clientSecret = clientSecret;
    }
  }

  static Long calculateOrderAmount(Object[] items) {
    // Replace this constant with a calculation of the order's amount
    // Calculate the order total on the server to prevent
    // people from directly manipulating the amount on the client
    return 1400L;
  }

  public static void main(String[] args) {
    port(4242);
    staticFiles.externalLocation(Paths.get("public").toAbsolutePath().toString());

    // This is your test secret API key.
    Stripe.apiKey = "sk_test_51HJjTvKQqwGUxNnflxdd6kKmoXHYKvcaUnG21goIhloN9DjCI4PYX7u0yKbpRRSdlIORDJmAe4da7ZUQ0O0Ghial00lrosK8h1";

    post("/create-payment-intent", (request, response) -> {
      response.type("application/json");

      CreatePayment postBody = gson.fromJson(request.body(), CreatePayment.class);
      PaymentIntentCreateParams params =
        PaymentIntentCreateParams.builder()
          .setAmount(calculateOrderAmount(postBody.getItems()))
          .setCurrency("eur")
          .setAutomaticPaymentMethods(
            PaymentIntentCreateParams.AutomaticPaymentMethods
              .builder()
              .setEnabled(true)
              .build()
          )
          .build();

      // Create a PaymentIntent with the order amount and currency
      PaymentIntent paymentIntent = PaymentIntent.create(params);

      CreatePaymentResponse paymentResponse = new CreatePaymentResponse(paymentIntent.getClientSecret());
      return gson.toJson(paymentResponse);
    });
  }
}