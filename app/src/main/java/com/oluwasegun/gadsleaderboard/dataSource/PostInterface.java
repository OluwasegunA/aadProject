package com.oluwasegun.gadsleaderboard.dataSource;

import com.oluwasegun.gadsleaderboard.model.SkillIQ;
import com.oluwasegun.gadsleaderboard.model.TopLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface PostInterface {
    @GET("api/skilliq")
    Call<List<SkillIQ>> getTopSkill();

    @GET("api/hours")
    Call<List<TopLearner>> getTopLearner();
}
