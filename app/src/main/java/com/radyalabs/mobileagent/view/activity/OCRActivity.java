package com.radyalabs.mobileagent.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.radyalabs.mobileagent.R;
import com.radyalabs.mobileagent.model.api.OCR;
import com.radyalabs.mobileagent.viewmodel.OCRViewModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OCRActivity extends AppCompatActivity {

    @BindView(R.id.stringKtp)
    TextView stringKtp;
    @BindView(R.id.url)
    EditText url;
    @BindView(R.id.btnScan)
    Button btnScan;

    private OCRViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_ocr);
        viewModel = ViewModelProviders.of(this).get(OCRViewModel.class);
        ButterKnife.bind(this);
    }

    private void getOCRText(String url) {

        viewModel.showLoading(this, false);
        viewModel.getOCRText(url);
        viewModel.getApiResponse().observe(this, apiResponse -> {

            viewModel.dismissLoading();

            OCR data = (OCR) apiResponse.getData();

            String nik;
            String name;
            String ttl;

            nik = data.getRegions().get(1).getLines().get(1).getWords().get(0).getText();
            name = data.getRegions().get(1).getLines().get(2).getWords().get(1).getText() + " " +
                    data.getRegions().get(1).getLines().get(2).getWords().get(2).getText();
            ttl = data.getRegions().get(1).getLines().get(3).getWords().get(0).getText() + " " +
                    data.getRegions().get(1).getLines().get(3).getWords().get(1).getText();

            String ktp = "";

//            ktp = "RESULT\n\n" + "NIK : " + nik + "\n" + "NAMA : " + name + "\n" + "TTL : " + ttl;

            try {
                ktp = new Gson().toJson(data);
            }catch (Exception e){
                e.printStackTrace();
            }

            stringKtp.setText(ktp);

        });

    }

    @OnClick(R.id.btnScan)
    public void onViewClicked() {

        String urlKTP = url.getText().toString();
        if (!TextUtils.isEmpty(urlKTP)){
            getOCRText(urlKTP);
        }else {
            Toast.makeText(this, "Please input ktp url first", Toast.LENGTH_SHORT).show();
        }

    }
}
