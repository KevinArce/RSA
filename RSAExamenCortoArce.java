/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsa.examen.corto.arce;

// Agregamos los imports que usaremos para el programa
import java.math.*;
import java.util.*;

/**
 *
 * @author kevin
 */
public class RSAExamenCortoArce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Declaramos nuestras variables
        int p, q, n, z, d = 0, e, i;
 
        // El numero que encriptaremos y descencriptaremos
        int msg = 12;
        double c;
        BigInteger msgback;
 
        // Primer numero primo p, aqui solicitamos el primer numero primo a traves de la consola
        //Como recomendacion podria ser 419
        Scanner sc= new Scanner(System.in); 
        System.out.print("Escribe el primer numero primo: "); 
        p = sc.nextInt();
        
        // Segundo numero primo q, aqui solicitamos el primer numero primo a traves de la consola
        //Como recomendacion podria ser 461
        System.out.print("Escribe el segundo numero primo: "); 
        q = sc.nextInt();  
 
        n = p * q;
        z = (p - 1) * (q - 1);
        System.out.println("El valor de Z es: " + z);
 
        for (e = 2; e < z; e++) {
 
            // e sera nuestra clave publica
            if (gcd(e, z) == 1) {
                break;
            }
        }
        System.out.println("El valor de e es: " + e);
        for (i = 0; i <= 9; i++) {
            int x = 1 + (i * z);
 
            // d sera nuestra llave privada
            if (x % e == 0) {
                d = x / e;
                break;
            }
        }
        System.out.println("El valor de d es: " + d);
        c = (Math.pow(msg, e)) % n;
        System.out.println("Mensaje encriptado: " + c);
 
        // Aqui convertimos un valor entero a BigInteger
        BigInteger N = BigInteger.valueOf(n);
 
        // Convertimos el valor flotante de c a BigInteger
        BigInteger C = BigDecimal.valueOf(c).toBigInteger();
        msgback = (C.pow(d)).mod(N);
        System.out.println("Mensaje descencriptado: "
                           + msgback);
    }
 
    static int gcd(int e, int z)
    {
        if (e == 0)
            return z;
        else
            return gcd(z % e, e);
    }
    
}
