package com.example.mrmaj.hideyourmessage;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrmaj.hideyourmessage.Encrypt;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    EditText message, key;
    TextView encryptedMessage;

    String messageString, tempKey, encMessage, decMessage, name;
    Integer keyInt;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton button = findViewById(R.id.encryptButton);
        ImageButton button2 = findViewById(R.id.decryptButton);

        message = findViewById(R.id.Message);
        key = findViewById(R.id.Key);


        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                messageString = message.getText().toString();
                tempKey = key.getText().toString();
                messageString = messageString.toLowerCase();
                if (tempKey.trim().length() == 0) {
                    tempKey = "0";
                }if (messageString.trim().length() == 0) {
                    messageString = "Please enter a message to encrypt";
                }
                /*

                EASTEREGGS / FUNNY

                 */

                if (messageString.equals("send nudes") & tempKey.equals("69")) {
                    messageString = "Hentai bakaaa";
                    tempKey = "0";
                    keyInt = Integer.parseInt(tempKey);
                    Encrypt(messageString, keyInt);
                    tempKey = tempKey.replaceAll("\\s","");
                }

                else if (tempKey.matches("[0-9]+")){
                    keyInt = Integer.parseInt(tempKey);
                    Encrypt(messageString, keyInt);
                    tempKey = tempKey.replaceAll("\\s", "");
                }else{
                    messageString = "Please only use numbers as a key";
                    tempKey = "0";
                    keyInt = Integer.parseInt(tempKey);
                    Encrypt(messageString, keyInt);
                    tempKey = tempKey.replaceAll("\\s", "");
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                messageString = message.getText().toString();
                tempKey = key.getText().toString();
                messageString = messageString.toLowerCase();
                if (tempKey.trim().length() == 0) {
                    tempKey = "0";
                }
                if (messageString.trim().length() == 0) {
                    messageString = "Please enter a message to decrypt";
                }
                 /*

                EASTEREGGS / FUNNY

                 */
                if (messageString.equals("android'chan") && tempKey.equals("<3")){
                    messageString = "Senpai... watashi wa daisuki desu.";
                    tempKey = "0";
                    name = "daisuki";
                    try {
                        Funny(name);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    tempKey = tempKey.replaceAll("\\s","");
                    keyInt = Integer.parseInt(tempKey);
                    Decrypt(messageString, keyInt);
                }

                else if (tempKey.matches("[0-9]+")){
                    keyInt = Integer.parseInt(tempKey);
                    Decrypt(messageString, keyInt);
                    tempKey = tempKey.replaceAll("\\s", "");
                }else{
                    messageString = "Please only use numbers as a key";
                    tempKey = "0";
                    keyInt = Integer.parseInt(tempKey);
                    Decrypt(messageString, keyInt);
                    tempKey = tempKey.replaceAll("\\s", "");
                }

            }
        });
    }

    public void Encrypt(String messageString,int keyInt){

        encMessage = Encrypt.encrypt(messageString, keyInt);
        encryptedMessage = findViewById(R.id.encryptedMessage);
        encryptedMessage.setText(encMessage);
    }
    public void Decrypt(String messageString,int keyInt){

        decMessage = Decrypt.decrypt(messageString, keyInt);
        encryptedMessage = findViewById(R.id.encryptedMessage);
        encryptedMessage.setText(decMessage);
    }
    public void Funny(String name) throws InterruptedException {
        if (name.equals("daisuki")){
            image = findViewById(R.id.image);
            image.setImageResource(R.drawable.easteregg_1);
            //Timer
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    image.setImageResource(R.drawable.transparent);
                    encryptedMessage.setText(R.string.enterMessage);
                }
            }, 3000); // Millisecond 1000 = 1 sec

        }
    }
}
