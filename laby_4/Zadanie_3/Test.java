interface FiguryJP
{
    double obliczPole(double par);
    double obliczObwod(double par);
    String podajNazwe();
}

interface FiguryDP
{
    double obliczPole(double par1, double par2);
    double obliczObwod(double par1, double par2);
    String podajNazwe();
}

class Figura
{   
    public enum JP implements FiguryJP
    {
        Kolo
        {
            public double obliczPole(double promien)
            {
                return Math.PI*promien*promien;
            }
            public double obliczObwod(double promien)
            {
                return 2*Math.PI*promien;
            }
            public String podajNazwe()
            {
                return "Kolo";
            }
        },

        Kwadrat
        {
            public double obliczPole(double bok)
            {
                return bok*bok;
            }
            public double obliczObwod(double bok)
            {
                return 4*bok;
            }
            public String podajNazwe()
            {
                return "Kwadrat";
            }
        },
        
        Pieciokat
        {
            public double obliczPole(double bok)
            {
                return 1.618033*bok*bok;
            }
            public double obliczObwod(double bok)
            {
                return 5*bok;
            }
            public String podajNazwe()
            {
                return "Pieciokat";
            }
        },

        Szesciokat
        {
            public double obliczPole(double bok)
            {
                return (3*bok*bok*Math.sqrt(3))/2;
            }
            public double obliczObwod(double bok)
            {
                return 6*bok;
            }
            public String podajNazwe()
            {
                return "Szesciokat";
            }
        };
        
        public String Oblicz(double parametr)
        {
            double pole = obliczPole(parametr);
            double obwod = obliczObwod(parametr);
            String nazwa = podajNazwe();
            return(nazwa+": "+Double.toString(obwod)+" : "+Double.toString(pole)+"[]^2");
        }
    }

    public enum DP implements FiguryDP
    {
        Prostokat
        {
            public double obliczPole(double bok1, double bok2)
            {
                return bok1*bok2;
            }
            public double obliczObwod(double bok1, double bok2)
            {
                return 2*bok1 + 2*bok2;
            }
            public String podajNazwe()
            {
                return "Prostokat";
            }
        },

        Romb
        {
            public double obliczPole(double bok, double kat)
            {
                return 2*bok*Math.sin(kat);
            }
            public double obliczObwod(double bok, double kat)
            {
                return 4*bok;
            }
            public String podajNazwe()
            {
                return "Romb";
            }
        };

        public String Oblicz(double par1, double par2)
        {
            double pole = obliczPole(par1, par2);
            double obwod = obliczObwod(par1, par2);
            String nazwa = podajNazwe();
            return(nazwa+": "+Double.toString(obwod)+" : "+Double.toString(pole)+"[]^2");
        }
    }
}

public class Test {
    public static void main(String args[])
    {
        System.out.println(Figura.JP.Kolo.Oblicz(Double.parseDouble(args[1])));

        switch(args[0])
            {
                case "o":
                    System.out.println(Figura.JP.Kolo.Oblicz(Double.parseDouble(args[1])));
                    break;
                case "p":
                    System.out.println(Figura.JP.Pieciokat.Oblicz(Double.parseDouble(args[1])));
                    break;
                case "s":
                    System.out.println(Figura.JP.Szesciokat.Oblicz(Double.parseDouble(args[1])));   
                    break;
                case "c":
                    if (!args[5].equals("90"))
                    {
                        System.out.println(Figura.DP.Romb.Oblicz(Double.parseDouble(args[1]), Double.parseDouble(args[5])));
                    }
                    else if (args[1].equals(args[2]) && args[2].equals(args[3]) && args[3].equals(args[4]))
                    { 
                        System.out.println(Figura.JP.Kwadrat.Oblicz(Double.parseDouble(args[1])));
                    }
                    else System.out.println(Figura.DP.Prostokat.Oblicz(Double.parseDouble(args[1]), Double.parseDouble(args[2])));

                    break;
            }
    }
}
