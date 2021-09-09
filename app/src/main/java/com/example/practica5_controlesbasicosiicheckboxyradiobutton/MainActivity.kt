package com.example.practica5_controlesbasicosiicheckboxyradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import android.text.TextWatcher




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.conversor)
//        val chkSelecciona: CheckBox = findViewById(R.id.chkSelecciona)
//        chkSelecciona.setOnClickListener{
//            if(it is CheckBox)
//                if(it.isChecked)
//                    chkSelecciona.text="¡Checkbox seleccionado!"
//                else
//                    chkSelecciona.text="¡Checkbox no seleccionado!"
//        }
//
//        val rbGrupo: RadioGroup = findViewById(R.id.rbGrupo)
//        val rbOpc1: RadioButton = findViewById(R.id.rbOpc1)
//        val rbOpc2: RadioButton = findViewById(R.id.rbOpc2)
//
//        //Limpiamos y asignamos la primera opción al RadioGroup
//        rbGrupo.clearCheck()
//        rbGrupo.check(rbOpc1.id)
//
//        val handler = View.OnClickListener { view ->
//            if (view is RadioButton){
//                var opcion = ""
//                when (view.getId()){
//                    rbOpc1.id -> opcion = "opción 1"
//                    rbOpc2.id -> opcion = "opción 2"
//                }
//                Toast.makeText(
//                    applicationContext,
//                    "Opción seleccionada: $opcion",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//        rbOpc1.setOnClickListener(handler)
//        rbOpc2.setOnClickListener(handler)

        val etEntrada: EditText = findViewById(R.id.etEntrada)
        val tvSalida: TextView = findViewById(R.id.tvSalida)
        val rbGrupo: RadioGroup = findViewById(R.id.rbGrupo)
        val rbKg: RadioButton = findViewById(R.id.rbKg)
        val rbG: RadioButton = findViewById(R.id.rbG)
        val rbMg: RadioButton = findViewById(R.id.rbMg)
        val rbGrupo2: RadioGroup = findViewById(R.id.rbGrupo2)
        val rbKg2: RadioButton = findViewById(R.id.rbKg2)
        val rbG2: RadioButton = findViewById(R.id.rbG2)
        val rbMg2: RadioButton = findViewById(R.id.rbMg2)

        //Limpiamos y asignamos la primera opción al RadioGroup
        rbGrupo.clearCheck()
        rbGrupo2.clearCheck()
        rbGrupo.check(R.id.rbKg)
        rbGrupo2.check(R.id.rbKg2)

        rbKg.setOnClickListener({convertir(etEntrada.text.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)})
        rbG.setOnClickListener({convertir(etEntrada.text.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)})
        rbMg.setOnClickListener({convertir(etEntrada.text.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)})
        rbKg2.setOnClickListener({convertir(etEntrada.text.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)})
        rbG2.setOnClickListener({convertir(etEntrada.text.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)})
        rbMg2.setOnClickListener({convertir(etEntrada.text.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)})

        etEntrada.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                convertir(s.toString(),etEntrada,tvSalida,rbGrupo,rbKg,rbG,rbMg,rbGrupo2,rbKg2,rbG2,rbMg2)
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }

    fun convertir(s:String,etEntrada:EditText,tvSalida:TextView,rbGrupo:RadioGroup,rbKg:RadioButton,rbG:RadioButton,rbMg:RadioButton,rbGrupo2:RadioGroup,rbKg2:RadioButton,rbG2:RadioButton,rbMg2:RadioButton){
        var unidad1: String=""
        var unidad2: String=""
        var result: Double=0.0
        if(s.toString()!=""){
            when(rbGrupo.getCheckedRadioButtonId()){
                rbKg.id -> unidad1="kg"
                rbG.id -> unidad1="g"
                rbMg.id -> unidad1="mg"
            }
            when(rbGrupo2.getCheckedRadioButtonId()){
                rbKg2.id -> unidad2="kg"
                rbG2.id -> unidad2="g"
                rbMg2.id -> unidad2="mg"
            }
            if(unidad1==unidad2){
                tvSalida.text="$s"
            }
            if((unidad1=="kg" && unidad2=="g") || (unidad1=="g" && unidad2=="mg")){
                result=s.toString().toDouble() * 1000
                tvSalida.text="$result"
            }
            if(unidad1=="kg" && unidad2=="mg"){
                result=s.toString().toDouble() * 1000000
                tvSalida.text="$result"
            }
            if((unidad1=="g" && unidad2=="kg") || (unidad1=="mg" && unidad2=="g")){
                result=s.toString().toDouble() / 1000
                tvSalida.text="$result"
            }
            if(unidad1=="mg" && unidad2=="kg"){
                result=s.toString().toDouble() / 1000000
                tvSalida.text="$result"
            }
        }else{
            tvSalida.text=""
        }

    }
}