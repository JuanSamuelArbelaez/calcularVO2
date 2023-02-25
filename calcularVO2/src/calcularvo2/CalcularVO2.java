package calcularvo2;

import javax.swing.JOptionPane;

public class CalcularVO2
{
    public static double leerDouble(String mensaje)
    {
        return Double.parseDouble(JOptionPane.showInputDialog(mensaje));
    }
    
    public static int leerInt(String mensaje)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(mensaje));
    }
    
    public static void imprimir(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static double calcularVO2(double kg, double t, int e, int s, double f)
    {
        double vo2;
        switch(s)
        {
            case 0: vo2=132.6 - (0.17 * kg) - (0.39 * e) - (3.27 * t) - (0.156 * f);
                    break;
            case 1: vo2=132.6 - (0.17 * kg) - (0.39 * e) + (6.31 * s) - (3.27 * t) - (0.156 * f);
                    break;
            default:vo2=0;
                    imprimir("El genero ingresado no es valido");
                    break;
        }
        if (kg<=0)
        {
            vo2=0;
            imprimir("La masa ingresada es invalida");
        }
        if (t<=0)
        {
            vo2=0;
            imprimir("El tiempo ingresado es invalido");
        }
        if (e<=0)
        {
            vo2=0;
            imprimir("La edad ingresada es invalida");
        }
        if (f<=0)
        {
            vo2=0;
            imprimir("La frecuencia cardiaca ingresada es invalida");
        }
        return vo2;
    }
    
    public static String calcularClasificacion(int s, double vo2, int e)
    {
        String clasificacion="Indeterminada";
        
        switch (s)
        {
            case 0:
                if (e>=20 && e <30)
                {
                    if (vo2<35) clasificacion="Baja";
                    if (vo2>=35 && vo2<41) clasificacion="Debajo del promedio";
                    if (vo2>=41 && vo2<49) clasificacion="Promedio";
                    if (vo2>=49 && vo2<55) clasificacion="Sobre el promedio";
                    if (vo2>=55)clasificacion="Alta";
                }
                if (e>=30 && e <40)
                {
                    if (vo2<31) clasificacion="Baja";
                    if (vo2>=31 && vo2<38) clasificacion="Debajo del promedio";
                    if (vo2>=38 && vo2<43) clasificacion="Promedio";
                    if (vo2>=43 && vo2<49) clasificacion="Sobre el promedio";
                    if (vo2>=49)clasificacion="Alta";
                }
                if (e<=40 && e <50)
                {
                    if (vo2<25) clasificacion="Baja";
                    if (vo2>=25 && vo2<32) clasificacion="Debajo del promedio";
                    if (vo2>=32 && vo2<40) clasificacion="Promedio";
                    if (vo2>=40 && vo2<46) clasificacion="Sobre el promedio";
                    if (vo2>=46)clasificacion="Alta";
                }
                if (e>=50 && e <60)
                {
                    if (vo2<20) clasificacion="Baja";
                    if (vo2>=20 && vo2<26) clasificacion="Debajo del promedio";
                    if (vo2>=26 && vo2<34) clasificacion="Promedio";
                    if (vo2>=34 && vo2<40) clasificacion="Sobre el promedio";
                    if (vo2>=40)clasificacion="Alta";
                }
                if (e>=60)
                {
                    if (vo2<17) clasificacion="Baja";
                    if (vo2>=17 && vo2<24) clasificacion="Debajo del promedio";
                    if (vo2>=24 && vo2<31) clasificacion="Promedio";
                    if (vo2>=31 && vo2<38) clasificacion="Sobre el promedio";
                    if (vo2>=38)clasificacion="Alta";
                }
                break;
            
            case 1:
                if (e>=20 && e <30)
                {
                    if (vo2<32) clasificacion="Baja";
                    if (vo2>=35 && vo2<41) clasificacion="Debajo del promedio";
                    if (vo2>=41 && vo2<49) clasificacion="Promedio";
                    if (vo2>=49 && vo2<55) clasificacion="Sobre el promedio";
                    if (vo2>=55)clasificacion="Alta";
                }
                if (e>=30 && e <40)
                {
                    if (vo2<35) clasificacion="Baja";
                    if (vo2>=35 && vo2<41) clasificacion="Debajo del promedio";
                    if (vo2>=41 && vo2<49) clasificacion="Promedio";
                    if (vo2>=49 && vo2<55) clasificacion="Sobre el promedio";
                    if (vo2>=55)clasificacion="Alta";
                }
                if (e>=40 && e <50)
                {
                    if (vo2<35) clasificacion="Baja";
                    if (vo2>=35 && vo2<41) clasificacion="Debajo del promedio";
                    if (vo2>=41 && vo2<49) clasificacion="Promedio";
                    if (vo2>=49 && vo2<55) clasificacion="Sobre el promedio";
                    if (vo2>=55)clasificacion="Alta";
                }
                if (e>=50)
                {
                    if (vo2<35) clasificacion="Baja";
                    if (vo2>=35 && vo2<41) clasificacion="Debajo del promedio";
                    if (vo2>=41 && vo2<49) clasificacion="Promedio";
                    if (vo2>=49 && vo2<55) clasificacion="Sobre el promedio";
                    if (vo2>=55)clasificacion="Alta";
                }
                break;
            
            default:
                break;
        }
        return clasificacion;
    }
    
    public static void main(String[] args)
    {
        String cl;
        double f, t, kg, vo2;
        int e, s;
        
        s=leerInt("Ingrese el sexo: ");
        e=leerInt("Ingrese la edad: ");
        kg=leerDouble("Ingrese la masa corporal: ");
        t=leerDouble("Ingrese el tiempo consumido en la prueba de la milla: ");
        f=leerDouble("Ingrese la frecuencia cardiaca: ");
        
        vo2=calcularVO2(kg, t, e, s, f);
        cl=calcularClasificacion(s, vo2, e);
        
        imprimir("El volumen de oxigeno es "+vo2+", y su clasificacion es: "+cl);
    }
    
}
