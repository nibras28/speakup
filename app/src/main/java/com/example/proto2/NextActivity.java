package com.example.proto2;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;
import java.util.Locale;

public class NextActivity extends AppCompatActivity {

    private Button searchButton;
    private EditText editText;
    private SpeechRecognizer recognizer;
    private TextView resultTextView;
    private DatabaseHelper mDbHelper;
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    private Button speechButton;
    private TextToSpeech textToSpeech;

    private Handler handler;

    private Runnable runnable;

   FirebaseDatabase fDatabase;
   DatabaseReference dRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDbHelper = new DatabaseHelper(this);

        addData("mixture", "Peanuts");

        addData("naan", "Gluten");

        addData("pizza", "Gluten");

        addData("cheese", "Lactose");

        addData("apple pie", "Gluten");

        addData("fresh cream", "Milk");

        addData("pumpkin pie", "Cinnamon");

        addData("almond", "Nut Allergy");

        addData("apple", "Oral Allergy Syndrome");

        addData("apricot", "Stone Fruit Allergy");

        addData("artichoke", "Insulin Allergy");

        addData("asaragus", "Allium Allergy");

        addData("avocado", "Oral Allergy Syndrome");

        addData("bamboo shoot", "Histamine Allergy");

        addData("banana", "Banana Allergy");

        addData("barley", "Gluten Allergy");

        addData("bean", "Legume Allergy");

        addData("blackberry", "Salicylate Allergy");

        addData("black-eyed bean", "Legume Allergy");

        addData("blueberry", "Salicylate Allergy");

        addData("myrtille", "acide salicylé");
        addData("bonito", "Histamine Allergy");

        addData("broad bean", "Legume Allergy");

        addData("broccoli", "Broccoli allergy");

        addData("brussels sprouts", "Cruciferous Allergy");

        addData("choux de Bruxelles", "allergie aux crucifères" );
        addData("buckwheat", "Gluten Allergy");

        addData("burdock", "Ragweed Allergy");

        addData("butter", "Milk allergy or Lactose intolerance");

        addData("butter bean", "Legume Allergy");

        addData("buttermilk", "Milk allergy or Lactose intolerance");

        addData("button mushroom", "Mushroom Allergy");

        addData("champignon", "ALLERGIES AUX CHAMPIGNONS");

        addData("cabbage", "Cruciferous Allergy");

        addData("carrot", "Hypersensitivity");

        addData("casein", "Milk allergy or Lactose intolerance");

        addData("cattle", "Alpha-gal Syndrome");

        addData("cauliflower", "Cruciferous Allergy");

        addData("celery", "Hypersensitivity");

        addData("cheese", "Milk allergy or Lactose intolerance");

        addData("cherry", "Stone Fruit Allergy");

        addData("chestnut", "Nut Allergy");

        addData("chicken", "Poultry Allergy");

        addData("chicory", "Insulin Allergy");

        addData("chinese cabbage", "Cruciferous Allergy");

        addData("cotton seed", "Seed Allergy");

        addData("cranberry", "Salicylate Allergy");

        addData("cream", "Milk allergy or Lactose intolerance");

        addData("crustaceans", "Shellfish Allergy");

        addData("custard", "Milk allergy or Lactose intolerance");

        addData("date", "Oral Allergy Syndrome");

        addData("deer", "Alpha-gal Syndrome");

        addData("duck", "Poultry Allergy");

        addData("eel", "Fish Allergy");

        addData("egg plant", "Nightshade Allergy");

        addData("eggs", "Poultry Allergy");

        addData("endive", "Insulin Allergy");

        addData("fructose", "Sugar Allergy OR Intolerance");

        addData("garlic", "Allium Allergy");

        addData("ail", "allergie à allium");
        addData("ginger", "Histamine Allergy");

        addData("ginkgo nut", "Nut Allergy");

        addData("globfish", "Fish Allergy");

        addData("glucose", "Sugar Allergy OR Intolerance");

        addData("goat", "Alpha-gal Syndrome");

        addData("grape", "LTP Allergy");

        addData("grapefruit", "Citrus Allergy");

        addData("guava", "Oral Allergy Syndrome");

        addData("goyave", "syndrome allergie buccale");

        addData("honey", "Honey Allergy");

        addData("hop", "Beer Allergy");

        addData("horse", "Alpha-gal Syndrome");

        addData("horse mackerel", "Fish Allergy");

        addData("horseradish", "Cruciferous Allergy");

        addData("huckleberry", "Salicylate Allergy");

        addData("ice cream", "Milk allergy / Lactose intolerance");

        addData("japanese pear", "Oral Allergy Syndrome");

