//package gudangsepatu07256;
//
//import Controller07256.SepatuController07256;
//import Entites07256.SepatuEntity07256;
//
//import java.util.Scanner;
//
//public class GudangSepatu07256 {
//    private final Scanner scan = new Scanner(System.in);
//    private final SepatuController07256 sepatuController07256 = new SepatuController07256();
//
//    public void run(){
//        menu();
//    }
//
//    private void menu() {
//        int pil07256 = -1;
//        do{
//            System.out.println("""
//                1. Create sepatu
//                2. Read sepatu
//                3. Update sepatu
//                4. Delete sepatu
//                0. Exit
//                """);
//            System.out.print("Input : ");
//            pil07256 = scan.nextInt();
//            System.out.println();
//
//            switch (pil07256){
//                case 1 -> createSepatu();
//                case 2 -> readSepatu();
//                case 3 -> updateSepatu();
//                case 4 -> delete07256();
//                case 0 -> System.out.println("Exit");
//                default -> System.out.println("Input tidak ada");
//            }
//        }while (pil07256!=0);
//
//    }
//
//    private void createSepatu(){
//        System.out.print("Nama sepatu : ");
//        String nama07256 = scan.next();
//        System.out.print("Stock tersedia : ");
//        int stock07256 = scan.nextInt();
//        System.out.print("Ukuran sepatu : ");
//        int size07256 = scan.nextInt();
//        int udp = sepatuController07256.createSepatu07256(new SepatuEntity07256(0,nama07256,stock07256,size07256));
//        if(udp > 0)
//            System.out.println("Sepatu berhasil ditambahkan");
//        else
//            System.out.println("Gagal menambahkan sepatu");
//    }
//
//    private void readSepatu(){
//        if(sepatuController07256.getSepatu07256().size()>0){
//            for(SepatuEntity07256 sepatu : sepatuController07256.getSepatu07256()) {
//                System.out.println("Id    : " + sepatu.getId07256());
//                System.out.println("Nama  : " + sepatu.getNama07256());
//                System.out.println("Stock : " + sepatu.getStock07256());
//                System.out.println();
//            }
//        }else
//            System.out.println("Tidak ada daftar sepatu");
//    }
//
//    private void updateSepatu(){
//        System.out.print("Input id yang akan di UPDATE : ");
//        int id = scan.nextInt();
//
//        if(sepatuController07256.getSepatu07256(id) > 0){
//            System.out.println("1. Edit nama");
//            System.out.println("2. Edit stock");
//            System.out.print("Pilih : ");
//            int pil07256 = scan.nextInt();
//
//            switch (pil07256){
//                case 1 : {
//                    System.out.print("Input nama baru : ");
//                    String newName07256 = scan.next();
//                    int cek = sepatuController07256.updateSepatu07256(id,newName07256);
//                    if(cek > 0)
//                        System.out.println("Update berhasil");
//                    else
//                        System.out.println("Update gagal");
//                break;
//                }
//                case 2 : {
//                    System.out.print("Input stock baru : ");
//                    int newStock07256 = scan.nextInt();
//                    int cek = sepatuController07256.updateSepatu07256(id,newStock07256);
//                    if(cek > 0)
//                        System.out.println("Update berhasil");
//                    else
//                        System.out.println("Update gagal");
//                break;
//                }
//                default:
//                    System.out.println("Input tidak ditemukan");
//            }
//        }else
//            System.out.println("Id tidak ditemukan");
//    }
//
//    private void delete07256(){
//        System.out.print("Input id yang akan di DELETE : ");
//        int id07256 = scan.nextInt();
//
//        if(sepatuController07256.getSepatu07256(id07256) > 0){
//            int del07256 = sepatuController07256.deleteSepatu07256(id07256);
//            if(del07256>0){
//                System.out.println("Delete berhasil");
//            }else{
//                System.out.println("Delete gagal");
//            }
//        }else
//            System.out.println("Id tidak ditemukan");
//    }
//}
