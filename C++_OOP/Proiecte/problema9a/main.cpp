#include <iostream>

using namespace std;

int main()
{
    int a,b,c,d,e,f;

    cin>>a>>b>>c>>d>>e>>f;

    int comp_a,comp_e,comp_c;

    comp_a = a*f;
    comp_e = b*e;
    comp_c = f*c;

    if(comp_a<=comp_e){
        cout<<"True";
    }
    else{
        if(comp_e<=comp_c){
            cout<<"True";
        }
        else{
            cout<<"False";
        }
    }
    return 0;
}
