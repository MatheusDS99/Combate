package Combate;

import java.util.Scanner;

public class Champion{
    String name;
    int life;
    int attack;
    int armor;

    public Champion(String name, int life, int attack, int armor){
        this.name=name;
        this.life=life;
        this.attack=attack;
        this.armor=armor;
    }

    void setName(String name){
        this.name=name;
    }
    void setLife(int life){
        this.life=life;
    }
    void setAttack(int attack){
        this.attack=attack;
    }
    void setArmor(int armor){
        this.armor=armor;
    }

    String getName(){
        return name;
    }
    int getLife(){
        return life;
    }
    int getAttack(){
        return attack;
    }
    int getArmor(){
        return armor;
    }

    public void corrigir (Scanner input){
        while(getLife()<=0){
            System.out.println("Valor de vida insuficiente para iniciar o jogo. Digite novamente: ");
            this.life=input.nextInt();
        }
        while(getAttack()<=0){
            System.out.println("Valor de ataque insuficiente para iniciar o jogo. Digite novamente: ");
            this.attack=input.nextInt();
        }
        while(getArmor()<=0){
            System.out.println("Valor de armadura insuficiente para iniciar o jogo. Digite novamente: ");
            this.armor=input.nextInt();
        }
    }

    public void takeDamage(Champion champion){
        if (champion.getAttack()<this.getArmor())
            this.life-=1;
        else
            this.life-=(champion.getAttack()-this.armor);
        if (this.life<0)
            this.life = 0;

    }

    public String status(){
        return  (getLife()==0) ? String.format("%s: 0 de vida (morreu)", getName()):
                String.format("%s: %d de vida", getName(), getLife());
    }

}