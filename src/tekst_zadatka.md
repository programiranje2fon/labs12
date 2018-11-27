#Laboratorijske vežbe – dvočas br. 12



##Zadatak 1
*(radi ga laborant u saradnji sa studentima)*

1. Napisati klasu **Konvertor** u paketu zadatak1.poslovna_logika koja ima:

2. Javnu statičku metodu **konvertujDUE** koja kao ulazni argument dobija iznos u dinarima (realan broj). Ova
metoda konvertuje ovaj iznos u evre i vraća ga (1EUR = 120DIN).

3. Javnu statičku metodu **konvertujEUD** koja kao ulazni argument dobija iznos u evrima (realan broj). Ova
metoda konvertuje ovaj iznos u dinare i vraća ga (1EUR = 120DIN).

4. Napraviti klasu **KonvertorGUI** u paketu **zadatak1.gui** koja izgleda kao na slici i povezati
je sa klasom Konvertor tako da se:

5. Na pritisak dugmeta **Konvertuj DUE** dinarski iznos koji je upisan u levo polje za unos konvertuje u evre i prikaže u desnom polju za unos. 

6. Na pritisak dugmeta **Konvertuj EUD** iznos u evrima koji je upisan u desno polje za unos konvertuje u dinare i prikaže u levom polju za unos.


##Zadatak 2
*(studenti rade sami)*

1. Napisati javnu klasu **BMIKalkulator** u paketu **zadatak2.poslovna_logika** koja ima:

2. Javnu statičku metodu **izracunajBMI** koja kao ulazni argument dobija visinu i težinu čoveka
(realni brojevi). Visina je data u metrima a težina u kilogramima. Metoda izračunava i vraća
BMI tj. Body Mass Index po formuli BMI = težina (kg)/[visina(m)]2

3. Napisati klasu **BMIKalkulatorGUI** u paketu **zadatak2.gui** kojom se kreira korisnički
interfejs prikazan na sledećoj slici. Potrebno je obezbediti da nakon što korisnik unese podatke o
visini i težini u odgovarajuća polja i klikne na dugme ‘Izracunaj BMI’ u polju BMI se ispisuje
izračunata vrednost BMI (Body Mass Index)-a.