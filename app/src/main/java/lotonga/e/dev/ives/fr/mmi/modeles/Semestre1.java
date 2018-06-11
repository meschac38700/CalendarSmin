package lotonga.e.dev.ives.fr.mmi.modeles;

import java.util.ArrayList;

public class Semestre1 extends Semestre {

    private Semestre1A s1a;
    private Semestre1B s1b;
    private Semestre1C s1c;
    public Semestre1( )
    {
        super();
        this.s1a = new Semestre1A( );
        this.s1b = new Semestre1B( );
        this.s1c = new Semestre1C( );
        this.emplois_du_temps.put("s1a", this.getS1a().getEmplois_Du_Temps());
        this.emplois_du_temps.put("s1b", this.getS1b().getEmplois_Du_Temps());
        this.emplois_du_temps.put("s1c", this.getS1c().getEmplois_Du_Temps());
    }

    public Semestre1A getS1a()
    {
        return this.s1a;
    }

    public Semestre1B getS1b()
    {
        return this.s1b;
    }

    public Semestre1C getS1c()
    {
        return this.s1c;
    }

    public void setS1a(Semestre1A s1a)
    {
        this.s1a = s1a;
    }

    public void setS1b(Semestre1B s1b)
    {
        this.s1b = s1b;
    }

    public void setS1c(Semestre1C s1c)
    {
        this.s1c = s1c;
    }

    @Override
    public void ajoutCours(Cours c)
    {

        if(c.getGroupe().contains("-"))
        {
            String[] arr = c.getGroupe().split("-");
            for(String ch : arr)
            {
                switch (ch.toLowerCase())
                {
                    case "s1":
                        this.amphi.add(c);
                        break;
                    case "s1a1":
                    case "s1a2":
                    case "s1a":
                        this.s1a.addCours(c);
                        break;
                    case "s1b1":
                    case "s1b2":
                    case "s1b":
                        this.s1b.addCours(c);
                        break;
                    case "s1c1":
                    case "s1c2":
                    case "s1c":
                        this.s1c.addCours(c);
                        break;
                }
            }
        }
        else
        {
            switch (c.getGroupe().toLowerCase())
            {
                case "s1":
                    this.amphi.add(c);
                    break;
                case "s1a1":
                case "s1a2":
                case "s1a":
                    this.s1a.addCours(c);
                    break;
                case "s1b1":
                case "s1b2":
                case "s1b":
                    this.s1b.addCours(c);
                    break;
                case "s1c1":
                case "s1c2":
                case "s1c":
                    this.s1c.addCours(c);
                    break;
            }
        }
    }

    @Override
    public void suppCours(Cours c)
    {
        switch (c.getGroupe().toLowerCase())
        {
            case "s1":
                for (Cours c1 : this.amphi)
                {
                    if(c.getUid().equals(c1.getUid()))
                    {
                        this.amphi.remove(c1);
                    }
                }
                break;
            case "s1a1":
            case "s1a2":
            case "s1a":
                this.s1a.deleteCours(c);
                break;

            case "s1b1":
            case "s1b2":
            case "s1b":
                this.s1b.deleteCours(c);
                break;
            case "s1c1":
            case "s1c2":
            case "s1c":
                this.s1c.deleteCours(c);
                break;
        }

    }


    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_1A ************************************************
     * ********************************************************************************************
     **********************************************************************************************/
    class Semestre1A extends SousSemestre{

        private ArrayList<Cours> s1a1;
        private ArrayList<Cours> s1a2;
        private ArrayList<Cours> s1a;

        public Semestre1A( )
        {
            super();
            this.s1a = new ArrayList<>();
            this.s1a1 = new ArrayList<>();
            this.s1a2 = new ArrayList<>();
            this.emplois_du_temps.put("s1a1", this.getS1a1());
            this.emplois_du_temps.put("s1a2", this.getS1a2());
            this.emplois_du_temps.put("s1a", this.getS1a());
        }

        public ArrayList<Cours> getS1a() {
            return s1a;
        }

        public void setS1a(ArrayList<Cours> s1a) {
            this.s1a = s1a;
        }

        public ArrayList<Cours> getS1a1()
        {
            return this.s1a1;
        }

        public ArrayList<Cours> getS1a2() {
            return s1a2;
        }

        public void setS1a1(ArrayList<Cours> s1a1) {
            this.s1a1 = s1a1;
        }

        public void setS1a2(ArrayList<Cours> s1a2)
        {
            this.s1a2 = s1a2;
        }

