package lotonga.e.dev.ives.fr.mmi.modeles;

import android.util.Log;

import net.fortuna.ical4j.model.ComponentList;
import net.fortuna.ical4j.model.component.VEvent;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Cette classe servira à gerer l'entrée dans le programme
 */

public class Main {

    public SemestreLangue s1lv2, s2lv2, s3lv2 ;
    public Semestre s1, s2, s3, s4;
    public LPSMIN lpsmin;
    private static final String TAG = "DEBUG_CUSTOM";

    public Main(ComponentList cl)
    {
        this.init();

        for(int i=0; i < cl.size(); i++)
        {
            try
            {
                Cours c = new Cours((VEvent) cl.get(i));
                //Log.d(TAG, "Main:  GROUPE COURS =========> "+c.getGroupe());
                this.s1.ajoutCours(c);
                this.s2.ajoutCours(c);
                this.s3.ajoutCours(c);
                this.s4.ajoutCours(c);
                this.s1lv2.addCours(c);
                this.s2lv2.addCours(c);
                this.s3lv2.addCours(c);
                this.lpsmin.addCours(c);
            }
            catch (Exception e)
            {
                Log.e("MAIN CONSTRUTEUR", e.getMessage() );
            }
        }
    }


    private void init()
    {
        this.lpsmin = new LPSMIN( );

        this.s1  = new Semestre1( );
        this.s2  = new Semestre2( );
        this.s3  = new Semestre3( );
        this.s4  = new Semestre4( );

        this.s1lv2 = new Semestre1LV2( );
        this.s2lv2 = new Semestre2LV2( );
        this.s3lv2 = new Semestre3LV2( );

    }

  /*  public Main(VEvent event)
    {
        try
        {
            Cours c = new Cours(event);
            this.s = new Semaine();
            s.ajoutCours(c);
            this.lpsmin = new LPSMIN(this.s);
            this.s1  = new Semestre1( this.s );
            this.s2  = new Semestre2( this.s );
            this.s3  = new Semestre3( this.s );
            this.s4  = new Semestre4( this.s );

            this.s1lv2 = new Semestre1LV2(this.s);
            this.s2lv2 = new Semestre2LV2(this.s);
            this.s3lv2 = new Semestre3LV2(this.s);
        }
        catch (Exception e)
        {
            Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
        }
    }
    public Main(ArrayList<VEvent> events)
    {
        this.s = new Semaine();
        for (VEvent ev : events)
        {
            try
            {
                Cours c = new Cours(ev);
                this.s.ajoutCours(c);
            }
            catch (Exception e)
            {
                Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
            }
        }

        this.init();
    }

    public Main(VEvent[] events)
    {
        this.s = new Semaine();
        for (VEvent ev : events)
        {
            try
            {
                Cours c = new Cours(ev);
                this.s.ajoutCours(c);
            }
            catch (Exception e)
            {
                Log.e("Main.class init(event)", "Initialisation Semaine Impossible" );
            }
        }
        this.init();
    }
*/


}
