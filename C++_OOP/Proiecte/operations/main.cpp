#include <iostream>

using namespace std;

int main()
{
    int a,b;
    int suma,produs,diferenta,quotient;

    cout<<"Primul numar: ";
    cin>>a;
    cout<<endl<<"Al doilea numar: ";
    cin>>b;
    cout<<endl;

    suma = a+b;
    produs = a*b;
    diferenta = a-b;
    quotient = a/b;

    cout<<"Suma este: "<<suma<<endl;
    cout<<"Diferenta este: "<<diferenta<<endl;
    cout<<"Produsul este: "<<produs<<endl;
    cout<<"Catul este: "<<quotient<<endl;
    return 0;
}
