package com.example.logisticapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class BarCodeReader extends AppCompatActivity {
    private DecoratedBarcodeView barcodeView;
    private String lastText;


    private BarcodeCallback callback = new BarcodeCallback() {

        @Override
        public void barcodeResult(BarcodeResult result) {
            if(result.getText() == null || result.getText().equals(lastText)) {
                return;
            }

            lastText = result.getText();
            barcodeView.setStatusText(result.getText());

            if (lastText.equals("Cucumber")){
                Intent camAct = new Intent(BarCodeReader.this, CargoCheck.class);
                startActivity(camAct);
            }

        }

    @Override
    public void possibleResultPoints(List<ResultPoint> resultPoints) {
    }
};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(null);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcodereader);
        barcodeView = findViewById(R.id.scannerView);
        Collection<BarcodeFormat> formats = Arrays.asList(BarcodeFormat.QR_CODE, BarcodeFormat.CODE_39);
        barcodeView.getBarcodeView().setDecoderFactory(new DefaultDecoderFactory(formats));
        barcodeView.initializeFromIntent(getIntent());
        barcodeView.decodeContinuous(callback);
    }

    @Override
    protected void onResume() {
        super.onResume();

        barcodeView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();

        barcodeView.pause();
    }

    public void pause(View view) {
        barcodeView.pause();
    }

    public void resume(View view) {
        barcodeView.resume();
    }

    public void triggerScan(View view) {
        barcodeView.decodeSingle(callback);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return barcodeView.onKeyDown(keyCode, event) || super.onKeyDown(keyCode, event);
    }
}