        addData("japanese plum", "Stone Fruit Allergy");

        addData("kale", "Cruciferous Allergy");

        addData("kidney bean", "Legume Allergy");
        addData("kiwi", "Oral Allergy Syndrome");

        addData("konjac", "Potato Allergy");

        addData("kyona", "Cruciferous Allergy");

        addData("lactose", "Lactose Intolerance");

        addData("leek", "Allium Allergy");

        addData("lemon", "Citrus Allergy");

        addData("lait", "Intolérance au lactose");

        addData("poulette", "allergie au poulet");

        addData("poulette", "allergie au poulet");

        addData("lentil", "Legume Allergy");

        addData("lettuce", "LTP Allergy");

        addData("lima bean", "Legume Allergy");

        addData("lime", "Citrus Allergy");

        addData("loquat", "Oral Allergy Syndrome");

        addData("mackerel", "Fish Allergy");

        addData("milk", "Milk allergy / Lactose intolerance");

        addData("mineral water", "Aquagenic Urticaria");

        addData("mitsuba", "Hypersensitivity");

        addData("mume plum", "Stone Fruit Allergy");

        addData("mustard Spinach", "Cruciferous Allergy");

        addData("nectarine", "Stone Fruit Allergy");

        addData("nira", "Allium Allergy");

        addData("okra", "Histamine Allergy");

        addData("onion", "Allium Allergy");

        addData("orange", "Citrus Allergy");
        addData("orange pulp", "Citrus Allergy");

        addData("papaya", "Oral Allergy Syndrome");

        addData("Tarte à la citrouille", "cannelle");

        addData("pouding au caramel", "intolérants au lactose");

        addData("parsley", "Hypersensitivity");

        addData("parsnip", "Hypersensitivity");

        addData("passion fruit", "Oral Allergy Syndrome");

        addData("peach", "Stone Fruit Allergy");

        addData("peanut", "Peanut Allergy");

        addData("pear", "Oral Allergy Syndrome");

        addData("peas", "Legume Allergy");

        addData("pecan", "Nut Allergy");

        addData("pegia", "Legume Allergy");

        addData("peppermint", "Mint Allergy");

        addData("percifomes", "Fish Allergy");

        addData("pig", "Alpha-gal Syndrome");

        addData("pineapple", "Oral Allergy Syndrome");

        addData("popcorn", "Corn Allergy");

        addData("potato", "Potato Allergy");

        addData("prune", "Stone Fruit Allergy");

        addData("radish root", "Hypersensitivity");

        addData("rapeseed", "Seed Allergy");

        addData("raspberry", "Salicylate Allergy");

        addData("rice", "Rice Allergy");

        addData("royal jelly", "Honey Allergy");

        addData("rye", "Gluten Allergy");

        addData("safflower seed", "Seed Allergy");

        addData("salmon", "Fish Allergy");

        addData("salsify", "Insulin Allergy");

        addData("sansho", "Pepper Allergy");

        addData("sea bass", "Fish Allergy");

        addData("sea bream", "Fish Allergy");

        addData("sesame seed", "Seed Allergy");

        addData("shallot", "Allium Allergy");

        addData("sheep", "Alpha-gal Syndrome");

        addData("shelled mollusc", "Fish Allergy");

        addData("shiitake mushroom", "Mushroom Allergy");

        addData("shungiku", "Insulin Allergy");

        addData("sour cream", "Milk allergy / Lactose intolerance");

        addData("soybean", "Soy Allergy");

        addData("spearmint", "Mint Allergy");

        addData("spinach", "Histamine Allergy");

        addData("strawberry", "Salicylate Allergy");

        addData("sugar", "Sugar Allergy / Intolerance");

        addData("sugar beet", "Sugar Allergy / Intolerance");

        addData("sugarcane", "Sugar Allergy / Intolerance");

        addData("sultani", "Legume Allergy");

        addData("sultapya", "Legume Allergy");

        addData("sunflower seed", "Seed Allergy");

        addData("sweet corn", "Corn Allergy");

        addData("sweet pepper", "Nightshade Allergy");

        addData("sweet potato", "Potato Allergy");

        addData("taro", "Potato Allergy");

        addData("tea", "Tannin Allergy");

        addData("tetraodontiformes", "Fish Allergy");

        addData("tomato", "Nightshade Allergy");

        addData("trout", "Fish Allergy");

        addData("tuna", "Fish Allergy");

        addData("turkey", "Poultry Allergy");

        addData("welsh", "Allium Allergy");

        addData("wheat", "Gluten Allergy");

        addData("whey", "Milk allergy / Lactose intolerance");

