import Database.DbOperation;

import java.util.Scanner;

public class Main {

    static PDFHelper pdfHelper= new PDFHelper();
    static DbOperation dbOperation=new DbOperation();
    public static void main(String[] args) {

        System.out.println("1. Ispisi sve putne naloge\n " +
                "2. Ispisi putni nalog s odredenim IDem");

        Scanner unos = new Scanner(System.in);
        int izbor= Integer.parseInt(unos.nextLine());
        switch (izbor){
            case 1:
                dbOperation.IspisSvih();
                break;
            case 2:
                int id= Integer.parseInt(unos.nextLine());
                pdfHelper.PDFwriter(id);
                break;
            default:
                break;

        }


    }
}
