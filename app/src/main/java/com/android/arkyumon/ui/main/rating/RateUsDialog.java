/*
 *  Copyright (C) 2019
 *
 *  Licensed under the MIT License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://spit.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.android.arkyumon.ui.main.rating;

import androidx.lifecycle.ViewModelProviders;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.arkyumon.ViewModelProviderFactory;
import com.android.arkyumon.ui.base.BaseDialog;
import com.android.arkyumon.R;
import com.android.arkyumon.databinding.DialogRateUsBinding;

import dagger.android.support.AndroidSupportInjection;
import javax.inject.Inject;

/**
 * Created by CodersClan on 10/07/17.
 */

public class RateUsDialog extends BaseDialog implements RateUsCallback {

    private static final String TAG = RateUsDialog.class.getSimpleName();
    @Inject
    ViewModelProviderFactory factory;
    private RateUsViewModel mRateUsViewModel;

    public static RateUsDialog newInstance() {
        RateUsDialog fragment = new RateUsDialog();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void dismissDialog() {
        dismissDialog(TAG);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        DialogRateUsBinding binding = DataBindingUtil.inflate(inflater, R.layout.dialog_rate_us, container, false);
        View view = binding.getRoot();

        AndroidSupportInjection.inject(this);
        mRateUsViewModel = ViewModelProviders.of(this,factory).get(RateUsViewModel.class);
        binding.setViewModel(mRateUsViewModel);

        mRateUsViewModel.setNavigator(this);

        return view;
    }

    public void show(FragmentManager fragmentManager) {
        super.show(fragmentManager, TAG);
    }
}
