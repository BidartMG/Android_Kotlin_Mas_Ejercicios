package com.ort.petapp.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.ort.petapp.R


class LoginFragment : Fragment() {
    lateinit var vista: View
    lateinit var editUser: EditText
    lateinit var editPass: EditText
    lateinit var btnLog: Button

    // Crear un usuario con los datos recibidos
    // lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vista = inflater.inflate(R.layout.fragment_login, container, false)
        editUser = vista.findViewById(R.id.edt_user_name)
        editPass = vista.findViewById(R.id.edt_pass_new)
        btnLog = vista.findViewById(R.id.btn_send)
        return vista
    }

    override fun onStart() {
        super.onStart()
        // lista de usuarios y contraseñas
        var editUser2: String = "Admin"
        var editPass2: String = "1234"

        btnLog.setOnClickListener() {
            var usuario: String = editUser.text.toString()
            var contrasenia: String = editPass.text.toString()

            if(usuario == editUser2) {
                if(contrasenia == editPass2) {
                    val goToMainPage = LoginFragmentDirections.actionLoginFragmentToMainFragment()
                    vista.findNavController().navigate(goToMainPage)
                }
                else {
                    // Indicar que la contrasenia es errónea
                }
            }
            else {
                // contrasenia incorrecta, borrar lo escrito y avisar
            }
        }

    }
}