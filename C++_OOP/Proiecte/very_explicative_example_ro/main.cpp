#include <iostream> // aici includem libraries. IOstream este biblioteca care ne ajuta sa afisam pe ecran si sa citim de la tastatura (IO - input output)
//putem sa includem mai multe chestii care sunt in C++ Standard Library
#include <string> // string e o biblioteca care ne permite sa lucram cu siruri de caractere (aka cuvinte)

using namespace std;

int main()
{   //IMPORTANT: La sfarsitul fiecarei instructiuni sa pui ;
    // Variabilele sunt ca niste cutii in care bagi valori (numere, litere, semne, etc)
    // astea sunt comentarii. Chestii care le punem ca sa intelegem programul dar care nu influenteaza deloc programul.

    int a; //asta este o variabila cu numele a. int vine de la integer care inseamna numar intreg.

    a = 1; //aici indicam ca in variabila a, bagam valoarea 1

    char c; // asta e o variabile de tip char cu numele c. In ea putem baga caractere de la tastatura.

    c = 'a'; // am bagat valoarea 'a'

    // Hai sa facem un program care te intreaba cati ani ai si dupa iti spune in ce an te-ai nascut. (aprox)

    int an_curent = 2017; //aici avem variabila in care tinem anul curent. Ii dam si valoarea direct (se poate)

    int varsta_userului; //aici ne declaram o variabila in care nu bagam inca nicio valoare ca nu o stim.
    //user-ul trebuie sa o introduca de la tastatura cand ii cerem.

    cout<<"Cati ani ai?"<<endl; //cu cout<< afisam pe ecran. Este din biblioteca IOstream. endl inseamna endline.

    cin>>varsta_userului; // cu cin il punem pe utilizator sa scrie de la tastatura. In cazul acesta el va trebui sa scrie un numar si dupa sa dea enter.
    // numarul ala e salvat in cutia cu numele "varsta_userului" si apoi il putem folosi mai departe in program.
    // IMPORTANT: daca la cin intentionam sa salvam intr-o variabila de tip int (integer/numar intreg), trebuie sa ii dam un int, altfel crapa.

    int an_nastere; //aici ne declaram o variabila in care vom pune anul nasterii dupa ce il calculam.

    an_nastere = an_curent - varsta_userului;
    //calculam anul nasterii (aproximativ, exista multe cazuri pe care nu le-am acoperit, sa mi le zici tu care sunt).

    cout<<"Anul nasterii este: "<<an_nastere;
    //Afisam rezultatul pe ecran.
    return 0;
}
