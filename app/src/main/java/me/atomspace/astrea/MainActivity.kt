package me.atomspace.astrea

import android.graphics.Color
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

        val data: ArrayList<SliceValue> = ArrayList()
        data.add(SliceValue(50F, Color.CYAN).setLabel("Учебные заведения"))
        data.add(SliceValue(50F, Color.BLUE).setLabel("Малый бизнес"))
        data.add(SliceValue(45F, Color.YELLOW).setLabel("Больницы"))
        data.add(SliceValue(5F, Color.GREEN).setLabel("Другое"))

        val pieChartData = PieChartData(data)
        pieChartData.setHasLabels(true).valueLabelTextSize = 14
        pieChartData.setHasCenterCircle(true).centerText1 = "400 млн"
        pieChartData.centerText1FontSize = 36
        pieChartView.pieChartData = pieChartData
    }
}