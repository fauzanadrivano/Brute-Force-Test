package Daftar_Kependudukan;

import java.util.ArrayList;
import java.util.Scanner;

public class BruteForce {
    static ArrayList<String> data = new ArrayList<>();
    static Scanner x = new Scanner(System.in);
    static Scanner y = new Scanner(System.in);
    static Scanner z = new Scanner(System.in);
    static String input;

    static void inputan() {
        String inputan;
        do {
            try {
                System.out.println("----------------------------------------");
                System.out.print("| Masukkan Nomor Penduduk : ");
                inputan = x.next();
                data.add(inputan);
                ulang();
            } catch (Exception e) {
                System.out.println("| Inputan Tidak Valid !!!");
                ulang();
            }
        } while (input.equals("y"));
    }

    static void urutkan() {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.size() - i - 1; j++) {
                if (data.get(j).compareTo(data.get(j + 1)) > 0) {
                    String swap = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, swap);
                }
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("| Daftar Tersedia ");
        for (String a : data) {
            System.out.println("| " + a);
        }
        System.out.println("----------------------------------------");
    }

    static void cari() {
        String cari;
        System.out.println("----------------------------------------");
        System.out.print("| Masukkan kode yang ingin dicari : ");
        cari = z.next();
        int result = search(cari);
        int urutan = result + 1;

        if (result == -1)
            System.out.print("| Kode tidak ditemukan !!!");
        else
            System.out.print("| Kode ditemukan di urutan ke : " + urutan);
    }

    static int search(String cari) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).equals(cari))
                return i;
        }
        return -1;
    }

    static void menu() {
        int pilihan;
        Scanner x = new Scanner(System.in);
        System.out.println("\n|====== Kependudukan =======|");
        System.out.println("| 1. Tambah                 |");
        System.out.println("| 2. Daftar Kode Penduduk   |");
        System.out.println("| 3. Cari Kode Penduduk     |");
        System.out.println("| 4. Keluar                 |");
        System.out.println("|===========================|");

        try {
            System.out.print("| Masukkan pilihan : ");
            pilihan = x.nextInt();
            switch (pilihan) {
                case 1:
                    inputan();
                case 2:
                    urutkan();
                    menu();
                case 3:
                    cari();
                    menu();
                case 4:
                    System.out.println("| Terima kasih :)");
                    System.exit(0);
                default:
                    System.out.println("| Inputan tidak valid !!!");
                    menu();
            }
        } catch (Exception e) {
            System.out.println("| Inputan tidak valid !!!");
            menu();
        }
    }

    static void ulang() {
        try {
            System.out.println("----------------------------------------");
            System.out.println("| Ingin input data penduduk lagi ?");
            System.out.print("| y/n : ");
            input = y.next();
            if (input.equals("y")) {
                inputan();
            } else if (input.equals("n")) {
                menu();
            } else {
                System.out.println("| Inputan tidak valid !!!");
                ulang();
            }
        } catch (Exception e) {
            System.out.println("| Inputan tidak valid !!!");
            ulang();
        }
    }

    public static void main(String[] args) {
        menu();
    }
}
