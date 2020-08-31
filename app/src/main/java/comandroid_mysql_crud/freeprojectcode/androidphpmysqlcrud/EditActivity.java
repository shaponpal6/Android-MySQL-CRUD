package comandroid_mysql_crud.freeprojectcode.androidphpmysqlcrud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.HashMap;

public class EditActivity extends AppCompatActivity {
    private EditText mName, mDesignation, mSalary;
    String id = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        // Initialize EditText View
        mName = (EditText) findViewById(R.id.name);
        mDesignation = (EditText) findViewById(R.id.designation);
        mSalary = (EditText) findViewById(R.id.salary);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if (b != null){
//            id = (String) b.get("id");
//            String name = (String) b.get("name");
//            String designation = (String) b.get("designation");
//            String salary = (String) b.get("salary");
            String list = (String) b.get("LIST");


            mName.setText(list);
//            mName.setText(name);
//            mDesignation.setText(designation);
//            mSalary.setText(salary);
        }


    }

    public void updateEmployee(View view) {
        String name = mName.getText().toString();
        String designation = mDesignation.getText().toString();
        String salary = mSalary.getText().toString();

        HashMap<String, String> requestedParams = new HashMap<>();
        requestedParams.put("id", id);
        requestedParams.put("name", name);
        requestedParams.put("designation", designation);
        requestedParams.put("salary", salary);

        Log.d("HashMap", requestedParams.get("salary"));
        Toast.makeText(getApplicationContext(), "Clicked : " + requestedParams.get("id"), Toast.LENGTH_LONG).show();


        PostRequestHandler postRequestHandler = new PostRequestHandler(Constant.CREATE_URL, requestedParams);
        postRequestHandler.execute();
    }

    public void deleteEmployee(View view) {
    }
}
