/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sys.wbud;

import pl.sys.wbud.Syswbud;

/**
 *
 * @author Andrzej
 */
public class Wybory {
    double[][] wyniki = new double[15][14];
    double licznikgodzin=1.0;

    public double nrindexu;
    
    public Wybory(double nrindexu) {
        //Syswbud sys = new Syswbud();
        //this.nrindexu = sys.indeks;
        //double nrindexu = 23189;
        for (int i=0; i<=6; i++){
            wyniki[i][12] = Math.round((((nrindexu/470.0)*licznikgodzin-(7.0-licznikgodzin)*(7.0-licznikgodzin)))); // kart wydanych przez komisje
            
            wyniki[i][8] = 0; // glosow zle wypelnionych
            wyniki[i][9] = Math.round(wyniki[i][12] * 7/100); // glosow pustych
            wyniki[i][10] = wyniki[i][8] + wyniki[i][9]; // lacznie glosow niewaznych
            
            wyniki[i][6] = wyniki[i][12] - wyniki[i][10] ; // glosow waznych
            
            wyniki[i][0] = Math.round((wyniki[i][6] * 15.0/100.0)); // kandC
            wyniki[i][2] = Math.round((wyniki[i][6] * 25.0/100.0)); // kandB
            wyniki[i][4] = Math.round((wyniki[i][6] * 60.0/100.0)); // kandA
            
            wyniki[i][1] = Math.round(wyniki[i][0] / wyniki[i][6] * 100.0); // %kandC
            wyniki[i][3] = Math.round(wyniki[i][2] / wyniki[i][6] * 100.0); // %kandB
            wyniki[i][5] = Math.round(wyniki[i][4] / wyniki[i][6] * 100.0); // %kandA
            
            wyniki[i][13] = wyniki[i][6];
            wyniki[i][7] = Math.round(wyniki[i][6] * 100.0 / wyniki[i][12]); //wyniki[i][6] / wyniki[i][13] * 100; // %glosow waznych
            
            wyniki[i][11] = wyniki[i][12]; // kart wrzuc. do urny
            
            licznikgodzin++;
        }
        
        for (int i=7; i<=13; i++){
            wyniki[i][12] = Math.round((nrindexu/470.0)*(15.0-licznikgodzin)-(8.0-licznikgodzin)*(8.0-licznikgodzin)); // kart wydanych przez komisje
            
            wyniki[i][8] = Math.round(wyniki[i][12] * 7/100); // glosow zle wypelnionych
            wyniki[i][9] = 0; // glosow pustych
            wyniki[i][10] = wyniki[i][8] + wyniki[i][9]; // lacznie glosow niewaznych
            
            wyniki[i][6] = wyniki[i][12] - wyniki[i][10] ; // glosow waznych
            
            wyniki[i][0] = Math.round((wyniki[i][6] * 15.0/100.0)); // kandC
            wyniki[i][2] = Math.round((wyniki[i][6] * 25.0/100.0)); // kandB
            wyniki[i][4] = Math.round((wyniki[i][6] * 60.0/100.0)); // kandA
            
            wyniki[i][1] = Math.round(wyniki[i][0] / wyniki[i][6] * 100); // %kandC
            wyniki[i][3] = Math.round(wyniki[i][2] / wyniki[i][6] * 100); // %kandB
            wyniki[i][5] = Math.round(wyniki[i][4] / wyniki[i][6] * 100); // %kandA
            
            wyniki[i][13] = wyniki[i][6];
            wyniki[i][7] = Math.round(wyniki[i][6] * 100.0 / wyniki[i][12]); // %glosow waznych
            
            wyniki[i][11] = wyniki[i][12]; // kart wrzuc. do urny
            
            licznikgodzin++;
        }
        
        wyniki[14][0] = 0;
        for (int i=0; i<=13; i++){ // obliczanie sum
            wyniki[14][i] = 0;
            for (int j=0; j<=13; j++){
                wyniki[14][i] = wyniki[14][i] + wyniki[j][i];
            }
            
        }
             
        System.out.println(nrindexu);
    
    }
    
}
