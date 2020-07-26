package me.atomspace.astrea

import android.graphics.Color
import android.icu.text.DecimalFormat
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import lecho.lib.hellocharts.model.PieChartData
import lecho.lib.hellocharts.model.SliceValue
import lecho.lib.hellocharts.view.PieChartView


class MainActivity : AppCompatActivity() {
    private lateinit var pieChartView: PieChartView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pieChartView = findViewById(R.id.budget_chart)
        val df = DecimalFormat("#.#")
        val Schools = 500F
        val Bisnes = 155F
        val Hospitals = 520F
        val Other = 52F

        fun Summ() : Float {
            return Schools + Bisnes + Hospitals + Other
        }
        fun Procent(a: Float) : Float{
            return (a * 100) / Summ()
        }
        fun Check(Sum: Float): String{
            when{
                Sum >= 1000 && Sum <= 1000000 -> return "${df.format(Sum/1000)} Тыс"
                Sum >= 1000000 && Sum <= 1000000000 -> return "${df.format(Sum/1000000)} Млн"
                Sum >= 1000000000 -> return "${df.format(Sum/1000000000)} Млрд"
                else -> return "${df.format(Sum)}"
            }

        }


        val data: ArrayList<SliceValue> = ArrayList()
        data.add(SliceValue(Procent(Schools), Color.CYAN).setLabel("Учебные заведения"))
        data.add(SliceValue(Procent(Bisnes), Color.BLUE).setLabel("Малый бизнес"))
        data.add(SliceValue(Procent(Hospitals), Color.YELLOW).setLabel("Больницы"))
        data.add(SliceValue(Procent(Other), Color.GREEN).setLabel("Другое"))

        val pieChartData = PieChartData(data)
        pieChartData.setHasLabels(true).valueLabelTextSize = 14
        pieChartData.setHasCenterCircle(true).centerText1 = "${Check(Summ())}"
        pieChartData.centerText1FontSize = 36
        pieChartView.pieChartData = pieChartData
    }
}