package com.oluwasegun.gadsleaderboard;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.oluwasegun.gadsleaderboard.dataSource.PostClient;
import com.oluwasegun.gadsleaderboard.model.SkillIQ;
import com.oluwasegun.gadsleaderboard.model.TopLearner;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataViewModel extends ViewModel {
    public MutableLiveData<List<SkillIQ>> skillMutableData = new MutableLiveData<>();
    public MutableLiveData<List<TopLearner>> topLearnerMutableData =new MutableLiveData<>();

    public void getTopSkill() {
        PostClient.getINSTANCE().getTopSkill().enqueue(new Callback<List<SkillIQ>>() {
            @Override
            public void onResponse(Call<List<SkillIQ>> call, Response<List<SkillIQ>> response) {
                if(response.isSuccessful())
                skillMutableData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<SkillIQ>> call, Throwable t) {
                Log.d("getTopSkill()", "onFailure: " + new Throwable(t));
            }
        });
    }
    public void getTopLearner(){
        PostClient.getINSTANCE().getTopLearner().enqueue(new Callback<List<TopLearner>>() {
            @Override
            public void onResponse(Call<List<TopLearner>> call, Response<List<TopLearner>> response) {
                if(response.isSuccessful())
                topLearnerMutableData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<TopLearner>> call, Throwable t) {
                Log.d("getTopLearner()", "onFailure: " + new Throwable(t));
            }
        });
    }
}
