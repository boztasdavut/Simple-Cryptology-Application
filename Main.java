package Howto;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Graphics;
import javax.swing.JPanel;
public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int secim;
		int sayi;
		System.out.println("Bir degeri kripto etmek için 1, Kripto edilmiş bir değeri çözmek için 2 tiklayiniz.");
		secim = scanner.nextInt();
		if(secim == 1) {
			System.out.println("Kripto etmek istediginiz sayiyi giriniz: ");
			sayi = scanner.nextInt();
			int sifreliSayi = kriptoEt(sayi);
			System.out.printf("Sayinin orjinal hali: %d, Kriptolu hali: %d",sayi,sifreliSayi);
		}
		else if(secim == 2) {
			System.out.println("Cozmek istediginiz ifadeyi giriniz: ");
			sayi = scanner.nextInt();
			int cozulmusSayi = kriptoCoz(sayi);
			System.out.printf("İfade: %d, Cozulmus hali: %d",sayi, cozulmusSayi);
		}
		
		
		
		
		 
		
		
		
		
	}
	public static int kriptoEt(int sayi)
	{
		int decimal = 1;
		int basamakliKriptoEdilmisSayi = 0;
		
		while(sayi>0)
		{
			basamakliKriptoEdilmisSayi = basamakliKriptoEdilmisSayi+(((sayi%10)+7)%10)*decimal;
			sayi = sayi/10;
			decimal*=10;
		}
		
		int sayi2 = 0;
		int controller = 0;
		while(controller<=3)
		{
			if(controller==0)
			{
				sayi2 = (int) (sayi2 + (basamakliKriptoEdilmisSayi%10)*Math.pow(10,controller+2));
				basamakliKriptoEdilmisSayi = basamakliKriptoEdilmisSayi/10;
			}else if(controller==1) {
				
					sayi2 = (int) (sayi2 + (basamakliKriptoEdilmisSayi%10)*Math.pow(10,controller+2));
					basamakliKriptoEdilmisSayi = basamakliKriptoEdilmisSayi/10;
				
				
			}else if(controller == 2) {
				sayi2 = (int) (sayi2 + (basamakliKriptoEdilmisSayi%10)*Math.pow(10,controller-2));
				basamakliKriptoEdilmisSayi = basamakliKriptoEdilmisSayi/10;
			}else if(controller == 3) {
				sayi2 = (int) (sayi2 + (basamakliKriptoEdilmisSayi%10)*Math.pow(10,controller-2));
				basamakliKriptoEdilmisSayi = basamakliKriptoEdilmisSayi/10;
			}
			
			controller+=1;
		}
		return sayi2;
	}
	public static int kriptoCoz(int sayi)
	{
		int controller = 0;
		int sayi2 = 0;
		int sayi3 = 0;
		if(basamakSayisiBul(sayi) == 3)
		{
			//sayi2 = sayi2+10;
			sayi2 = sayi2+(sayi/10)%10*1000;
			
		}else {
			sayi2 = sayi2+(sayi/10)%10*1000;
			sayi2 = sayi2 + (sayi/1000)*10;
		}
		sayi2 = sayi2+ (sayi%10)*100;
		sayi2 = sayi2+(sayi/100)%10*1;
		System.out.println(sayi2);
		while(controller <4)
		{
			int x= sayi2%10;
			if(x == 0) {
				sayi3+=30;
			}else {
				
				if((x%10)-7<0) {
					sayi3+=(x%10+3)*Math.pow(10, controller);
				}else {
					sayi3+=(x%10-7)*Math.pow(10, controller);
				}
			}
			sayi2/=10;
			controller+=1;
		}
		return sayi3;
	}
	public static int basamakSayisiBul(int sayi)
	{
		int sayac = 0 ;
		while(sayi>0)
		{
			sayi = sayi/10;
			sayac++;
		}
		return sayac;
	}
}

