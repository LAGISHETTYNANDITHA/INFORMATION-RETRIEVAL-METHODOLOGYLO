package com.example.chatbot;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class GeminiResp {
    public static void getResponse (ChatFutures chatModel, String query, ResponseCallback callback) {

        Content.Builder userMessageBuilder = new Content.Builder();

        userMessageBuilder.setRole("user");

        userMessageBuilder.addText(query);

        Content userMessage = userMessageBuilder.build();

        Executor executor = Runnable::run;


        ListenableFuture<GenerateContentResponse> response = chatModel.sendMessage(userMessage);

        Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
            @Override

            public void onSuccess(GenerateContentResponse result) {
                String resultText = result.getText();
                callback.onResponse(resultText);
            }

            @Override
            public void onFailure(Throwable throwable) {
                throwable.printStackTrace();
                callback.onError(throwable);
            }
        }, executor);
    }
    public GenerativeModelFutures getModel(){
        String apikey=BuildConfig.apikey;
        SafetySetting harassmentSafety = new SafetySetting(HarmCategory.HARASSMENT, Block Threshold.ONLY_HIGH);

        GenerationConfig.Builder configBuilder = new GenerationConfig.Builder();

        configBuilder.temperature = 0.9f;

        configBuilder.topk = 16;

        configBuilder.topp = 0.1f;

        GenerationConfig generationConfig = configBuilder.build();

        Object modelName;
        GenerativeModel gm = new GenerativeModel(

                modelName : "gemini-1.5-flash",

                apikey,

                generationConfig,

                Collections.singletonList(harassmentSafety)
        );
        return GenerativeModelFutures.from(gm);
    }

}
