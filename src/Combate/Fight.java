package Combate;

import java.util.Locale;
import java.util.Scanner;

public class Fight {
    public static void main (String [] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        Champion A = null;
        Champion B = null;

        for (int i = 0; i<=1;i++){
            System.out.printf("Digite os dados do %dº campeão: %n", i+1);
            System.out.print("Nome: ");
            String name = input.nextLine();
            System.out.print("Vida: ");
            int life = input.nextInt();
            System.out.print("Ataque: ");
            int attack = input.nextInt();
            System.out.print("Armadura: ");
            int armor = input.nextInt();

            if (i==0) {
                A = new Champion(name, life, attack, armor);
                A.corrigir(input);
            }
            else {
                B = new Champion(name, life, attack, armor);
                B.corrigir(input);
            }
            input.nextLine();
            System.out.println();
        }

        System.out.print("Digite quantos turnos deseja realizar: ");
        int n = input.nextInt();

        for (int i =0;i<n;i++){
            System.out.printf("Resultado do turno %dº: %n", i+1);
            A.takeDamage(B);
            B.takeDamage(A);
            System.out.println(A.status());
            System.out.println(B.status());
            if (A.getLife() == 0 || B.getLife()==0)
                break;
        }
        System.out.println("FIM DO COMBATE.");


    }

}