        addData("white bean", "Legume Allergy");

        addData("yam", "Potato Allergy");

        addData("yogurt", "Milk allergy / Lactose intolerance");



        databaseHelper = new DatabaseHelper(this);
        database = databaseHelper.getWritableDatabase();

        editText = findViewById(R.id.edit_text);
        searchButton = findViewById(R.id.search_button);
        resultTextView = findViewById(R.id.result_text_view);
        speechButton= findViewById(R.id.speech_button);
        recognizer = SpeechRecognizer.createSpeechRecognizer(this);



                Intent recognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE, NextActivity.this.getPackageName());
                recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);


              //  recognizer.startListening(recognizerIntent);

        handler = new Handler();

        // Define a Runnable object to run the speech recognition process
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//                String prompt = "Please say something";
//                textToSpeech.speak(prompt, TextToSpeech.QUEUE_FLUSH, null, null);
//                recognizer.startListening(recognizerIntent);
//
//
//
//                handler.postDelayed(this, 9000); // Schedule the task to run again after 6 seconds
//            }
//        };
        runnable = new Runnable() {
            @Override
            public void run() {
                String prompt = "Please say the ingredient ";
                textToSpeech.speak(prompt, TextToSpeech.QUEUE_FLUSH, null, null);

                // Wait for the prompt to finish before starting the recognition process
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recognizer.startListening(recognizerIntent);
                    }
                }, 2000); // Wait for 2 seconds before starting the recognition process

                handler.postDelayed(this, 8000); // Schedule the task to run again after 9 seconds
            }
        };
                recognizer.setRecognitionListener(new RecognitionListener(){

            @Override
            public void onReadyForSpeech(Bundle params) {
                Log.d("Speech", "Ready for speech");
            }

            @Override
            public void onBeginningOfSpeech() {
                Log.d("Speech", "Beginning of speech");
            }

            @Override
            public void onRmsChanged(float rmsdB) {
                Log.d("Speech", "RMS changed");
            }

            @Override
            public void onBufferReceived(byte[] buffer) {
                Log.d("Speech", "Buffer received");
            }

            @Override
            public void onEndOfSpeech() {
                Log.d("Speech", "End of speech");
            }

            @Override
            public void onError(int error) {
                Log.e("Speech", "Error: " + error);
            }

            @Override
            public void onResults(Bundle results) {
                List<String> transcripts = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (transcripts != null && transcripts.size() > 0) {
                    String transcript = transcripts.get(0);
                    if (transcript.toLowerCase().contains("exit") || transcript.toLowerCase().contains("stop") || transcript.toLowerCase().contains("thank you")) {
                        finishAffinity();
                        System.exit(0);
                    }
                    editText.setText(transcript);
                    editText.onEditorAction(EditorInfo.IME_ACTION_DONE); // Automatically submit the input
                }
            }

            @Override
            public void onPartialResults(Bundle partialResults) {
                Log.d("Speech", "Partial results");
            }

            @Override
            public void onEvent(int eventType, Bundle params) {
                Log.d("Speech", "Event");
            }

            public void startSpeechInput(View view) {
                // Start the speech recognition process
                recognizer.startListening(recognizerIntent);
            }
            public void onDestroy() {

                        if (recognizer != null) {
                            recognizer.destroy();

                        }

                if (textToSpeech != null) {
                    textToSpeech.stop();
                    textToSpeech.shutdown();
                }
                    }});

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        recognizer.startListening(intent);


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // Do nothing
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = "SELECT column2 FROM data WHERE column1 = '" + s.toString() + "'";
                Cursor cursor = database.rawQuery(query, null);
                if (cursor.moveToNext()) {
                    String result = cursor.getString(0);
                    resultTextView.setText(result);
                    textToSpeech.speak(result, TextToSpeech.QUEUE_FLUSH, null, null);
                } else {
                    Toast.makeText(NextActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                    textToSpeech.speak("No data found", TextToSpeech.QUEUE_FLUSH, null, null);
                }
                cursor.close();
            }

            @Override
            public void afterTextChanged(Editable s) {
                // Do nothing
            }
        });



        speechButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the speech recognition process
                recognizer.startListening(recognizerIntent);
            }
        });

        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result = textToSpeech.setLanguage(Locale.US);
                if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TextToSpeech", "Language not supported");
                }
            } else {
                Log.e("TextToSpeech", "Initialization failed");
            }
        });
        handler.post(runnable);
    }


    private void addData(String column1, String column2) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();


        String sql = "INSERT INTO data (column1, column2) VALUES ('" + column1 + "', '" + column2 + "')";
        db.execSQL(sql);
    }


}


