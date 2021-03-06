package br.com.caelum.casadocodigo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.iid.FirebaseInstanceId;

import br.com.caelum.casadocodigo.R;
import br.com.caelum.casadocodigo.api.WebClient;
import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.login_email)
    EditText campoEmail;
    @BindView(R.id.login_senha)
    EditText campoSenha;
    @BindView(R.id.login_logar)
    Button btn_logar;
    @BindView(R.id.login_novo)
    Button btn_novo;
    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener listener;
    private boolean flagUsuarioLogado = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        campoEmail = (EditText) findViewById(R.id.login_email);
        campoSenha = (EditText) findViewById(R.id.login_senha);
        btn_logar = (Button) findViewById(R.id.login_logar);
        btn_novo  = (Button) findViewById(R.id.login_novo);
        firebaseAuth = FirebaseAuth.getInstance();
//        FirebaseAuth.getInstance().signOut();

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();
                if(!email.isEmpty() && !senha.isEmpty()){
                    firebaseAuth.signInWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Snackbar.make(campoEmail, "Acesso nao autorizado, verifique suas informacoes",Snackbar.LENGTH_SHORT).show();
                                    }else{
                                        FirebaseInstanceId instance = FirebaseInstanceId.getInstance();
                                        String token = instance.getToken();
                                        new WebClient().sendEmail(email,token);
                                    }
                                }
                            });
                }else{
                    Snackbar.make(campoEmail, "Por Favor complete todos os campos",Snackbar.LENGTH_SHORT).show();
                }
            }
        });

        btn_novo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = campoEmail.getText().toString();
                String senha = campoSenha.getText().toString();
                if(!email.isEmpty() && !senha.isEmpty()) {
                    firebaseAuth.createUserWithEmailAndPassword(email, senha)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (!task.isSuccessful()) {
                                        Snackbar.make(campoEmail, "Cadastro nao efetuado, verifique suas informacoes", Snackbar.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }else{
                    Snackbar.make(campoEmail, "Cadastro nao autorizado, verifique suas informacoes",Snackbar.LENGTH_SHORT).show();
                }
            }
        });


        listener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null && !flagUsuarioLogado) {
                    flagUsuarioLogado = true;
                    Intent vaiParaMim = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(vaiParaMim);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "TESTE", Toast.LENGTH_SHORT).show();
                    // User is signed out
                    Log.d("Deslogado", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        firebaseAuth.addAuthStateListener(listener);


    }

}
