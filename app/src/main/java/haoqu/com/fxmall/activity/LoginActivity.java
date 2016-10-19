package haoqu.com.fxmall.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.android.volley.VolleyError;

import java.util.HashMap;
import java.util.Map;

import haoqu.com.fxmall.Consts;
import haoqu.com.fxmall.JSONModel.LoginBean;
import haoqu.com.fxmall.R;
import haoqu.com.fxmall.TApplication;
import haoqu.com.fxmall.Tools.VolleyListenerInterface;
import haoqu.com.fxmall.Tools.VolleyRequestTool;
import haoqu.com.fxmall.views.MyToast;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText mLActivityAccountInput;
    private EditText mLActivityAccountPassWord;
    private TextView mLActivityBtForgetPassword;
    private TextView mLActivityBtRegister;
    private Button mLActivityLoginBtn;
    private String account;
    private String passWord;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sp = getSharedPreferences("login",Context.MODE_PRIVATE);
        if (sp.contains("phonekey")){

            startActivity(new Intent(LoginActivity.this,MainActivity.class));

            finish();
            
        }else {
            Log.i(TAG, "onCreate: else");
            initView();
            setListners();
        }


    }

    /**
     * 设置监听
     */
    private void setListners() {
        mLActivityBtForgetPassword.setOnClickListener(this);
        mLActivityBtRegister.setOnClickListener(this);
        mLActivityLoginBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击了忘记密码按钮
            case R.id.lActivity_bt_forgetPassword:
                startActivity(new Intent(LoginActivity.this,FrogotPasswordActivity.class));
                break;
            //点击了注册按钮
            case R.id.lActivity_bt_register:
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));

                break;
            //点击了登陆按钮
            case R.id.lActivity_loginBtn:
                /* 登陆 */
                account = mLActivityAccountInput.getText().toString().trim();
                passWord = mLActivityAccountPassWord.getText().toString().trim();
                //判断账号密码是否通过
                if (isPass()) return;

                //执行登陆业务
                Login();

                break;

            default:
                break;
        }
    }

    /**
     * 判断账号密码是否通过
     * @return
     */
    private boolean isPass() {
        if (!account.matches("^[\\d]{11}")) {
            MyToast.Toast(getApplicationContext(), "手机号码不正确");
            return true;
        }
        if (TextUtils.isEmpty(account)) {
            MyToast.Toast(LoginActivity.this, "手机号码为空");
            return true;
        }
        if (!passWord.matches("^[a-zA-Z\\d]{6,16}$")) {
            MyToast.Toast(LoginActivity.this, "密码请填写6-16位字母和数字");
            return true;
        }

        StringBuilder builder = new StringBuilder();
        if (TextUtils.isEmpty(account)) {
            builder.append("用户名为空\n");
        }
        if (TextUtils.isEmpty(passWord)) {
            builder.append("密码为空\n");
        }
        if (!TextUtils.isEmpty(builder.toString())) {
            Toast.makeText(LoginActivity.this, builder.toString(),
                    Toast.LENGTH_LONG).show();
            return true;
        }
        return false;
    }

    /**
     * 登陆业务
     */
    private void Login() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("mobile", account);
        params.put("password", passWord);
        params.put("uuid", TApplication.UUID);
        VolleyRequestTool.RequestPost(
                getApplicationContext(),
                Consts.baseUrl + Consts.appLogin + Consts.weid,
                Consts.appLogin,
                params,
                new VolleyListenerInterface(this, VolleyListenerInterface.mListener, VolleyListenerInterface.mErrorListener) {

                    @Override
                    public void onMySuccess(String result) {
                        Log.i("result", result);
                        try {
                            LoginBean loginBean = JSON.parseObject(result,
                                    LoginBean.class);

                            switch (Integer.valueOf(loginBean.getError())) {
                                // 通过
                                case 0:
                                    TApplication.token = loginBean.getToken();
                                    TApplication.uid = loginBean.getUid();
                                    TApplication.avatar = loginBean.getAvatar();
                                    TApplication.nickname = loginBean.getNickname();
                                    TApplication.mobile = loginBean.getMobile();
                                    // 用偏好设置来存储用户名和密码 和其它 信息
                                    SharedPreToSave(loginBean);

                                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                    LoginActivity.this.finish();
                                    break;
                                case -2:
                                    MyToast.Toast(LoginActivity.this, "账号或密码错误");
                                    break;

                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                        }

                    }

                    @Override
                    public void onMyError(VolleyError error) {
                        //volley出现错误的时候执行onMyError的方法

                    }
                });
    }

    /**
     * 初始化控件
     */
    private void initView() {
        mLActivityAccountInput = (EditText) findViewById(R.id.lActivity_account_input);
        mLActivityAccountPassWord = (EditText) findViewById(R.id.lActivity_account_passWord);
        mLActivityBtForgetPassword = (TextView) findViewById(R.id.lActivity_bt_forgetPassword);
        mLActivityBtRegister = (TextView) findViewById(R.id.lActivity_bt_register);
        mLActivityLoginBtn = (Button) findViewById(R.id.lActivity_loginBtn);

    }

    
    /**
     * 用偏好设置来存储用户名和密码记录登陆信息
     */
    private void SharedPreToSave(LoginBean loginEntity) {
        if (sp == null){
            sp = getSharedPreferences("login",Context.MODE_PRIVATE);
        }
        SharedPreferences.Editor et = sp.edit();
        et.putString("phonekey", account);
        et.putString("pasowrd", passWord);
        et.putString("token", loginEntity.getToken());
        et.putString("uid", loginEntity.getUid());
        et.putString("mobile", loginEntity.getMobile());
        et.putString("nickname", loginEntity.getNickname());
        et.putString("avatar", loginEntity.getAvatar());
        //清除一下imageloader中缓存的图片.因为网址是一样的,让其它地方的正常显示
        et.apply();
    }


}
