//package com.example.wordup.Activities;
//
//import android.media.MediaPlayer;
//import android.os.Bundle;
//import android.provider.MediaStore;
//import android.speech.tts.TextToSpeech;
//import android.speech.tts.UtteranceProgressListener;
//import android.util.Log;
//import android.view.View;
//import android.widget.ImageButton;
//import android.widget.ImageView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.example.wordup.Models.QuestionModel;
//import com.example.wordup.R;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//
//public class QuestionActivity extends AppCompatActivity {
//
//    private MediaPlayer mp;
//    private ImageButton btnSpeak;
//    private TextView questionText;
//    List<QuestionModel> questionModels = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_question);
//
//        String category = getIntent().getStringExtra("category");
//        TextView categoryTitle = findViewById(R.id.category_title);
//        ImageView categoryImage = findViewById(R.id.category_image);
//        categoryTitle.setText(category.substring(0, 1).toUpperCase()+category.substring(1));
//
//        switch(category){
//            case "animals":
//                questionModels.add(new QuestionModel("hippopotamus", "/ˌhɪp.əˈpɒt.ə.məs/",
//                        new int[]{R.drawable.hippo, R.drawable.whale}, 0));
//                questionModels.add(new QuestionModel("whale", "/weɪl/",
//                        new int[]{R.drawable.hippo, R.drawable.whale}, 1));
//                break;
//            case "weather":
//                questionModels.add(new QuestionModel("downpour", "/ˈdaʊn.pɔːr/",
//                        new int[]{R.drawable.hippo, R.drawable.downpour}, 0));
//                questionModels.add(new QuestionModel("gale", "/ɡeɪl/",
//                        new int[]{R.drawable.hippo, R.drawable.gale}, 1));
//                break;
//        }
//
//        btnSpeak = findViewById(R.id.btn_speak);
//        questionText = findViewById(R.id.question1);
//
//
//        btnSpeak.setOnClickListener(view -> playSound());
//    }
//
//
//    private void playSound() {
//        if (mp != null) {
//            if (mp.isPlaying()) {
//                mp.stop();
//            }
//            mp.release();
//            mp = null;
//        }
//
//
//        mp = MediaPlayer.create(this, R.raw.hippopotamus);
//        if (mp != null) {
//            mp.setOnCompletionListener(mediaPlayer -> {
//                mediaPlayer.release();
//                mp = null;
//            });
//            mp.start();  // safe to call directly here
//        }
//    }
//
//
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (mp != null) {
//            if (mp.isPlaying()) {
//                mp.stop();
//            }
//            mp.release();
//            mp = null;
//        }
//    }
//
//    private String capitalize(String text) {
//        return text.substring(0, 1).toUpperCase() + text.substring(1);
//    }
//
//}
