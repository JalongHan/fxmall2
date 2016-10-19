package haoqu.com.fxmall.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import haoqu.com.fxmall.R;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private Button mRActivityBtGetCode;
    private TextView mRActivityTvAgreement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();


    }

    private void initView() {
        mRActivityBtGetCode = (Button) findViewById(R.id.rActivity_bt_getCode);
        mRActivityTvAgreement = (TextView) findViewById(R.id.rActivity_tv_Agreement);

        mRActivityBtGetCode.setOnClickListener(this);
        mRActivityTvAgreement.setOnClickListener(null);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rActivity_bt_getCode:

                break;
        }
    }
}
