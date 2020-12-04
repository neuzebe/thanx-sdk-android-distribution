package com.thanx.sdksampleapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.thanx.sdk.cardEncryption.CardEncryption;
import androidx.appcompat.app.AppCompatActivity;

public class CardEncryptionActivity extends AppCompatActivity {
  @SuppressLint("ShowToast")
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.card_encryption_activity);

    EditText encryptedNumberField = findViewById(R.id.encryptedNumber);

    // Replace this with the public key that comes from the Thanx API Signature endpoint
    String fakePublicKey = getResources().getString(R.string.fakePublicKey);

    findViewById(R.id.visaButton).setOnClickListener(
      view -> {
        String uid = ((EditText) findViewById(R.id.uid)).getText().toString();

        try {
          String encryptedNumber = new CardEncryption(
            CardEncryption.CardType.VISA,
            fakePublicKey,
            (uid.isEmpty() ? null : uid)
          ).encrypt(
            ((TextView) findViewById(R.id.visaCardNumber)).getText().toString()
          );

          encryptedNumberField.setText(encryptedNumber);

        } catch (CardEncryption.EncryptionError exception) {
          Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
      }
    );

    findViewById(R.id.mastercardButton).setOnClickListener(
      view -> {
        try {
          String encryptedNumber = new CardEncryption(
            CardEncryption.CardType.MASTERCARD,
            fakePublicKey,
            null
          ).encrypt(
            ((TextView) findViewById(R.id.mastercardCardNumber)).getText().toString()
          );

          encryptedNumberField.setText(encryptedNumber);

        } catch (CardEncryption.EncryptionError exception) {
          Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
      }
    );

    findViewById(R.id.amexButton).setOnClickListener(
      view -> {
        try {
          String encryptedNumber = new CardEncryption(
            CardEncryption.CardType.AMEX,
            fakePublicKey,
            null
          ).encrypt(
            ((TextView) findViewById(R.id.amexCardNumber)).getText().toString()
          );

          encryptedNumberField.setText(encryptedNumber);

        } catch (CardEncryption.EncryptionError exception) {
          Toast.makeText(this, exception.getMessage(), Toast.LENGTH_LONG).show();
        }
      }
    );
  }
}
