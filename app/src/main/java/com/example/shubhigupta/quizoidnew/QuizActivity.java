package com.example.shubhigupta.quizoidnew;

import android.Manifest;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shubhigupta.quizoidnew.Database.DBHelper;

import java.util.ArrayList;

public class QuizActivity extends Activity implements OnClickListener {
    LinearLayout LinearLay;
    TextView tv, tv2, tv3, tv4,skip;
    RadioGroup rg;
    MediaPlayer mp;
    ProgressBar pb;
    int scr = 0, nscr = 1;
    int dummy = 0;
    public int questions ;
    private SQLiteDatabase db;
    private static final String x = "SELECT * FROM questions" ;
    private Cursor c;
    CountDownTimer timer;
    String n;
    int done[] = new int[11];
    int qid = 1;
    boolean helplines[] = new boolean[3];
    ArrayList<String> HelplineNames = new ArrayList<>(3);
    public static final int HELPLINE1 = 0;
    public static final int HELPLINE2 = 1;
    public static final int HELPLINE3 = 2;
    public static final int  NO_OF_LIVES = 5;
    //int PresentCountOfLives = NO_OF_LIVES;
    TextView option1,option2,option3,option4;
    public static final int OPTION1 = 0;
    public static final int OPTION2 = 1;
    public static final int OPTION3 = 2;
    public static final int OPTION4 = 3;
    int SELECTED_BUTTON = -1;
    CountDownTimer Phonetimer;

    //Own Timer settings
    //Declare a variable to hold count down timer's paused status
    private boolean isPaused = false;
    //Declare a variable to hold count down timer's paused status
    private boolean isCanceled = false;

    //Declare a variable to hold CountDownTimer remaining time
    private long timeRemaining = 0;
    String name;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("TAG", "onCreate: ");
        questions = 0;
        scr = 0;
        setContentView(R.layout.activity_quiz);
        tv = (TextView) findViewById(R.id.textView1);
        // for score
        tv2 = (TextView) findViewById(R.id.textView14);
        // for time
        tv3 = (TextView) findViewById(R.id.textView3);
        tv4 = (TextView) findViewById(R.id.textView4);
        LinearLay = (LinearLayout) findViewById(R.id.linearLayout);
        //skip = (TextView) findViewById(R.id.skip);

        name = getIntent().getStringExtra("name");
        qid = getIntent().getIntExtra("id",1);
        //qid = 5;
        HelplineNames.add("Expert advice");
        HelplineNames.add("50 - 50");
        HelplineNames.add("Double dip");

        option1 = (TextView) findViewById(R.id.option1);
        option2 = (TextView) findViewById(R.id.option2);
        option3 = (TextView) findViewById(R.id.option3);
        option4 = (TextView) findViewById(R.id.option4);

        openDatabase();
        c = db.rawQuery(x, null);
        c.moveToFirst();
        startCount(5000);
        getQuestion();

        tv2.setText("Score: " + scr);
//        skip.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(SELECTED_BUTTON == -1){
//                    DoubleDip();
//                }
//                else{
//                    startCount(5000);
//                    if(questions < 20){
//                        getQuestion();
//                    }
//                    else{
//                        Toast.makeText(getApplicationContext(), "You have completed the quiz", Toast.LENGTH_SHORT).show();
//                        //timer.cancel();
//                        Intent i = new Intent(getApplicationContext(), LastActivity.class);
//                        i.putExtra("score", scr);
//                        i.putExtra("Name", name);
//                        i.putExtra("CompletedTest",true);
//                        startActivity(i);
//                    }
//                }
//            }
//        });


