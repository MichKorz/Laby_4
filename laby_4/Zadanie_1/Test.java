interface Figury
{
    double obliczPole();
    double obliczObwod();
}

abstract class Figura implements Figury
{
    double pole;
    double obwod;
    String nazwa;
    public void wypiszDane()
    {
        System.out.println(String.valueOf(nazwa)+" : "+String.valueOf(obwod)+" : "+String.valueOf(pole)+"[]^2");
    }
}

abstract class Czworokat extends Figura
{
    double boki[];
    double kat;
    public double obliczObwod()
    {
        double obw = 0;
        for(int i = 0; i < 4; i++)
        {
            obw+=boki[i];
        }
        return obw;
    }
}

class Kwadrat extends Czworokat
{
    public Kwadrat(double bok)
    {
        boki = new double[4];
        for(int i = 0; i < 4; i++)
        {
            boki[i] = bok;
        }

        nazwa = "Kwadrat";
        obwod = obliczObwod();
        pole = obliczPole();
    }

    public double obliczPole()
    {
        return boki[0]*boki[0];
    }
}

class Prostokat extends Czworokat
{
    public Prostokat(String dane[])
    {
        boki = new double[4];
        for(int i = 1; i <= 4; i++)
        {
            boki[i-1] = Double.parseDouble(dane[i]);
        }

        if (!(boki[0] == boki[1] && boki[2] == boki[3])
        && !(boki[0] == boki[2] && boki[1] == boki[3])
        && !(boki[0] == boki[3] && boki[1] == boki[2])) throw new ArithmeticException();

        nazwa = "Prostokat";
        pole = obliczPole();
        obwod = obliczObwod();
    }

    public double obliczPole()
    {
        return boki[0] == boki[1]? boki[0]*boki[2] : boki[0]*boki[1];
    }
}

class Romb extends Czworokat
{
    double kat;

    public Romb(String dane[])
    {
        boki = new double[4];
        for(int i = 1; i <= 4; i++)
        {
            boki[i-1] = Double.parseDouble(dane[1]);
        }
        kat = Double.parseDouble(dane[5]);

        nazwa = "Romb";
        pole = obliczPole();
        obwod = obliczObwod();
    }

    public double obliczPole()
    {
        return 2*boki[0]*Math.sin(kat);
    }
}

class Kolo extends Figura
{
    final double pi = 3.141592f;
    double promien;

    public Kolo(double R)
    {
        promien = R;
        nazwa = "Kolo";
        pole = obliczPole();
        obwod = obliczObwod();
    }

    public double obliczPole()
    {
        return pi * promien * promien;
    }
    public double obliczObwod()
    {
        return 2 * pi * promien;
    }
}

class Pieciokat extends Figura
{
    final double cons = 1.618033;
    double bok;

    public Pieciokat(double a)
    {
        bok = a;
        nazwa = "Pieciokat";
        pole = obliczPole();
        obwod = obliczObwod();
    }

    public double obliczPole()
    {
        return cons*bok*bok;
    }
    public double obliczObwod()
    {
        return bok*5;
    }
}

class Szesciokat extends Figura
{
    double bok;
    public Szesciokat(double a)
    {
        bok = a;
        nazwa = "Szesciokat";
        pole = obliczPole();
        obwod = obliczObwod();
    }

    public double obliczPole()
    {
        return (3*bok*bok*Math.sqrt(3))/2;
    }
    public double obliczObwod()
    {
        return 6*bok;
    }
}

public class Test
{
    public static void main(String args[])
    {
        Figura figura = null;
        try
        {
            switch(args[0])
            {
                case "o":
                    figura = new Kolo(Double.parseDouble(args[1]));
                    break;
                case "p":
                    figura = new Pieciokat(Double.parseDouble(args[1]));
                    break;
                case "s":
                    figura = new Szesciokat(Double.parseDouble(args[1]));
                    break;
                case "c":
                    if (!args[5].equals("90")) figura = new Romb(args);
                    else if (args[1].equals(args[2]) && args[2].equals(args[3]) && args[3].equals(args[4]))
                    { 
                        figura = new Kwadrat(Double.parseDouble(args[1]));
                    }
                    else figura = new Prostokat(args);
                    break;
            }
        }
        catch(ArithmeticException e)
        {
            System.err.println("Nieprawidlowe dane");
            System.exit(0);
        }
        if (figura != null) figura.wypiszDane();
        else System.out.println("Nieprawidlowe dane");
    }
}