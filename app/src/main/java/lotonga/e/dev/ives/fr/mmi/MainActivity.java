package lotonga.e.dev.ives.fr.mmi;

import android.app.Activity;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;

import lotonga.e.dev.ives.fr.mmi.modeles.Cours;
import lotonga.e.dev.ives.fr.mmi.modeles.Main;

public class MainActivity extends GeneralActivity
{

    Main main;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main = new Main(getData());
        ArrayList<Cours> lpsmin = main.lpsmin.getEmplois_du_temps();
    }
}
