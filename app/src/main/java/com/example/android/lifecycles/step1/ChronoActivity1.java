/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.lifecycles.step1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateVMFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

import com.example.android.codelabs.lifecycle.R;


public class ChronoActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.timer_textview);

        ChronometerViewModel chronometerViewModel =
                ViewModelProviders.of(this, new SavedStateVMFactory(this)).get(ChronometerViewModel.class);


        chronometerViewModel.getStartTime().observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long time) {
                textView.setText(time + " seconds elapsed.");
            }
        });

    }
}
