package rohanaceres.github.io.mycv;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by rohanaceres on 19/12/17.
 */

public class MainActivity3 extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context mContext = getApplicationContext();

        setContentView(R.layout.activity_main3);

        ArrayList<PersonalData> users = CrudBoladao.getAll(mContext);

        LinearLayout mainLayout = findViewById(R.id.mainLayout);

        for (PersonalData user: users) {
            CardView newCv = new CardView(mContext);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(15,15,15,15);

            newCv.setLayoutParams(params);
            newCv.setRadius(9);
            newCv.setContentPadding(15, 15, 15, 15);
            newCv.setMaxCardElevation(15);
            newCv.setCardElevation(9);

            // Initialize a new TextView to put in CardView
            TextView tv = new TextView(mContext);
            tv.setLayoutParams(params);
            tv.setText(user.getName() + "\n" + user.getEmail() + "\n" + user.getDistrict() + "\n" + user.getCity() + "\n" + user.getCity());
            tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
            tv.setTextColor(Color.GREEN);

            newCv.addView(tv);
            mainLayout.addView(newCv);
        }
    }
}
