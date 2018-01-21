package unicauca.meckotlin.ui.login

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.design.snackbar
import unicauca.meckotlin.BR
import unicauca.meckotlin.R
import unicauca.meckotlin.data.model.User

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        btnLogin.setOnClickListener {
            if (username.text.trim().equals("") || password.text.trim().equals(""))
                snackbar(loginView, "Debe ingresar los campos")
            else {
                viewModel.getUserByUsername(username.text.toString())
            }

        }

    }
}