        option1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getSelectedButton(OPTION1);
                //timer.cancel();
                OnclickerSub();
                timeDelay(1);
                //OnClicker();

            }
        });
        option2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getSelectedButton(OPTION2);
                //timer.cancel();
                OnclickerSub();
                timeDelay(1);
                //OnClicker();
            }
        });
        option3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getSelectedButton(OPTION3);
                //timer.cancel();
                OnclickerSub();
                timeDelay(1);
                //OnClicker();
            }
        });
        option4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                getSelectedButton(OPTION4);
                //timer.cancel();
                OnclickerSub();
                timeDelay(1);
                //refreshButtons();
                //OnClicker();
            }
        });



    }

    public void OnclickerSub(){
        int res = SELECTED_BUTTON;
        int ans = Integer.parseInt(c.getString(6));
        if (res == ans) {
            // correct answer.
            switch (res) {
                case 0: option1.setBackgroundColor(getResources().getColor(R.color.skyblue)); break;
                case 1: option2.setBackgroundColor(getResources().getColor(R.color.skyblue)); break;
                case 2: option3.setBackgroundColor(getResources().getColor(R.color.skyblue)); break;
                case 3: option4.setBackgroundColor(getResources().getColor(R.color.skyblue)); break;
            }

            scr ++;
            tv2.setText("Score: " + scr);
        } else {

            switch (res) {
                case 0: option1.setBackgroundColor(getResources().getColor(R.color.red)); break;
                case 1: option2.setBackgroundColor(getResources().getColor(R.color.red)); break;
                case 2: option3.setBackgroundColor(getResources().getColor(R.color.red)); break;
                case 3: option4.setBackgroundColor(getResources().getColor(R.color.red)); break;
            }
            switch (ans) {
                case 0: option1.setBackgroundColor(getResources().getColor(R.color.lightgreen)); break;
                case 1: option2.setBackgroundColor(getResources().getColor(R.color.lightgreen)); break;
                case 2: option3.setBackgroundColor(getResources().getColor(R.color.lightgreen)); break;
                case 3: option4.setBackgroundColor(getResources().getColor(R.color.lightgreen)); break;
            }
        }
    }

