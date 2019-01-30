#include <iostream>

using namespace std;

int main()
{
    int x=0;
    int suma = 0,produs=1,nrDivizori=0;
    cout<<"x=";
    cin>>x;
    for(int i=1;i<=x/2;i++){
        if(x%i==0){ //testeaza daca i e divizor al lui x
           //testeaza daca i este numar prim numarand divizorii
            nrDivizori = 0;
            for(int j = 1;j<=i;j++){
                if(i%j==0){
                    nrDivizori++;
                }
            }
            if(nrDivizori == 2){ // am numarat si pe 1 si pe el insusi deci trebuie sa aiba 2 divizori.
                    // Se poate optimiza
                suma+=i;
                produs*=i;
            }
        }
    }
    cout<<suma<<" "<<produs;
}
