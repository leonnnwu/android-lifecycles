package com.example.android.lifecycles.step1;

import android.os.SystemClock;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class ChronometerViewModel extends ViewModel {
    private MutableLiveData<Long> startTimeLiveData = new MutableLiveData<>();

    private static final Long ONE_SECOND = 1000L;
    private long initTime;
    private SavedStateHandle savedStateHandle;

    public ChronometerViewModel(SavedStateHandle savedStateHandle) {
        this.savedStateHandle = savedStateHandle;

        Timer timer = new Timer();
        initTime = SystemClock.elapsedRealtime();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final long currentTime = (SystemClock.elapsedRealtime() - initTime)/1000;

                startTimeLiveData.postValue(currentTime);
            }
        }, ONE_SECOND, ONE_SECOND);
    }

    public LiveData<Long> getStartTime() {
        return this.startTimeLiveData;
    }
}