//    public void OnClicker(){
//        refreshButtons();
//
//        if (questions < 10) {
//            c.moveToNext();
//            // rg.removeAllViews();
//            //timeDelay(1);
//            //refreshButtons();
//            getQuestion();
//            timer.cancel();
//            pb.setProgress(100);
//            startCount(5000);
//        } else {
//            Toast.makeText(getApplicationContext(), "You have completed the quiz", Toast.LENGTH_SHORT).show();
//            //timer.cancel();
//            Intent i = new Intent(getApplicationContext(), LastActivity.class);
//            i.putExtra("score", scr);
//            i.putExtra("Name", n);
//            i.putExtra("CompletedTest",true);
//            startActivity(i);
//        }
//
//    }

    public void timeDelay(int n){
        /*
        timer=new CountDownTimer(n, 1000) {


            public void onTick(long millisUntilFinished) {
                tv3.setText("" + millisUntilFinished / 1000);
                nscr=(int)millisUntilFinished/2000;
                pb.setProgress(pb.getProgress()-5);
            }

            public void onFinish() {

            }
        }.start();
        */
        for (int i = 0;i < n ; i++){
            LoopForOneSecond();
        }

    }
    protected void openDatabase() {
        db = openOrCreateDatabase("QuizDB.db", Context.MODE_PRIVATE, null);
    }

    public static int random(){
        return (int) Math.round((Math.random()*1000)%35);
    }

    public void getSelectedButton(int n){
        SELECTED_BUTTON = n;
    }

    public void LoopForOneSecond(){
        long startTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - startTime < 1000);
    }

    protected void getQuestion() {
        if (questions < 20) {
            c.moveToNext();
            timer.cancel();
            startCount(5000);
            refreshButtons();
        } else {
            Toast.makeText(getApplicationContext(), "You have completed the quiz", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), LastActivity.class);
            i.putExtra("score", scr);
            i.putExtra("Name", n);
            i.putExtra("CompletedTest",true);
            startActivity(i);
        }

        c.moveToFirst();
        boolean flag = true;
        while (flag) {
            if (qid != Integer.parseInt(c.getString(0))) {
                if (!c.isLast())
                    c.moveToNext();
                else
                    c.moveToFirst();
            } else {
                flag = false;
                qid++;
            }
        }
        tv.setText(c.getString(1));
        //i am putting buttons.
        // new code.
        option1.setText(c.getString(2));
        option2.setText(c.getString(3));
        option3.setText(c.getString(4));
        option4.setText(c.getString(5));
        questions++;


        int i = HELPLINE1;
        if (helplines[i] == false) {
            Button btn = new Button(this);
            btn.setId(i + 4);
            btn.setText(HelplineNames.get(i));
            LinearLay.addView(btn);
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOnClickListener(HELPLINE1);
                }
            });
        }

        i = HELPLINE2;
        if (helplines[i] == false) {
            Button btn = new Button(this);
            btn.setId(i + 4);
            btn.setText(HelplineNames.get(i));
            LinearLay.addView(btn);
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOnClickListener(HELPLINE2);
                }
            });
        }

        i = HELPLINE3;
        if (helplines[i] == false) {
            Button btn = new Button(this);
            btn.setId(i + 4);
            btn.setText(HelplineNames.get(i));
            LinearLay.addView(btn);
            btn.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    setOnClickListener(HELPLINE3);
                }
            });
        }
    }

    private void setOnClickListener(int num) {
        refreshButtons();
        switch (num) {
            case 0:
                if (!helplines[0])
                    phoneOfFiend();
                else
                    Toast.makeText(this, " Lifeline can only be used once :) ", Toast.LENGTH_SHORT).show();
                helplines[0] = true;
                break;
            case 1:
                if (!helplines[1])
                    FiftyFifty();
                else
                    Toast.makeText(this, " Lifeline can only be used once :) ", Toast.LENGTH_SHORT).show();
                helplines[1] = true;
                break;
            case 2:
                if (!helplines[2])
                    DoubleDip();
                else
                    Toast.makeText(this, " Lifeline can only be used once :) ", Toast.LENGTH_SHORT).show();
                helplines[2] = true;
                break;

        }
    }

    public  int TIME = 20;
    protected void startCount(int n) {
        if(questions == 20){
            return ;
        }
        tv4.setText("Seconds Remaining");
        long millisInFuture = n; //30 seconds
        long countDownInterval = 1000; //1 second


        //Initialize a new CountDownTimer instance
        timer = new CountDownTimer(millisInFuture,countDownInterval){
            public void onTick(long millisUntilFinished){
                //do something in every tick
                if(isPaused || isCanceled)
                {
                    //If the user request to cancel or paused the
                    //CountDownTimer we will cancel the current instance
                    cancel();
                }
                else {
                    //Display the remaining seconds to app interface
                    //1 second = 1000 milliseconds
                    tv3.setText("" + millisUntilFinished / 1000);
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                }
            }
            public void onFinish(){
                //Do something when count down finished
                tv3.setText("");
                tv4.setText("Sorry...Time Up!");
                startCount(5000);
                if(questions < 20){
                    getQuestion();
                }
                else{
                    Toast.makeText(getApplicationContext(), "You have completed the quiz", Toast.LENGTH_SHORT).show();
                    //timer.cancel();
                    Intent i = new Intent(getApplicationContext(), LastActivity.class);
                    i.putExtra("score", scr);
                    i.putExtra("Name", name);
                    //i.putExtra("CompletedTest",true);
                    startActivity(i);
                }

            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case 4:
                if (!helplines[0])
                    phoneOfFiend();
                else
                    Toast.makeText(this, " Lifeline can only be used once :) ", Toast.LENGTH_SHORT).show();
                helplines[0] = true;
                break;
            case 5:
                if (!helplines[1])
                    FiftyFifty();
                else
                    Toast.makeText(this, " Lifeline can only be used once :) ", Toast.LENGTH_SHORT).show();
                helplines[1] = true;
                break;
            case 6:
                if (!helplines[2])
                    DoubleDip();
                else
                    Toast.makeText(this, " Lifeline can only be used once :) ", Toast.LENGTH_SHORT).show();
                helplines[2] = true;
                break;

        }
    }


    public void refreshButtons(){
        option1.setBackgroundColor(getResources().getColor(R.color.black));
        option2.setBackgroundColor(getResources().getColor(R.color.black));
        option3.setBackgroundColor(getResources().getColor(R.color.black));
        option4.setBackgroundColor(getResources().getColor(R.color.black));
    }

    private void DoubleDip() {
        //Toast.makeText(this,"To be done.. ",Toast.LENGTH_SHORT).show();
        //rg.removeAllViews();
        getQuestion();
    }

    private void FiftyFifty() {
        int num1 = 0,num2 = 0;
        int ans = Integer.parseInt(c.getString(6));
        if(ans == 0){
            num1 = 1;
            num2 = 3;
        }
        else if(ans == 1){
            num1 = 0;
            num2 = 3;
        }
        else if(ans == 2){
            num1 = 0;
            num2 = 3;
        }
        else if(ans == 3){
            num1 = 1;
            num2 = 2;
        }

        switch (num1) {
            case 0: option1.setBackgroundColor(getResources().getColor(R.color.gray)); option1.setClickable(false); break;
            case 1: option2.setBackgroundColor(getResources().getColor(R.color.gray)); option2.setClickable(false);  break;
            case 2: option3.setBackgroundColor(getResources().getColor(R.color.gray));  option3.setClickable(false);break;
            case 3: option4.setBackgroundColor(getResources().getColor(R.color.gray)); option4.setClickable(false); break;
        }
        switch (num2) {
            case 0: option1.setBackgroundColor(getResources().getColor(R.color.gray)); option1.setClickable(false); break;
            case 1: option2.setBackgroundColor(getResources().getColor(R.color.gray)); option2.setClickable(false);  break;
            case 2: option3.setBackgroundColor(getResources().getColor(R.color.gray));  option3.setClickable(false);break;
            case 3: option4.setBackgroundColor(getResources().getColor(R.color.gray)); option4.setClickable(false); break;
        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        isPaused = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Specify the current state is not paused and canceled.
        isPaused = false;
        isCanceled = false;

        //Initialize a new CountDownTimer instance
        long millisInFuture = timeRemaining ;
        long countDownInterval = 1000;
        new CountDownTimer(millisInFuture, countDownInterval){
            public void onTick(long millisUntilFinished){
                //Do something in every tick
                if(isPaused || isCanceled)
                {
                    //If user requested to pause or cancel the count down timer
                    cancel();
                }
                else {

                    tv3.setText("" + millisUntilFinished / 1000);
                    //Put count down timer remaining time in a variable
                    timeRemaining = millisUntilFinished;
                }
            }
            public void onFinish(){
                //Do something when count down finished
                tv3.setText("");
                tv4.setText("Sorry...Time Up!");
                startCount(5000);
                getQuestion();

            }
        }.start();
    }

    private void phoneOfFiend() {
        //Toast.makeText(this,"To be done.. ",Toast.LENGTH_SHORT).show();
        String phone = "9654044705";
//        timer.cancel();
//        for (int i = 0; i< 10; i++){
//            LoopForOneSecond();
//        }
//        startCount(TIME);
        //OurOwnonPause();

        Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},   //request specific permission from user
                    10);
            startActivity(intent);
            return ;
        }
        startActivity(intent);

    }


    MyReceiver receiver;
    public void startDial(int milliseconds, String phoneNumber){

        receiver = new MyReceiver();

        //performs call
        if (!phoneNumber.equals("")) {

            Intent intent = new Intent(this, MyReceiver.class);

            PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
            AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + milliseconds, pi);

            Uri number = Uri.parse("tel:" + phoneNumber);
            Intent dial = new Intent(Intent.ACTION_CALL, number);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                startActivity(dial);
            }

            startActivity(intent);
        }
    }

    // to do: 1 min mei call implement krna.
    // to do: random questions aane chahiye. => done
    // to do: radio buttons to replace with something idk.
    // on phone of friend we have to stop the timer.

}
