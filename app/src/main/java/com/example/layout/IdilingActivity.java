package com.example.layout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;
import androidx.test.espresso.IdlingResource;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class IdilingActivity extends Activity implements View.OnClickListener,
        MessageDelayer.DelayerCallback {

    // The TextView used to display the message inside the Activity.
    private TextView mTextView;

    // The EditText where the user types the message.
    private EditText mEditText;

    // The Idling Resource which will be null in production.
    @Nullable
    private SimpleIdlingResource mIdlingResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idiling);

        // Set the listeners for the buttons.
        findViewById(R.id.changeTextBt).setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textToBeChanged);
        mEditText = (EditText) findViewById(R.id.editTextUserInput);
    }

    @Override
    public void onClick(View view) {
        // Get the text from the EditText view.
        final String text = mEditText.getText().toString();

        if (view.getId() == R.id.changeTextBt) {
            // Set a temporary text.
            mTextView.setText(R.string.waiting_msg);
            // Submit the message to the delayer.
            MessageDelayer.processMessage(text, this, mIdlingResource);
        }
    }

    @Override
    public void onDone(String text) {
        // The delayer notifies the activity via a callback.
        mTextView.setText(text);
    }

    /**
     * Only called from test, creates and returns a new {@link SimpleIdlingResource}.
     */
    @VisibleForTesting
    @NonNull
    public IdlingResource getIdlingResource() {
        if (mIdlingResource == null) {
            mIdlingResource = new SimpleIdlingResource();
        }
        return mIdlingResource;
    }
}