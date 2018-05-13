package com.app.web.ags.colombiaelige;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.app.web.ags.colombiaelige.POJOS.VotesResults;
import com.app.web.ags.colombiaelige.models.VoteModel;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ShowStatistics extends AppCompatActivity {

    private VoteModel voteModel;
    private List<VotesResults> votesResults = new ArrayList<>();

    private LinearLayout linearLayout;
    private PieChart pieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_statistics);

        linearLayout = findViewById(R.id.results);
        pieChart = (PieChart) findViewById(R.id.pie);

        // Consigue resultados
        voteModel = new VoteModel(getApplicationContext());
        votesResults = voteModel.counts();

        drawResults();
    }

    /**
     * Dibuja los resultados en la activity
     */
    private void drawResults() {
        List<PieEntry> pieEntries = new ArrayList<>();
        for(VotesResults votes : votesResults) {
            pieEntries.add(new PieEntry(
                    Float.parseFloat(votes.getVotes() + ""),votes.getName()));
        }
        PieDataSet set = new PieDataSet(pieEntries, "Elecciones");
        PieData data = new PieData(set);

        int colors[] = new int[votesResults.size()];
        Random random = new Random();
        for(int i = 0; i < colors.length; i++) {
            colors[i] = Color.rgb(random.nextInt(255),random.nextInt(255),random.nextInt(255));
        }

        set.setColors(ColorTemplate.VORDIPLOM_COLORS);
        pieChart.setData(data);
        pieChart.invalidate();
    }

}
