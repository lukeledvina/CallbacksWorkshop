package com.example.lukeledvina.callbacksworkshop;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CallbackFragment.CallbackClass{

    @BindView(R.id.activity_layout)
    protected ConstraintLayout layout;
    @BindView(R.id.callback_message_textview)
    protected TextView textView;


    private CallbackFragment callbackFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "The MainActivity is Toasting the Fragment", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.launch_fragment_button)
    protected void launchFragment() {

        callbackFragment = CallbackFragment.newInstance();
        callbackFragment.attachParent(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, callbackFragment).commit();



    }

    @Override
    public void changeTextView() {

        textView.setText("Callback from fragment received");
    }

    @Override
    public void changeBackroundColor() {

        layout.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void removeFragment() {
    getSupportFragmentManager().beginTransaction().remove(callbackFragment).commit();
    }
}
