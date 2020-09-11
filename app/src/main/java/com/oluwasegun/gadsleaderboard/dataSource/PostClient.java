package com.oluwasegun.gadsleaderboard.dataSource;

import com.oluwasegun.gadsleaderboard.model.SkillIQ;
import com.oluwasegun.gadsleaderboard.model.TopLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostClient {
    public static final String BASE_API_URI = "https://gadsapi.herokuapp.com/";
    private PostInterface postInterface;
    public static PostClient INSTANCE;

    public PostClient(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API_URI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    //Singleton
    public static PostClient getINSTANCE(){
        if(null == INSTANCE){
            INSTANCE = new PostClient();
        }
        return INSTANCE;
    }

    public Call<List<SkillIQ>> getTopSkill(){
        return postInterface.getTopSkill();
    }

    public Call<List<TopLearner>> getTopLearner(){
        return postInterface.getTopLearner();
    }
}
