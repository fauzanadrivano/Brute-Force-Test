package Simulasi_Hekel;

import java.util.Scanner;

class BruteForce {
    String password = "@Fauzan123";

    void login() {
        String inputan;
        Scanner x = new Scanner(System.in);
        do {
            System.out.println("-------------------------------------");
            System.out.println("| Masukkan Username : Admin123");
            System.out.print("| Masukkan Password : ");
            inputan = x.next();
            if (inputan.equals(password)) {
                System.out.println("| Anda berhasil login !!!");
                System.exit(0);
            } else {
                System.out.println("| Password salah !!!");
                menu();
            }
        } while (!inputan.equals(password));
    }

    int bruteForce(String password, String pattern) {
        int pertama = password.length();
        int kedua = pattern.length();
        for (int i = 0; i < pertama - kedua + 1; i++) {
            int j = 0;
            while ((j < kedua) && (password.charAt(i + j) == pattern.charAt(j))) {
                j++;
            }
            if (j == kedua) {
                return i;
            }
        }
        return -1;
    }

    void inputan() {
        String pattern;
        Scanner y = new Scanner(System.in);
        System.out.println("-------------------------------------");
        System.out.print("| Masukkan pattern : ");
        pattern = y.next();

        int posisi = bruteForce(password, pattern);

        if (posisi == -1) {
            System.out.println("| Pattern tidak cocok !!!");
        } else {
            System.out.println("| Pattern ditemukan di urutan ke : " + (posisi + 1) + " sampai ke : " + (posisi + pattern.length()));
        }
        menu();
    }

    void menu() {
        int pilihan;
        Scanner x = new Scanner(System.in);
        System.out.println("\n|===== Simulasi Hekel ======|");
        System.out.println("| 1. Login                  |");
        System.out.println("| 2. Tebak Kemungkinan      |");
        System.out.println("| 3. Keluar                 |");
        System.out.println("|===========================|");

        try {
            System.out.print("| Masukkan pilihan : ");
            pilihan = x.nextInt();
            switch (pilihan) {
                case 1:
                    login();
                case 2:
                    inputan();
                case 3:
                    System.out.println("Terima kasih :)");
                    System.exit(0);
                default:
                    System.out.println("Inputan tidak valid !!!");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("Inputan tidak valid !!!");
            menu();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BruteForce x = new BruteForce();
        x.menu();
    }
}