        @Override
        public void addCours(Cours c) {

            if(c.getGroupe().equalsIgnoreCase("s1a1") && !this.s1a1.contains(c))
            {
                this.s1a1.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s1a2") && !this.s1a2.contains(c))
            {
                this.s1a2.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s1a") && !this.s1a.contains(c))
            {
                this.s1a.add(c);
            }
        }

        @Override
        public void deleteCours(Cours c) {
            switch (c.getGroupe().toLowerCase())
            {
                case "s1a1":
                    for (Cours c1: this.s1a1) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1a1.remove(c1);
                            break;
                        }
                    }
                    break;
                case "s1a2":
                    for (Cours c1: this.s1a2) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1a2.remove(c1);
                            break;
                        }
                    }
                    break;
                case "s1a":
                    for (Cours c1: this.s1a) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1a.remove(c1);
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_1B ************************************************
     * ********************************************************************************************
     **********************************************************************************************/
    public class Semestre1B extends SousSemestre{

        private ArrayList<Cours> s1b1;
        private ArrayList<Cours> s1b2;
        private ArrayList<Cours> s1b;

        public Semestre1B( )
        {
            super();
            this.s1b = new ArrayList<>();
            this.s1b1 = new ArrayList<>();
            this.s1b2 = new ArrayList<>();
            this.emplois_du_temps.put("s1b", this.getS1b());
            this.emplois_du_temps.put("s1b1", this.getS1b1());
            this.emplois_du_temps.put("s1b2", this.getS1b2());
        }


        public ArrayList<Cours> getS1b() {
            return s1b;
        }

        public void setS1b(ArrayList<Cours> s1b) {
            this.s1b = s1b;
        }

        public ArrayList<Cours> getS1b1() {
            return s1b1;
        }

        public void setS1b1(ArrayList<Cours> s1b1) {
            this.s1b1 = s1b1;
        }

        public ArrayList<Cours> getS1b2() {
            return s1b2;
        }

        public void setS1b2(ArrayList<Cours> s1b2) {
            this.s1b2 = s1b2;
        }

        @Override
        public void addCours(Cours c) {
            if(c.getGroupe().equalsIgnoreCase("s1b1") && !this.s1b1.contains(c))
            {
                this.s1b1.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s1b2") && !this.s1b2.contains(c))
            {
                this.s1b2.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s1b") && !this.s1b.contains(c))
            {
                this.s1b.add(c);
            }
        }

        @Override
        public void deleteCours(Cours c) {
            switch (c.getGroupe().toLowerCase())
            {
                case "s1b1":
                    for (Cours c1: this.s1b1) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1b1.remove(c1);
                            break;
                        }
                    }
                    break;
                case "s1b2":
                    for (Cours c1: this.s1b2) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1b2.remove(c1);
                            break;
                        }
                    }
                    break;
                case "s1b":
                    for (Cours c1: this.s1b) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1b.remove(c1);
                            break;
                        }
                    }
                    break;
            }
        }
    }


    /***********************************************************************************************
     * *********************************************************************************************
     * ******************************** SEMESTRE_1C ************************************************
     * ********************************************************************************************
     **********************************************************************************************/
    public class Semestre1C extends SousSemestre
    {

        private ArrayList<Cours> s1c1;
        private ArrayList<Cours> s1c2;
        private ArrayList<Cours> s1c;

        public Semestre1C( )
        {
            super();
            this.s1c = new ArrayList<>();
            this.s1c1 = new ArrayList<>();
            this.s1c2 = new ArrayList<>();
            this.emplois_du_temps.put("s1c1", this.getS1c1());
            this.emplois_du_temps.put("s1c2", this.getS1c2());
            this.emplois_du_temps.put("s1c", this.getS1c());
        }

        public ArrayList<Cours> getS1c() {
            return s1c;
        }

        public void setS1c(ArrayList<Cours> s1c) {
            this.s1c = s1c;
        }

        public ArrayList<Cours> getS1c1() {
            return s1c1;
        }

        public void setS1c1(ArrayList<Cours> s1c1) {
            this.s1c1 = s1c1;
        }

        public ArrayList<Cours> getS1c2() {
            return s1c2;
        }

        public void setS1c2(ArrayList<Cours> s1c2) {
            this.s1c2 = s1c2;
        }


        @Override
        public void addCours(Cours c) {
            if(c.getGroupe().equalsIgnoreCase("s1c1") && !this.s1c1.contains(c))
            {
                this.s1c1.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s1c2") && !this.s1c2.contains(c))
            {
                this.s1c2.add(c);
            }
            else if(c.getGroupe().equalsIgnoreCase("s1c") && !this.s1c.contains(c))
            {
                this.s1c.add(c);
            }
        }

        @Override
        public void deleteCours(Cours c) {
            switch (c.getGroupe().toLowerCase())
            {
                case "s1c1":
                    for (Cours c1: this.s1c1) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1c1.remove(c1);
                            break;
                        }
                    }
                    break;
                case "s1c2":
                    for (Cours c1: this.s1c2) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1c2.remove(c1);
                            break;
                        }
                    }
                    break;
                case "s1c":
                    for (Cours c1: this.s1c) {
                        if(c.getUid().equalsIgnoreCase(c1.getUid()))
                        {
                            this.s1c.remove(c1);
                            break;
                        }
                    }
                    break;
            }
        }
    }

}