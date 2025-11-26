package Pertemuan14;

import java.util.Scanner;

public class Kafe05 {
    public static void Menu(String namaPelanggan, boolean isMember, String kodePromo) {
        System.out.println("Selamat datang, " + namaPelanggan + "!");

        if (isMember){
            System.out.println("Anda adalah member. dapatkan diskon 10% untuk setiap pembelian!");
        }

        if (kodePromo.equals("DISKON50")){
            System.out.println("Kode promo valid! Anda mendapatkan diskon 50%");
        }else if (kodePromo.equals("DISKON30")){
            System.out.println("Kode promo valid! Anda mendapatkan diskon 30%");
        }else{
            System.out.println("Kode promo tidak valid.");
        }
        System.out.println("==== MENU RESTO KAFE ====");
        System.out.println("1. Kopi Hitam - Rp 15,000");
        System.out.println("2. Cappuccino - Rp 20,000");
        System.out.println("3. Latte - Rp 22,000");
        System.out.println("4. Teh Tarik - Rp 12,000");
        System.out.println("5. Roti Bakar - Rp 10,000");
        System.out.println("6. Mie Goreng - Rp 18,000");
        System.out.println("=========================");
        System.out.println("Silakan pilih menu yang Anda inginkan.");
    }

    public static int hitungTotalHarga05(int pilihanMenu, int banyakItem, String kodePromo) {
        int [] hargaItems = {15000, 20000, 22000, 12000, 10000, 18000};

        int hargaTotal = hargaItems[pilihanMenu - 1] * banyakItem;

        if(kodePromo.equals("DISKON50")){
            System.out.println("Promo 50% digunakan.");
            hargaTotal = hargaTotal / 2;
        }else if(kodePromo.equals("DISKON30")){
            System.out.println("Promo 30% digunakan.");
            hargaTotal = hargaTotal - (hargaTotal * 30 / 100);
        }else{
            System.out.println("kode promo invalid");
        }
            
        return hargaTotal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Menu("Budi", true, "DISKON30");

       int totalKeseluruhan = 0;
       String kodePromo = "DISKON30";

       boolean lanjut = true;

       while(lanjut){
            System.out.print("Masukkan pilihan menu (1-6): ");
            int pilihanMenu = sc.nextInt();

            System.out.print("Masukkan banyak item: ");
            int banyakItem = sc.nextInt();

            int totalHarga = hitungTotalHarga05(pilihanMenu, banyakItem, kodePromo);
            System.out.println("Total harga untuk item ini: Rp " + totalHarga);

            totalKeseluruhan += totalHarga;

            System.out.print("Apakah Anda ingin memesan lagi? (y/n): ");
            String jawab = sc.next();

            if(jawab.equalsIgnoreCase("n")){
                lanjut = false;
            }
        }
        System.out.println("Total keseluruhan yang harus dibayar: Rp " + totalKeseluruhan);
    }
}
