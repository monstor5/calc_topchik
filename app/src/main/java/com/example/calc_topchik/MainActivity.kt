package com.example.calc_topchik

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_zero.setOnClickListener { calculator("0", true) }
        btn_one.setOnClickListener { calculator("1", true) }
        btn_two.setOnClickListener { calculator("2", true) }
        btn_three.setOnClickListener { calculator("3", true) }
        btn_four.setOnClickListener { calculator("4", true) }
        btn_five.setOnClickListener { calculator("5", true) }
        btn_six.setOnClickListener { calculator("6", true) }
        btn_seven.setOnClickListener { calculator("7", true) }
        btn_eight.setOnClickListener { calculator("8", true) }
        btn_nine.setOnClickListener { calculator("9", true) }
        btn_comma.setOnClickListener { calculator(".", true) }
        btn_Open.setOnClickListener { calculator("(", true) }
        btn_Close.setOnClickListener { calculator(")", true) }


        btn_plus.setOnClickListener { calculator("+", false) }
        btn_minus.setOnClickListener { calculator("-", false) }
        btn_multiplication.setOnClickListener { calculator("*", false) }
        btn_division.setOnClickListener { calculator("/", false) }
        btn_equally.setOnClickListener { calculator("=", false) }





        btn_back.setOnClickListener { calculator("back", false) }
        val stroka = btn_Expression.text.toString()

        if (stroka.isNotEmpty())


            btn_Expression.text = stroka.substring(0, stroka.length - 1)


        btn_Result.text = ""



        btn_AC.setOnClickListener {
            btn_Result.text = ""
            btn_Expression.text = ""


        }



        btn_equally.setOnClickListener{

            try {
                val expression = ExpressionBuilder(btn_Expression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                btn_Result.text = longResult.toString()
                else
                btn_Result.text = result.toString()
            }
            catch(e:Exception)
            {

                Log.d("123","sdas"+e.message)
            }


        }



    }








    fun calculator (stroka: String, Mozhno_Ochistit: Boolean)
    {

        if(btn_Result.text.isNotEmpty())
        {
            btn_Expression.text = ""
        }
        if(Mozhno_Ochistit)
        {
            btn_Result.text = ""
            btn_Expression.append(stroka) }
        else
        {
            btn_Expression.append(btn_Result.text)
            btn_Expression.append(stroka)
            btn_Result.text = ""
        }

    }

}