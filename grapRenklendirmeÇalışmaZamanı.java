public class grapRenklendirmeÇalışmaZamanı { 
    final int köşeSayısı = 4; //--------------------------------->1
    int[] renkler; //---------------------------------------->1
                                                        //+2
    
    boolean renkAtamaKontrolü(int köşeSayısı, int grap[][], int renk[], 
                   int c) 
    { 
        for (int i = 0; i < köşeSayısı; i++){ //---------------------------------------->köşeSayısı
            if (grap[köşeSayısı][i] == 1 && c == renk[i]){ //---------------------------------------->köşeSayısı
                return false; //---------------------------------------->köşeSayısı
            }
                 }
        return true;//---------------------------------------->1
    }                                                     //3*köşeSayısı+1
  
    boolean grapKontrolü(int grap[][], int renkSayısı, 
                              int renkler[], int köşe) 
    { 
        if (köşe == köşeSayısı)//---------------------------------------->1
            return true; //---------------------------------------->1
  
        for (int c = 1; c <= renkSayısı; c++) //---------------------------------------->renkSayısı
        { 
            if (renkAtamaKontrolü(köşe, grap, renkler, c)) //---------------------------------------->renkSayısı
            { 
                renkler[köşe] = c; //---------------------------------------->renkSayısı
  
                if (grapKontrolü(grap, renkSayısı,renkler, köşe + 1))//-------------------- >renkSayısı 
                    return true; //---------------------------------------->renkSayısı
              renkler[köşe] = 0; //---------------------------------------->renkSayısı
            } 
        } 
  
        return false; //---------------------------------------->1
    }//---------------------------------------------------->6*renkSayısı+3 
  
    boolean grapRenklendirme(int grap[][], int renkSayısı) 
    { 
        renkler = new int[köşeSayısı]; //---------------------------------------->1
        for (int i = 0; i < köşeSayısı; i++)//---------------------------------------->köşeSayısı 
            renkler[i] = 0; //---------------------------------------->köşeSayısı
  
        if (!grapKontrolü(grap, renkSayısı, renkler, 0)) //-------------------- ->1 
        { 
            System.out.println("Renklendirme yapılamadı"); //----------- -->1
            return false; //---------------------------------------->1
        } 
  
        ekranaÇıktıyıYazdırma(renkler); //---------------------------------------->1
        return true; //---------------------------------------->1
    } //------------------------------------------------------------>2*köşeSayısı+6 
  
    void ekranaÇıktıyıYazdırma(int renkler[]) 
    { 
        System.out.println("Renklendirme yapıldı : Renkler sırasıyla aşağıdadır."); //--->1
        for (int i = 0; i < köşeSayısı; i++) //---------------------------------------->köşeSayısı
            System.out.print(" " + renkler[i] + " "); //----- ------>köşeSayısı
        System.out.println(); //---------------------------------------->1
    } //-------------------------------------------------------------------->2*köşeSayısı+2
  
    public static void main(String args[]) 
    { 
        grapRenklendirmeÇalışmaZamanı Coloring = new grapRenklendirmeÇalışmaZamanı(); //----->1
        /*(3)---(2) 
           |   / |     3---2439388085330         24527207066600
           |  /  |     4---24431601529100
           | /   |         24457387861400
          (0)---(1)        24561589543300
        */
        int grap[][] = {
            {0, 1, 1,1}, 
            {1, 0, 1,0}, 
            {1, 1, 0,1},
            {1, 0, 1,1},
        }; //---------------------------------------->1
        int renkSayısı = 3; //---------------------------------------->1
        Coloring.grapRenklendirme(grap, renkSayısı); //---------------------------------------->1
        System.out.println("Geçen süre : "+System.nanoTime());
    } //------------------------------------------------------------------------>4
} ////Bu algoritmanın yürütme zamanı =7*köşeSayısı+6*renkSayısı+19
//HAZIRLAYAN: ÖMER CENGİZ 16260056
