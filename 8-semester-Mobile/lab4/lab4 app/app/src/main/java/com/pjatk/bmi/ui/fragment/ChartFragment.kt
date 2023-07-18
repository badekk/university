package com.pjatk.bmi.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.pjatk.bmi.R

class ChartFragment : Fragment() {
    private lateinit var lineChart: LineChart
    private lateinit var lineData: LineData
    private lateinit var lineDataSet: LineDataSet
    private lateinit var lineEntries: ArrayList<Entry>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_chart, container, false)

        lineChart = view.findViewById(R.id.lineChart)
        lineChart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        lineChart.axisLeft.setDrawGridLines(false)
        lineChart.axisRight.setDrawGridLines(false)
        lineChart.description.text = "BMI / Months"

        getEntries()

        lineDataSet = LineDataSet(lineEntries, "changes in BMI over the year")
        lineDataSet.color = Color.RED
        lineDataSet.lineWidth = 1f
        lineDataSet.valueTextColor = Color.BLACK

        lineData = LineData(lineDataSet)
        lineChart.data = lineData
        lineChart.invalidate()
        lineDataSet.valueTextColor = Color.BLACK
        lineDataSet.valueTextSize = 18f

        return view
    }

    private fun getEntries() {
        lineEntries = arrayListOf(
                Entry(1f, 20.5f),
                Entry(2f, 19.9f),
                Entry(3f, 18.0f),
                Entry(4f, 18.5f),
                Entry(5f, 19.0f),
                Entry(6f, 19.2f),
                Entry(7f, 19.5f),
                Entry(8f, 19.5f),
                Entry(9f, 19.3f),
                Entry(10f, 19.0f),
                Entry(11f, 18.7f),
                Entry(12f, 18.2f)
        )
    }
}
