package com.jack.multistateview;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jack.view.MultiStateView;

public class MainActivity extends AppCompatActivity implements MultiStateView.OnStateChangeListener {

    private MultiStateView mStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStateView = findViewById(R.id.state_view);
        mStateView.setOnStateChangeListener(this);
    }

    public void showContentView(View view) {
        mStateView.setViewState(MultiStateView.STATE_CONTENT);
    }

    public void showEmptyView(View view) {
        mStateView.setViewState(MultiStateView.STATE_EMPTY);
    }

    public void showErrorView(View view) {
        mStateView.setViewState(MultiStateView.STATE_ERROR);
    }

    public void showLoadingView(View view) {
        mStateView.setViewState(MultiStateView.STATE_LOADING);
    }

    @Override
    public void onStateChanged(int viewState) {
        String state;
        switch (viewState) {
            case MultiStateView.STATE_CONTENT:
                state = "STATE_CONTENT";
                break;
            case MultiStateView.STATE_EMPTY:
                state = "STATE_EMPTY";
                break;
            case MultiStateView.STATE_ERROR:
                state = "STATE_ERROR";
                break;
            case MultiStateView.STATE_LOADING:
                state = "STATE_LOADING";
                break;
            case MultiStateView.STATE_UNKNOWN:
            default:
                state = "STATE_UNKNOWN";
                break;
        }
        Toast.makeText(this, "State changed,current state is " + state, Toast.LENGTH_SHORT).show();
    }
}
