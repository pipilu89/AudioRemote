package com.banana.audioremote;

import android.content.Context;
import android.hardware.ConsumerIrManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class ConsumerIr extends AppCompatActivity {
    private static final String TAG = "ConsumerIrTest";
    TextView mFreqsText;
    TextView mPatternText;
    ConsumerIrManager mCIR;

    /**
     * Initialization of the Activity after it is first created.  Must at least
     * call {@link android.app.Activity#setContentView setContentView()} to
     * describe what is to be displayed in the screen.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consumer_ir);

        // Get a reference to the ConsumerIrManager
        mCIR = (ConsumerIrManager)getSystemService(Context.CONSUMER_IR_SERVICE);

        // Set the OnClickListener for the button so we see when it's pressed.
        //findViewById(R.id.vol_down_button).setOnClickListener(mSendClickListener);
        findViewById(R.id.vol_down_button).setOnClickListener(mVolDownClickListener);
        findViewById(R.id.vol_up_button).setOnClickListener(mVolUpClickListener);
        findViewById(R.id.mute_button).setOnClickListener(mMuteClickListener);
        findViewById(R.id.sleep_button).setOnClickListener(mSleepClickListener);
        findViewById(R.id.get_freqs_button).setOnClickListener(mGetFreqsClickListener);
        mFreqsText = (TextView) findViewById(R.id.freqs_text);
        mPatternText = (TextView) findViewById(R.id.pattern_sent);
    }
    View.OnClickListener mSleepClickListener;
    {
        mSleepClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (!mCIR.hasIrEmitter()) {
                    Log.e(TAG, "No IR Emitter found\n");
                    mPatternText.setText("no IR found");
                    return;
                }

                // A pattern of alternating series of carrier on and off periods measured in
                // microseconds. Sleep.
                int[] pattern = {26,1816,9026,4500,553,579,553,553,579,553,579,553,553,553,579,553,579,553,553,553,579,1658,579,553,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,553,553,579,553,553,579,553,579,553,553,553,579,553,579,553,553,1684,553,1684,553,1684,553,1684,553,1684,553,1684,553,1684,553,41342,9000,2237,579,41342};
                //transmit frequency variable
                int transFreq = 38000;

                // transmit the pattern at 38KHz
                mCIR.transmit(transFreq, pattern);

                //display hasIrEmitter and transmission freq sent in textview
                mPatternText.setText("IR found\npattern sent\n" +transFreq);
            }
        };
    }

    View.OnClickListener mMuteClickListener;
    {
        mMuteClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (!mCIR.hasIrEmitter()) {
                    Log.e(TAG, "No IR Emitter found\n");
                    mPatternText.setText("no IR found");
                    return;
                }

                // A pattern of alternating series of carrier on and off periods measured in
                // microseconds. Mute.
                int[] pattern = {26,1816,9026,4500,579,553,553,553,579,553,579,553,553,553,579,553,579,553,579,553,553,1684,553,553,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,553,579,553,553,553,579,553,579,553,553,553,579,553,579,553,579,1658,579,1658,579,1658,553,1684,553,1684,553,1684,553,41316,9000,2237,553,96132};
                //transmit frequency variable
                int transFreq = 38000;

                // transmit the pattern at 38KHz
                mCIR.transmit(transFreq, pattern);

                //display hasIrEmitter and transmission freq sent in textview
                mPatternText.setText("IR found\npattern sent\n" +transFreq);
            }
        };
    }
    View.OnClickListener mVolUpClickListener;
    {
        mVolUpClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (!mCIR.hasIrEmitter()) {
                    Log.e(TAG, "No IR Emitter found\n");
                    mPatternText.setText("no IR found");
                    return;
                }

                // A pattern of alternating series of carrier on and off periods measured in
                // microseconds. Volume Up.
                int[] pattern = {26,1816,9026,4500,553,553,579,553,579,553,553,579,553,553,579,553,579,553,553,553,579,1658,579,553,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,553,553,553,579,1658,579,553,579,553,553,579,553,553,579,553,579,1658,579,1658,579,553,553,1684,553,1684,553,1684,553,1684,553,41395,9000,2237,553,96263};
                //transmit frequency variable
                int transFreq = 38000;

                // transmit the pattern at 38KHz
                mCIR.transmit(transFreq, pattern);

                //display hasIrEmitter and transmission freq sent in textview
                mPatternText.setText("IR found\npattern sent\n" +transFreq);
            }
        };
    }


    View.OnClickListener mVolDownClickListener;

    {
        mVolDownClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                if (!mCIR.hasIrEmitter()) {
                    Log.e(TAG, "No IR Emitter found\n");
                    mPatternText.setText("no IR found");
                    return;
                }

                // A pattern of alternating series of carrier on and off periods measured in
                // microseconds. Volume down.
                int[] pattern = {26,1816,9000,4500,579,553,579,553,553,553,579,553,579,553,553,553,579,553,579,553,553,1684,553,553,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,1658,579,553,579,553,553,579,553,553,579,553,579,553,553,553,579,553,579,1658,579,1658,579,1658,579,1658,579,1658,579,41316,9000,2237,579,96184};
                //transmit frequency variable
                int transFreq = 38000;

                // transmit the pattern at 38KHz
                mCIR.transmit(transFreq, pattern);

                //display hasIrEmitter and transmission freq sent in textview
                mPatternText.setText("IR found\npattern sent\n" +transFreq);
            }
        };
    }

    View.OnClickListener mGetFreqsClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            StringBuilder b = new StringBuilder();

            if (!mCIR.hasIrEmitter()) {
                mFreqsText.setText("No IR Emitter found!");
                Log.e(TAG, "No IR Emitter found!\n");
                return;
            }

            // Get the available carrier frequency ranges
            ConsumerIrManager.CarrierFrequencyRange[] freqs = mCIR.getCarrierFrequencies();
            b.append("IR Carrier Frequencies:\n");
            for (ConsumerIrManager.CarrierFrequencyRange range : freqs) {
                b.append(String.format("    %d - %d\n", range.getMinFrequency(), range.getMaxFrequency()));
            }
            mFreqsText.setText(b.toString());
        }
    };
}
