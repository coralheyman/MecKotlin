package unicauca.meckotlin.ui.login

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import unicauca.meckotlin.BR
import unicauca.meckotlin.R
import unicauca.meckotlin.data.DB
import unicauca.meckotlin.data.dao.DatabaseDao
import unicauca.meckotlin.data.model.User
import unicauca.meckotlin.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    lateinit var viewModel: LoginViewModel
    val TAG: String = LoginActivity::class.java.name
    var userLogin: User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        viewModel.getAllUsers()

        btnLogin.setOnClickListener {
            var username_s: String = username.text.toString().trim()
            var password_s: String = password.text.toString().trim()
            if (username_s.equals("") || password_s.equals("")) {
                snackbar(loginView, "Debe ingresar los campos")
            } else {
                doAsync {
                    userLogin = viewModel.getUserByUsername(username_s)
                    uiThread {
                        if (userLogin == null) {
                            snackbar(loginView, "No existe el usuario")
                        } else {
                            if (password_s.equals(userLogin!!.password)) {
                                startActivity<MainActivity>()
                            } else {
                                snackbar(loginView, "Credenciales incorrectas")
                            }
                        }
                    }
                }
            }

        }

    }

    override fun onRestart() {
        username.setText("")
        password.setText("")
        super.onRestart()
    }
}
