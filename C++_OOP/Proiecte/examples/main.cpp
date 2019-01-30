#include <iostream>
#include <algorithm>
#include <math.h>
#include <vector>
using namespace std;

int seqSearch(int arr[],int key){

    for(unsigned int i=0;i<100000;i++){
        cout<<endl<<"Pasul "<<i<<":"<<endl<<"arr[i]: "<<arr[i]<<endl;
        if (arr[i]==key){
            return i;
        }

    }
return -1;
}

int main()
{
   vector<int> test(10);

   test.at(1)=1;
   test.at(2)=2;
   test.at(3)=3;
   test.at(4)=4;
   test.at(5)=5;
   test.at(6)=6;
   test.at(7)=7;
   test.at(8)=8;
   test.at(9)=9;

    cout<<test.size()<<" "<<test.at(test.size()-1)<<" "<<test.at(0);
    return 0;
}




